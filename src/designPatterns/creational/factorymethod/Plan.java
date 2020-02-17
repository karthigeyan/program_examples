package designPatterns.creational.factorymethod;

abstract class Plan {

    protected double rate;
    abstract void getRate();

    public void calculateBills(int units) {
        System.out.println("Rate : " + rate);
        System.out.println(units + rate);
    }

}
