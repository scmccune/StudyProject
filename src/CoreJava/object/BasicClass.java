package CoreJava.object;

public class BasicClass {
    protected String protectedAccess = "Accessible in this package and non package subclasses";
    private String privateString;


    static {
        System.out.println("BasicClass static block");
    }

    public BasicClass() {
        System.out.println("BasicClass empty constructor");
        this.privateString = "NOT SENT";
    }

    public BasicClass(String privateString)
    {

        this.privateString = privateString;
        System.out.println("Inside overloaded constructor, initialised with string " + privateString);
    }

    public void printPrivateString(){
        System.out.println(privateString);
    }

    public String getPrivateString() {
        return privateString;
    }

    public void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    public void printClass()
    {
        System.out.println("BasicClass");
    }
}
