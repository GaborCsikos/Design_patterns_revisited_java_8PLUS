package week1.cretional.factory;


public class Car {
    private String plate;
    private String color;

    private Car(String plate, String color) {
        this.plate = plate;
        this.color = color;
    }


    // factory method
    public static Car newAmbulance(String plate) {
        return new Car(plate, "White");
    }

    public static Car newFireTruck(String plate) {
        return new Car(plate, "Red");
    }

    public static Car newGenericCar(String plate, String color) {
        return new Car(plate, color);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

