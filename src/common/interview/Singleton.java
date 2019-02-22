package common.interview;

public class Singleton {

    public static void main(String args[]) {
        //SingleInstance.getInstance();
        //SingleInstance.getInstance();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance obj =  SingleInstance.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance obj  = SingleInstance.getInstance();
            }
        });

        t1.start();
        t2.start();

        SingleEnumInstance obj1 = SingleEnumInstance.INSTANCE;
        obj1.i = 5;
        obj1.show();

        SingleEnumInstance obj2 = SingleEnumInstance.INSTANCE;
        obj2.i = 6;
        obj1.show();

    }
}


class SingleInstance {

    static SingleInstance instance;

    // Private default const
    private SingleInstance (){

        System.out.println("Instance Created");
    }

    public static synchronized SingleInstance getInstance () {  // we need lazy loading here

        if(instance == null) {
            instance = new SingleInstance();
        }

        return instance;
    }


    public static SingleInstance getDoubleCheckedInstance () { // Double check locking

        if(instance == null) {
            // lazy loading
            synchronized (SingleInstance.class){
                if(instance == null)
                    instance = new SingleInstance();
            }

        }

        return instance;
    }

}


enum SingleEnumInstance { // Default it has private constructor 1.5

    INSTANCE; //public static synchronized SingleInstance getInstance ()
    int i;

    public  void show() {
        System.out.println("Instance Created "+ i);
    }
}

