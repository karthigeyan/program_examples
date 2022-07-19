package backtojava;

public class TryWithResource  implements AutoCloseable{

    public TryWithResource() {
        System.out.println("Constructor -> AutoCloseableResources_First");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_First");
    }

    private static void  orderOfClosingResources() throws Exception {

        try (TryWithResource af = new TryWithResource();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

            af.doSomething();
            as.doSomething();
        }
    }

    @Override
    public void close() throws Exception {



        System.out.println("Closed AutoCloseableResources_First");
    }

    public static void main(String[] args) {

        try {
            orderOfClosingResources();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        System.out.println("Constructor -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_Second");
    }
}
