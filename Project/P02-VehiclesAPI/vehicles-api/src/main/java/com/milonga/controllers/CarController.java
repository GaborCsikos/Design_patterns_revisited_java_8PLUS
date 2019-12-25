package com.milonga.controllers;

import com.milonga.models.BoobleMapsAddress;
import com.milonga.models.Car;
import com.milonga.models.Price;
import com.milonga.models.PriceResponse;
import com.milonga.persistance.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;
    /**
     * We add RestTemplate as a HTTP client, so we will be able to send HTTP request to another services
     * like PricingService or BoobleMapsService.
     * Thanks RestTemplate we can integrate CarService with the others.
     * */
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * This is the URL that we can configure into application.properties
     * */
    @Value("${pricing.service.url}")
    private String pricingServiceUrl;

    @Value("${booblemaps.service.url}")
    private String boogleMapsServiceUrl;

    /**
     * GET HTTP method without ID is used for return a collection of all elements
     * */
    @GetMapping
    public List<Car> getAll(){
        Iterable<Car> carIterator = carRepository.findAll();
        List<Car> cars = new ArrayList<>();
        carIterator.forEach(car -> {
            this.setCarAddress(car);
            car.setPrice(this.getPrice(car.getId()));
            cars.add(car);
        });
        return cars;
    }

    /**
     * GET HTTP method with ID is used for return a single element
     * */
    @GetMapping("/{id}")
    public Car getCar(@PathVariable("id") Long id){
        Car carResponse = carRepository.findById(id).get();
        this.setCarAddress(carResponse);
        carResponse.setPrice(this.getPrice(carResponse.getId()));
        return carResponse;
    }

    /**
     * POST HTTP method is used for create elements
     * */
    @PostMapping
    public Car createCar(@RequestBody Car car){

        //First, we call the BoobleMaps service in order to get the Address information
        this.setCarAddress(car);

        //Then we can save the Car
        car = carRepository.save(car);

        //Finaly, we send the price to the Price Service
        Price price = new Price("USD", BigDecimal.valueOf(Long.valueOf(car.getPrice())), car.getId());
        ResponseEntity<Price> priceResult = restTemplate.postForEntity(pricingServiceUrl+ "/prices", price, Price.class);
        return car;
    }

    /**
     * PUT HTTP method is used for update elements
     * */
    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    /**
     * DELETE HTTP method is used for delete elements
     * */
    @DeleteMapping
    public void deleteCar(@RequestBody Car car){
        carRepository.delete(car);
    }

    private void setCarAddress(Car car){
        BoobleMapsAddress responseAddress = this.getAddress(car.getLocation().getLat(), car.getLocation().getLon());
        car.getLocation().setAddress(responseAddress.getAddress());
        car.getLocation().setState(responseAddress.getState());
        car.getLocation().setCity(responseAddress.getCity());
        car.getLocation().setZip(responseAddress.getZip());
    }

    private BoobleMapsAddress getAddress(Double lattitude, Double longitud){
        ResponseEntity<BoobleMapsAddress> boobleResult = restTemplate.getForEntity(boogleMapsServiceUrl+ "/maps?lat="+lattitude+"&lon="+longitud, BoobleMapsAddress.class);
        return boobleResult.getBody();
    }

    private String getPrice(Long priceId){
        ResponseEntity<PriceResponse> priceResult = restTemplate.getForEntity(pricingServiceUrl+ "/prices?vehicleid="+priceId, PriceResponse.class);
        return String.valueOf(priceResult.getBody().get_embedded().getPrices().get(0).getPrice());
    }

}
