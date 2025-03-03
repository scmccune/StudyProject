package CoreJava;
import CoreJava.object.BasicClass;
import CoreJava.object.ExtendedClass;

import static CoreJava.Util.printHeader;

public class Objects {
    private final ExtendedClass extendedClass;
    public static String publicAccess = "Accessible from Anywhere";

    static class StaticVar {
        static private String s;
        public StaticVar(String s) { StaticVar.s =s; }
        public void printString() { System.out.println(s); }
    }

    public Objects()
    {
        staticBlock();
        System.out.println("\n\n\n(Initialising default extended class)");
        extendedClass = new ExtendedClass();
        staticVariables();
        staticMethods();
        basicClass();
        encapsulation();
        inheritance();
        overriding();
        accessModifiers();
        polymorphism();
        finalDesc();
        objectClass();
        upDownCasting();
        wrapperClass();
    }

    private void wrapperClass() {
        printHeader("Wrapper Classes");
        System.out.println("A type wrapping around a base class, for methods needing classes");
        System.out.println("Provides helper methods - toInt, parseInt, .compare etc");
        System.out.println("Integer i = 5; // This is called autoboxing");
    }

    private void upDownCasting() {
        printHeader("Upcasting and Downcasting");
        System.out.println("ExtendedClass exClass = new ExtendedClass();");
        ExtendedClass exClass = new ExtendedClass();
        System.out.println("exClass.printClass();");
        exClass.printClass(); // ExtendedClass
        System.out.println("BasicClass baseClass = (BasicClass) exClass;");
        BasicClass baseClass = exClass;
        System.out.println("baseClass.printClass();");
        baseClass.printClass(); // ExtendedClass
        System.out.println("ExtendedClass newExClass = (ExtendedClass) baseClass;");
        ExtendedClass newExClass = (ExtendedClass) baseClass;
        System.out.println("newExClass.printClass();");
        newExClass.printClass(); // ExtendedClass

    }

    private void objectClass() {
        printHeader("Object");
        System.out.println(".isEqual() - Compares two of the same object");
        System.out.println(".hashcode() - hashes all variables");
        System.out.println(".toString() - string representation of the instance");
        System.out.println("These can be overridden. For example:");
        System.out.println("public String toString() { \nreturn \"String Description \"; \n}");
    }

    private void finalDesc() {
        printHeader("Final");
        System.out.println("Final variable is the same as const");
        System.out.println("Final method means it can't be overridden");
        System.out.println("Final class means it can't be extended");

    }

    private void polymorphism() {
        printHeader("Polymorphism");
        System.out.println("Means many behaviours - Implementation used depends how its called");
        System.out.println("Overloading > compile time polymorphism > add(int i, int j) vs add(int i, int j, int k)");
        System.out.println("Overriding > Run time polymorphism > @Override in a subclass");
        System.out.println("Dynamic Method Dispatch > cast subclass as base >\n" +
                           " BasicClass dmd = new ExtendedClass(); \n dmd.printClass(); > \"ExtendedClass\"");
    }

    private void accessModifiers() {
        printHeader("Access Modifiers");
        System.out.println("""
                Structure:
                main > publicAccess
                \tObjects
                \t\tpublic BasicClass > protectedAccess
                \t\t\tpublic ExtendedClass extends BasicClass > privateAccess
                \t\t\tclass SubClass > defaultAccess (protectedPrivate)
                From ExtendedClass.accessModifiers()""");
        extendedClass.printAccessModifiers();
    }

    private void overriding() {
        printHeader("Overriding");
        //ExtendedClass extendedClass = new ExtendedClass("thisString");
        System.out.println("""
                Overriding inherited method. eg BasicClass.getPrivateString
                    @Override
                    public void printPrivateString() {
                        System.out.println("Override in ExtendedClass. Calling super class now");
                        super.getPrivateString();
                    }
                    ...extendedClass.printPrivateString();""");
        extendedClass.printPrivateString();

    }

