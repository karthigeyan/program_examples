package common;

import java.util.Hashtable;
import java.util.Map;

public class Cloneable {

    private ObjectClone data;


    public static void main(String args[]) throws Exception{
        Hashtable<String,String> insatnce = new Hashtable<>();
        insatnce.put("101","karthik");
        insatnce.put("102","karthik");
        insatnce.put("101","karthik");
        insatnce.put("101","karthik");
        insatnce.put("101","karthik");

        Cloneable insatce = new Cloneable();
        insatce.getClonedValue();

        for (Map.Entry e : insatnce.entrySet() ) {

            System.out.println(e.getKey()+ " ==== " + e.getValue());

            
        }
    }

    public void getClonedValue () throws Exception{
        ObjectClone duplicate = (ObjectClone) data.clone();
        System.out.println(duplicate.a);
    }

    Cloneable(int data) {
        this.data = new ObjectClone(data);
    }

    Cloneable(){
        this(20);
    }

    class ObjectClone implements java.lang.Cloneable {

        int a;

        ObjectClone(int a) {
            this.a = a;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
