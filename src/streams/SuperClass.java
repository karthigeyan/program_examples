package streams;

public class SuperClass {

    SuperClass() {

    }

    SuperClass(String s) {

    }

    public static void superMethod(String s) {
        System.out.println(s);
    }

    public void superNonStaticMethod(String s) {
        System.out.println(s);
    }

    public String superReturnMethod(String s) {
       return s;
    }
}
