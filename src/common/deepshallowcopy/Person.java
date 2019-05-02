package common.deepshallowcopy;

public class Person
{
    public int x;
    public int y;

    public Address address;
    //Constructor with 2 parameters

    public Person(int x, int y, Address address)
    {
        super();
        this.x = x;
        this.y = y;
        this.address = address;
    }

    //Copy Constructor
    public Person(Person p)
    {
        this.x = p.x;
        this.y = p.y;
        this.address = p.address; //Shallow Copying
        //this.address = new Address(p.address); //Deep Copying
    }

    public static void main(String[] args)
    {
        Address address = new Address("Chennai","TN");

        Person p1 = new Person(1,2,address);

        Person p2 =  new Person(p1);

        System.out.println("*** Before changes ***");
        System.out.println(p1.address.city+" "+p1.address.state);
        System.out.println(p2.address.city+" "+p2.address.state);

        //Lets change the city and state of P2 object
        p2.address.city = "Banglore";
        p2.address.state = "Karnataka";

        System.out.println("*** After change ***");
        System.out.println(p1.address.city+" "+p1.address.state);
        System.out.println(p2.address.city+" "+p2.address.state);
    }
}