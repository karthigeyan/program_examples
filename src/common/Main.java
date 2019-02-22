package common;

public class Main {

    public static void main(String[] args) {

        // write your code here
        System.out.println("Hello World....");

        CatchFinally instance = new CatchFinally();

        System.out.println(instance.tryCatchTest());

    }

    static {
        System.out.println("Static Block");
    }
}


class CatchFinally {
    {
        System.out.println("Instance Block");
    }

    String tryCatchTest() {
        try {
            return "try....";
        } catch (Exception e) {
            return "catch....";
        } finally {
            return "finally....";
        }
    }
}