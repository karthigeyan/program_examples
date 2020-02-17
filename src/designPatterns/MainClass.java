package designPatterns;

public class MainClass extends  SuperClass{

    public static void main(String[] args) {
        MainClass mainClass =  new MainClass();
        mainClass.getSample();
    }

    @Override
    public void getSample() {
        System.out.println("Main class sample override method");
    }
}
