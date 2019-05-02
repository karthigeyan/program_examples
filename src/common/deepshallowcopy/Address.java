package common.deepshallowcopy;

public class Address
{
    public String city;
    public String state;

    public Address(String city, String state)
    {
        super();
        this.city = city;
        this.state = state;
    }

    public Address(Address address)
    {
        this.city = address.city;;
        this.state = address.state;
    }
}