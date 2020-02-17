package designPatterns.creational.factorymethod;

public class FactoryMethod {

    public Plan getPlan(String plan) {

        if(plan == null) {
            return null;
        }

        if(plan.equalsIgnoreCase("domestic")) {
            return new DomesticPlan();
        }

        if(plan.equalsIgnoreCase("commercial")) {
            return new CommercialPlan();
        }

        if(plan.equalsIgnoreCase("school")) {
            return new InstitutionalPlan();
        }

        return null;
    }
}
