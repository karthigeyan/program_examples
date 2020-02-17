package designPatterns.creational.factorymethod;

public class DomesticPlan  extends Plan{
    @Override
    void getRate() {
        rate = 1.5;
    }
}
