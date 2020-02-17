package designPatterns.creational.factorymethod;

public class CommercialPlan extends Plan{

    @Override
    void getRate() {
        rate = 2.5;
    }
}
