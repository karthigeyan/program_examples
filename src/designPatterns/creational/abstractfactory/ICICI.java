package designPatterns.creational.abstractfactory;

public class ICICI implements Bank {
    @Override
    public String getBankName() {
        return "ICICI BANK";
    }
}
