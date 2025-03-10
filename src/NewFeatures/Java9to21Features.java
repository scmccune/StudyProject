package NewFeatures;

import CoreJava.Functions;
import CoreJava.Util;
import CoreJava.object.BasicClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

interface testInterface{
    default void printMessage()
    {
        System.out.println("This is the default printMessage from testInterface. This can access privateMessage()");
        privateMessage();
        System.out.println("Finished calling privateMessage");
    }
    private void privateMessage(){
        System.out.println("This is a private method inside the interface");
    }
}

class OverrideInterface implements testInterface{
    @Override
    public void printMessage() {
        System.out.println("I'm inside the printMessage class of useInterface which implements testInterface. Can't call privateMessage from testInterface");
    }
}
class DefaultInterface implements testInterface{
}

interface ourHouse{}


record StephensRecord(String name, int age, List<String> todaysBeers) implements ourHouse{}
record MinolisRecord(String name, int age, String favouriteHusband) implements ourHouse {}


public class Java9to21Features {

    public Java9to21Features() {
        //Java 9
        privateMethodsInInterfaces();
        anonymousDiamonds();
        tryCatchResources();
        noUnderscore();
        //Java 11
        varType();
        //Java 14
        Functions.conditional();
        //Java 16
        instanceOf();
        record();
        sealedClasses();
        recordPatterns();
        stringTemplates();
    }

    private void stringTemplates() {
//        Util.printHeader("String Templates");
//        var name = "Stephen";
//        var str = STR."nice to meet you {name}";

    }

    private void recordPatterns() {
        Util.printHeader("Record patterns");
        System.out.println("""
                ourHouse stephen = new StephensRecord("Stephen McCune", 39, Arrays.asList("Guinness", "Carlsberg", "Spesh"));
                ourHouse minoli = new MinolisRecord("Minoli McCune", 30, "Stephen");
                ...
                        if(resident instanceof StephensRecord stephen) {
                            System.out.println("Hi stephen. go do some work");
                            System.out.println(stephen);
                        }
                ...
                        switch (resident) {
                            case StephensRecord s -> System.out.println("In case of stephen break glass");
                            case MinolisRecord m -> System.out.println("Minolis case in point");
                            default -> System.out.println("INTRUDER");
                        }
                """);
        ourHouse stephen = new StephensRecord("Stephen McCune", 39, Arrays.asList("Guinness", "Carlsberg", "Spesh"));
        ourHouse minoli = new MinolisRecord("Minoli McCune", 30, "Stephen");
        sayHi(stephen);
        sayHi(minoli);

    }

    private void sayHi(ourHouse resident) {
        if(resident instanceof StephensRecord stephen)
        {
            System.out.println("Hi stephen. go do some work");
            System.out.println(stephen);
        }

        if(resident instanceof ourHouse h && h instanceof MinolisRecord m) {
            System.out.println("Hi Noli, whats crackin");
            System.out.println(m);
        }

        switch (resident) {
            case StephensRecord s -> System.out.println("In case of stephen break glass" + s);
            case MinolisRecord m -> System.out.println("Minolis case in point" + m);
            default -> System.out.println("INTRUDER");
        }
    }

    private void sealedClasses() {
        Util.printHeader("Sealed Classes");
        System.out.println("Basic implementation is below. In this the sealed classes are only extended by permitted classes");
        System.out.println("""
                public sealed class Shape
                    permits Circle, Quadrilateral, WeirdShape {...}
                
                public final class Circle extends Shape {...}
                
                public sealed class Quadrilateral extends Shape
                    permits Rectangle, Parallelogram {...}
                public final class Rectangle extends Quadrilateral {...}
                public final class Parallelogram extends Quadrilateral {...}
                
                public non-sealed class WeirdShape extends Shape {...}""");
        Shape circle = new Shape.Circle(5);
        Shape rectangle = new Shape.Quadrilateral.Rectangle(4,6);
        Shape wierd = new Shape.WeirdShape(Arrays.asList(new Shape.WeirdShape.vector(3,90),new Shape.WeirdShape.vector(4,60),new Shape.WeirdShape.vector(5,30) ));
        System.out.println("Area of the circle " + circle + " is " + getArea(circle));
        System.out.println("Area of the rectangle " + rectangle + " is " + getArea(rectangle));
        System.out.println("Area of wierd shape " + wierd + " is " +getArea(wierd));


    }

    private static String getArea(Shape s) {
        return switch (s)
        {
            case Shape.Circle c -> "" + (3.14*c.radius*c.radius);
            case Shape.Quadrilateral.Rectangle r -> "" + (r.x*r.y);
            default -> "Who on earth could calculate such a thing...";
        };
    }

