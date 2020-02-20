package pattern;

public class CarPattern {
    private String make;
    private String model;
    private int year;

    public CarPattern(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String setCarMake(String make) {
        this.make = make;
        return make;
    }

    public String getCarMake() {
        return make;
    }

    public String setCarModel(String model) {
        this.model = model;
        return model;
    }

    public String getCarModel() {
        return model;
    }

    public int setCarYear(int year) {
        this.year = year;
        return year;
    }

    public int getCarYear() {
        return year;
    }

    public String toString() {
        return "CarPattern make: " + make + "CarPattern model:" + model + " CarPattern Year:" + year;
    }

    public static void main(String[] args) {
        CarPattern CarPattern1 = new CarPattern("Toyota", "Corolla", 1996);
        CarPattern CarPattern2 = new CarPattern("Nissan", "Murano", 2004);
        CarPattern CarPattern3 = new CarPattern("Infinity", "Mazda", 2013);

        CarPattern1.setCarMake("BMW");
        System.out.println(CarPattern1);
        System.out.println(CarPattern1.getCarYear());

        CarPattern2.setCarModel("Altima");
        System.out.println(CarPattern2);
        System.out.println(CarPattern2.getCarMake());

        CarPattern3.setCarYear(2012);
        System.out.println(CarPattern3);
        System.out.println(CarPattern3.getCarModel());


    }
}