package common;

// Java program to illustrate creation of Object
// using new Instance
public class NewInstanceExample
{
    String name = "GeeksForGeeks";
    public static void main(String[] args)
    {
        try
        {
            NewInstance newIns = new NewInstance();
            System.out.println(newIns.name);

            NewInstanceExample newInst = new NewInstanceExample();
            System.out.println(newInst.name);

            Class cls = Class.forName("NewInstanceExample");
            NewInstanceExample obj =
                    (NewInstanceExample) cls.newInstance();
            System.out.println(obj.name);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
