package updateandadd;

public class user {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    
    public user(int ID, String FirstName, String LastName, int Age)
    {
        this.id = ID;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.age = Age;
    }
    public int getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getAge()
    {
        return age;
    }
}
