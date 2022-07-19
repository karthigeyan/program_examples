package features8;

@FunctionalInterface
interface TestInterface{
    int calculate(int i, int j);
}
public class LambdaExample {

    public static void main(String[] args) {
        TestInterface ref = (x, y) -> x + y ;
        System.out.println(ref.calculate(2, 4));
    }
}