package features8;

public class InheritanceTest {

    interface Person{
        default String getName(){
            return "Person";
        }
    }
    
    interface Faculty extends Person{
        default public String getName(){
            return "Faculty";
        }
    }

    class Student implements Faculty, Person{

        @Override
        public String getName() {
            return getName();
//            return Person.super.getName();
        }
    }
    private void test() {
        String name = new Student().getName();
        System.out.println("Name: "+name);
    }

    public static void main(String[] args) {
        InheritanceTest test = new InheritanceTest();
        test.test();
    }
}