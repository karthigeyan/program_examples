package pattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@FunctionalInterface
interface A
{
    void show();
    int hashCode();
    String toString();
    static void staticMethod(){
        System.out.println("static");

    }
    default void defaultMethod(){
        System.out.println("default");

    }
}

public class ComparDev{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Developer> listDevs = getDevelopers();

        listDevs.sort((o1, o2)->o1.getAge()-o2.getAge());
        listDevs.stream().forEach(System.out::println);
        listDevs.stream().collect(Collectors.toMap(Developer::getAge, developer -> developer, (t, t2) ->  t));
A.staticMethod();
A a = () -> System.out.printf("");
a.defaultMethod();

        //Perform Other operations
    }

    private static List<Developer> getDevelopers() {



        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }
}