    private void inheritance() {
        printHeader("Inheritance");
        System.out.println("""
                public class ExtendedClass extends BasicClass{
                    public ExtendedClass() {
                        System.out.println("ExtendedClass empty constructor");
                    }
                }
                ...
                ExtendedClass xClass = new ExtendedClass();
                xClass.printPrivateString(); // From BasicClass""");
        ExtendedClass xClass = new ExtendedClass();
        xClass.printPrivateString(); // From BasicClass
        System.out.println("Super keyword - Always first executed even if not mentioned\n" +
                "You can override the call to initialise overridden constructor with parameter");
        System.out.println("""
                    public ExtendedClass(String s){
                        super(s);
                        System.out.println("printing input " + s);
                    }\
                """);
        new ExtendedClass("Super Extended Class");
        //Inside overloaded constructor, initialised with string Super Extended Class
        //printing input Super Extended Class
        System.out.println("""
                Calling constructor with 'this()'\
                
                    public ExtendedClass(int i)
                    {
                        this();
                        System.out.println("In constructor after calling this(). int param was " + i);
                    }""");
        new ExtendedClass(1);

    }

    private void encapsulation() {
        printHeader("Encapsulation");
        System.out.println("Making data in a class private");
        System.out.println("private String privateString;");
        System.out.println("""
                Overloaded Constructor\
                    public BasicClass(String privateString)
                    {\s
                        this.privateString = privateString;
                        System.out.println("Inside overloaded constructor, initialised with string " + privateString);
                    }""");
        BasicClass basicClass = new BasicClass("String");
        System.out.println("Call setter:");
        System.out.println("""
                Setter:\
                
                    public void setPrivateString(String privateString) {
                        this.privateString = privateString;
                        // this. = from this class
                    }""");
        basicClass.setPrivateString("newString");
        System.out.println("Output result of Getter:");
        System.out.println("""
                Getter: \
                    public String getPrivateString() {
                        return privateString;
                    }""");
        System.out.println(basicClass.getPrivateString());
    }

    private void staticBlock() {
        printHeader("Static Block");
        System.out.println("""
                    private String privateString;
                    static { System.out.println("BasicClass static block");    }
                    public BasicClass()    { System.out.println("BasicClass constructor"); }\
                    ...
                    BasicClass basicClass1 = new BasicClass();\s
                    BasicClass basicClass2 = new BasicClass();\s
                """);
        new BasicClass();
        new BasicClass();


    }

    private void staticMethods() {
        printHeader("Static Method");
        System.out.println("""
                    public static void printHeader(String s) {
                        System.out.println();
                        System.out.println("======" + StringUtils.repeat('=', s.length()));
                        System.out.println("=  " + s + "  =");
                        System.out.println("======" + StringUtils.repeat('=', s.length()));
                    }\
                    Util.printHeader("Static Method"); // Prints the header above
                    > Can be called without instantiation of Util
                    > Can only reference static variables
                """);
    }

    public void basicClass() {
        printHeader("Classes");
        System.out.println("""
                public class BasicClass {
                    private String privateString;  // Private variable
                """);
        System.out.println("Empty Constructor");
        BasicClass basicClassEmpty = new BasicClass();
        System.out.println("PrintPrivateString method call");
        System.out.println("""
                Standard Method Call\
                public void printPrivateString(){
                        System.out.println(privateString);
                    }""");
        basicClassEmpty.printPrivateString();
        System.out.println("Overloaded Constructor:");


    }

    private void staticVariables() {
        printHeader("Static Variables");
        System.out.println("""
                    class StaticVar {
                        static private String s;
                        public StaticVar(String s) { StaticVar.s =s; }
                        public void printString() { System.out.println(s); }
                    }\
                """);
        StaticVar joe = new StaticVar("joe");
        System.out.println("StaticVar joe = new StaticVar(\"joe\"); \n joe.printString();" );
        joe.printString();
        StaticVar jim = new StaticVar("jim");
        System.out.println("""
                StaticVar jim = new StaticVar("jim");\s
                        joe.printString();
                        jim.printString();""");
        joe.printString();
        jim.printString();
    }




}
