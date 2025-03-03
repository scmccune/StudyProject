package CoreJava.object;

import CoreJava.Objects;

class SubClass{
    static String defaultAccess = "Accessed in same package";
}
public class ExtendedClass extends BasicClass{
    private String privateAccess = "Only accessible in current class";

    public ExtendedClass() {
        System.out.println("ExtendedClass empty constructor");
    }

    public ExtendedClass(String s){
        super(s);
        System.out.println("Extended class printing input " + s);
    }

    public ExtendedClass(int i)
    {
        this();
        System.out.println("In constructor after calling this(). int param was " + i);
    }

    public void printClass()
    {
        System.out.println("ExtendedClass");
    }

    @Override
    public void printPrivateString() {
        System.out.println("Overridden. Calling super class now");
        super.getPrivateString();
    }

    public void printAccessModifiers() {
        System.out.println("privateAccess -> " + privateAccess);
        System.out.println("SubClass.defaultAccess -> " + SubClass.defaultAccess);
        System.out.println("Objects.publicAccess -> " + Objects.publicAccess);
        System.out.println("super.protectedAccess -> " + super.protectedAccess);
    }
}
