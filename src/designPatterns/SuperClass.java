package designPatterns;

public abstract class SuperClass implements SuperInterface {


    public void getSample() {
        System.out.println("Super class sample method call");
    };

    @Override
    public void getMethod() {
        System.out.println("Super class get method call");
    }
}