    private void record() {
        Util.printHeader("Record class");
        System.out.println("A record is a defaulted class for the given parameters as a data structure");
        System.out.println("record StephensRecord(String name, int age, List<String> todaysBeers){}");
        StephensRecord todaysStephen = new StephensRecord("Stephen McCune", 39, Arrays.asList("Guinness", "Carlsberg", "Spesh"));
        StephensRecord tomorrowsStephen = new StephensRecord("Stephen McCune", 39, Arrays.asList("Guinness", "Carlsberg", "Spesh"));
        StephensRecord yesterdaysStephen = new StephensRecord("Stephen McCune", 39, Arrays.asList("Spesh","Spesh", "Spesh"));
        System.out.println("todaysStephen.name(); - " + todaysStephen.name());
        System.out.println("todaysStephen.age(); - " + todaysStephen.age());
        System.out.println("todaysStephen.todaysBeers(); - " + todaysStephen.todaysBeers());
        System.out.println("todaysStephen.toString(); - " + todaysStephen);
        System.out.println("todaysStephen.hashCode(); - " + todaysStephen.hashCode());
        System.out.println("todaysStephen.equals(tomorrowsStephen); - " + todaysStephen.equals(tomorrowsStephen));
        System.out.println("todaysStephen.equals(yesterdaysStephen); - " + todaysStephen.equals(yesterdaysStephen));


    }

    private void instanceOf() {
        Util.printHeader("Instance of instantiation");
        Object o = "Object o = \"String\";";
        if(o instanceof String castString)
        {
            System.out.println("if(o instanceof String castString) ... It was a string! : " + castString);
        }

        System.out.println(getLength(o));

    }

    private static int getLength(Object obj) {
        if (!(obj instanceof String s)) {
            throw new IllegalArgumentException();
        }

        // s is in scope - if the instanceof does not match
        //      the execution will not reach this statement
        return s.length();
    }

    private void varType() {
        Util.printHeader("Var type");
        var string = "Hello";
        var intVar = 1;
        var longVar = 1L;
        System.out.println("var string = \"Hello\"; - class = " + string.getClass());
        System.out.println("var intVar = 1; - (cant get primitive class) = " + intVar);
        System.out.println("var longVar = 1L; - (cant get primitive class) = " + longVar);


    }

    private void noUnderscore() {
        Util.printHeader("Can't use _ as a var name");
        System.out.println("int _ = 3  // Not valid");

    }

    private void tryCatchResources() {
        Util.printHeader("Try/Catch with resources");
        System.out.println("You can define resources before using them in try/catch for cleaner code");
        System.out.println("""
                            Scanner s1 = new Scanner(tempFile);
                            Scanner s2 = new Scanner(tempFile2);
                            try(s1;s2)
                            {...\
                """);
        File tempFile;
        File tempFile2;
        try {
            tempFile = File.createTempFile("temp","tmp");
            tempFile2 = File.createTempFile("temp2", "tmp");
            try (FileWriter writer = new FileWriter(tempFile); FileWriter writer2 = new FileWriter(tempFile2)) {
                writer.write("First File");
                writer2.write("Second File");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Temp file created: " + tempFile.toURI());
            System.out.println("Temp file created: " + tempFile2.toURI());
            tempFile.deleteOnExit();
            tempFile2.deleteOnExit();
            Scanner s1 = new Scanner(tempFile);
            Scanner s2 = new Scanner(tempFile2);
            try(s1;s2)
            {
                System.out.println(s1.nextLine());
                System.out.println(s2.nextLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println("Couldn't open file " + e.getMessage());
        }
    }

    private void anonymousDiamonds() {
        Util.printHeader("Diamonds in anonymous inner class");
        System.out.println("An anonymous class can have type inferred through <>");
        System.out.println("""
                List<Integer> numbers = new ArrayList<>(){
                            @Override
                            public boolean add(Integer integer) {
                                System.out.println("Inside ArrayList.Add() with defaulted <>");
                                return super.add(integer);
                            }
                        };""");
        List<Integer> numbers = new ArrayList<>(){
            @Override
            public boolean add(Integer integer) {
                System.out.println("Inside ArrayList.Add() with defaulted <>");
                return super.add(integer);
            }
        };
    }

    private void privateMethodsInInterfaces() {
        Util.printHeader("Private methods in interfaces");
        System.out.println("Static or defaulted methods can call a private method in an interface");
        System.out.println("""
                EG. interface: interface testInterface{
                    default void printMessage()
                    {
                        System.out.println("This is the default printMessage from testInterface. This can access privateMessage()");
                        privateMessage();
                        System.out.println("Finished calling privateMessage");
                    }
                    private void privateMessage(){
                        System.out.println("This is a private method inside the interface");
                    }
                }
                
                class overrideInterface implements testInterface{
                    @Override
                    public void printMessage() {
                        System.out.println("I'm inside the printMessage class of useInterface which implements testInterface. Can't call privateMessage from testInterface");
                    }
                }
                class defaultInterface implements testInterface{
                }""");
        System.out.println("In this case, if you implement override interface, it has its own implementation of printMessage which can't access privateMessage.\nIf you implement defaultInterface it uses the default method which can access privateMessage");
        OverrideInterface overrideInterface = new OverrideInterface();
        overrideInterface.printMessage();
        DefaultInterface defaultInterface = new DefaultInterface();
        defaultInterface.printMessage();

    }
}
