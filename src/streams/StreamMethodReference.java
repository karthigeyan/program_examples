package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StreamMethodReference extends SuperClass{

    @Override
    public void superNonStaticMethod(String s) {
        Function<String, String> func =  super::superReturnMethod;
        System.out.println(func.apply(s));
    }

    private void instanceMethod(String s) {
        System.out.println(s);
    }

    // static function to be called
    static void someFunction(String s)
    {
        System.out.println(s);
    }

    public static void main(String[] args)
    {

        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");

        // call the static method
        // using double colon operator
        // Static method
        list.forEach(StreamMethodReference::someFunction);
        System.out.println("------Instance method----------");
        list.forEach((new StreamMethodReference())::instanceMethod);
        System.out.println("------Super method----------");
        list.forEach((new StreamMethodReference())::superNonStaticMethod);
        System.out.println("--------New Constructor--------");
        list.forEach(SuperClass::new);
    }
}
