package designPatterns.creational.factorymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetBillCalculatedMainClass {
    public static void main(String[] args) throws IOException {
        FactoryMethod factory = new FactoryMethod();

        System.out.println("Enter Plans :");

        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String planName = reader.readLine();

        System.out.println("Enter Units  :");
        int units = Integer.parseInt(reader.readLine());

        Plan plan = factory.getPlan(planName);

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");

        plan.getRate();
        plan.calculateBills(units);


    }
}
