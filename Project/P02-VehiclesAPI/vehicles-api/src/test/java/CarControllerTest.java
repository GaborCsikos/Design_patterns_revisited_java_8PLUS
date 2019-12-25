import com.fasterxml.jackson.databind.ObjectMapper;
import com.milonga.CarServiceApplication;
import com.milonga.models.Car;
import com.milonga.models.Condition;
import com.milonga.models.Detail;
import com.milonga.models.Location;
import com.milonga.models.Manufacturer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarServiceApplication.class)
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @PersistenceContext
    private EntityManager em;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/car")).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
        List<Car> cars = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        Assert.assertEquals(10, cars.size());
    }

    @Test
    public void getOne() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/car/5")).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
        Car car = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assert.assertEquals("Body I am going to check", car.getDetail().getBody());
        Assert.assertEquals(Long.valueOf(5), car.getId());
    }

    @Transactional
    @Test
    public void createOne() throws Exception {
        Car newCar = new Car();
        newCar.setId(1L);
        newCar.setCondition(Condition.USED);
        Location location = new Location(88888.55, 666666.33);
        location.setCity("La Matanza");
        location.setState("Buenos Aires");
        newCar.setLocation(location);
        Detail detail = new Detail();
        detail.setModel("Sport");
        detail.setBody("new Car added");
        Manufacturer manufacturer = new Manufacturer(1, "Some Guy");
        detail.setManufacturer(manufacturer);
        newCar.setDetail(detail);
        newCar.setPrice("77777.88");

        mockMvc.perform(post("/car").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(newCar))).andReturn();
        em.flush();

        MvcResult mvcResult = mockMvc.perform(get("/car/1")).andReturn();
        Car car = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assert.assertEquals("new Car added", car.getDetail().getBody());
        Assert.assertEquals(Long.valueOf(1), car.getId());
    }

    @Test
    public void updateOne() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/car/7")).andReturn();
        Car car = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assert.assertEquals("wrong body", car.getDetail().getBody());
        Assert.assertEquals(Long.valueOf(7), car.getId());

        //update the car
        car.getDetail().setBody("new body");
        mockMvc.perform(put("/car").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(car))).andReturn();

        //get the same card and see if the body has changed
        mvcResult = mockMvc.perform(get("/car/7")).andReturn();
        Car newCar = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assert.assertEquals("new body", newCar.getDetail().getBody());
        Assert.assertEquals(Long.valueOf(7), newCar.getId());
    }

    @Transactional
    @Test
    public void deleteOne() throws Exception {
        Car newCar = new Car();
        newCar.setId(10L);
        mockMvc.perform(delete("/car").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(newCar))).andReturn();
        em.flush();

        MvcResult mvcResult = mockMvc.perform(get("/car")).andReturn();
        List<Car> cars = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        Assert.assertEquals(9, cars.size());
    }
}
