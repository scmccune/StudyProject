package AdvancedJava;

import CoreJava.Util;

import java.lang.invoke.LambdaConversionException;
import java.util.Arrays;

public class AdvancedObjects {

    enum Status {
        Running, Failed, Pending, Success
    }

    enum BeerRating{
        Guinness(10, 4.2), Carlsberg(5, 3.4), Heineken(8, 5.0), Budweiser;
        private int marks;
        private double abv;
        BeerRating()
        {
            System.out.println("Probably American swill. defaulting");
            marks=-10;
            abv=2;
        }
        BeerRating(int marks, double abv)
        {
            this.abv = abv;
            this.marks = marks;
        }
    }

    @FunctionalInterface
    interface ForceMyBeerTastesOnOthers {
        void WHATSMYOPINION(BeerRating beeeeer);
    }


    @FunctionalInterface
    interface getStatusWithOrdinal {
        void printStatusWithOrdinal(Status s);
    }

    abstract class AbstractClass {
        public abstract void printAbstract();
    }

    interface TwoParamSAM {
        int addNums(int i, int j);
    }

    interface ThreeParamSAM {
        int addNums(int i, int j, int k);
    }

    class TwoParamSAMImplementor implements TwoParamSAM {
        @Override
        public int addNums(int i, int j) {
            return i+j;
        }
    }

    class TwoThreeParamSAMImplementor implements TwoParamSAM, ThreeParamSAM {
        @Override
        public int addNums(int i, int j) {
            return i+j;
        }

        @Override
        public int addNums(int i, int j, int k) {
            return i+j+k;
        }
    }


    class OuterInnerClass {
        class InnerInnerClass {
            public void innerInner() {
                System.out.println("Inside inner inner class");
            }
        }

        public void outerInner() {
            System.out.println("Inside OuterInnerClass");
        }
    }

    class ImplementerClass extends AbstractClass {
        @Override
        public void printAbstract() {
            System.out.println("In implementerClass");
        }
    }

    class StandardClass {
        public void print()
        {
            System.out.println("Inside standard inner class");
        }
    }


    public AdvancedObjects() {
        abstractClass();
        innerClass();
        anonymousClass();
        anonymousInnerClass();
        interfaces();
        multipleInterfaces();
        enums();
        enumClass();
    }


    private void enumClass() {
        Util.printHeader("Enum class");
        System.out.println("""
                    enum BeerRating{
                        Guinness(10, 4.2), Carlsberg(5, 3.4), Heineken(8, 5.0), Budweiser(-10, 4.8);
                        private int marks;
                        private double abv;
                        private beerRating(int marks, double abv)
                        {
                            this.abv = abv;
                            this.marks = marks;
                        }
                    }\
                """);
        System.out.println("""
                Lets rate our tasty tasty beers. 
                @FunctionalInterface
                interface ForceMyBeerTastesOnOthers {
                    void WHATSMYOPINION(BeerRating beeeeer);
                }
                ...
                ForceMyBeerTastesOnOthers imRight = lovelyBooze -> System.out.println("The correct opinion of the beer " +
                                                                                              lovelyBooze + " (" + lovelyBooze.abv +
                                                                                              "%abv) is that it is a " + lovelyBooze.marks + " ");
                        imRight.WHATSMYOPINION(BeerRating.Guinness);
                        imRight.WHATSMYOPINION(BeerRating.Budweiser);
                        imRight.WHATSMYOPINION(BeerRating.Carlsberg);
                        imRight.WHATSMYOPINION(BeerRating.Heineken);""");

        ForceMyBeerTastesOnOthers imRight = lovelyBooze -> System.out.println("The correct opinion of the beer " +
                                                                              lovelyBooze + " (" + lovelyBooze.abv +
                                                                              "%abv) is that it is a " + lovelyBooze.marks + " ");
        imRight.WHATSMYOPINION(BeerRating.Guinness);
        imRight.WHATSMYOPINION(BeerRating.Budweiser);
        imRight.WHATSMYOPINION(BeerRating.Carlsberg);
        imRight.WHATSMYOPINION(BeerRating.Heineken);
    }

    private void enums() {
        Util.printHeader("Enums");
        System.out.println("""
                    enum Status {
                        Running, Failed, Pending, Success
                    }\
                """);
        System.out.println("System.out.println(Status.Running); > " + Status.Running);
        System.out.println("System.out.println(Status.Running.ordinal()); > " + Status.Running.ordinal());
        System.out.println("System.out.println(Arrays.toString(Status.values())); > " + Arrays.toString(Status.values()));
        getStatusWithOrdinal lambda = (i) -> {
            switch (i) {
                case Status.Running -> System.out.println("I am Running! IM RUNNING! LOOK PA! ordinal: " + i.ordinal());
                case Status.Failed -> System.out.println("This is the failed Status. Ordinal: " + i.ordinal());
                default -> System.out.println("Boring boring boring. Status: " + i + " with ordinal: " + i.ordinal());
            }
        };
        System.out.println("""
                        getStatusWithOrdinal lambda = (i) -> {
                            switch (i){\s
                                case Status.Running -> System.out.println("I am Running! IM RUNNING! LOOK PA! ordinal: " + i.ordinal());
                                case Status.Failed -> System.out.println("This is the failed Status. Ordinal: " + i.ordinal());
                                default -> System.out.println("Boring boring boring. Status: " + i + " with ordinal: " + i.ordinal());
                            }};
                """);
        lambda.printStatusWithOrdinal(Status.Running);
        lambda.printStatusWithOrdinal(Status.Failed);
        lambda.printStatusWithOrdinal(Status.Pending);
    }

    private void multipleInterfaces() {
        Util.printHeader("Multiple interfaces");
        System.out.println("Very simply, a class can implement  2 seperate interfaces at the same time, as long as theres no conflict");
        System.out.println("""
                    class TwoParamSAMImplementor implements TwoParamSAM {
                        @Override
                        public int addNums(int i, int j) {
                            return i+j;
                        }
                    }
                
                    class TwoThreeParamSAMImplementor implements TwoParamSAM, ThreeParamSAM {
                        @Override
                        public int addNums(int i, int j) {
                            return i+j;
                        }
                
                        @Override
                        public int addNums(int i, int j, int k) {
                            return i+j+k;
                        }
                    }\
                """);
        TwoThreeParamSAMImplementor impl = new TwoThreeParamSAMImplementor();
        System.out.println("""
                        TwoThreeParamSAMImplementor impl = new TwoThreeParamSAMImplementor();
                """);
        System.out.println("System.out.println(impl.addNums(1,2)); > " + impl.addNums(1,2));
        System.out.println("System.out.println(impl.addNums(1,2,3)); > " + impl.addNums(1,2,3));

    }


    private void interfaces() {
        Util.printHeader("Interfaces");
        System.out.println("""
                Interfaces come in multiple forms:
                Normal interface: Multiple method signatures for implementation
                Functional interfaces / SAM (Single abstract method): One method implemented, used for Lambda
                Marker interfaces: No methods implemented, used for serialization
                    interface TwoParamSAM {
                        int addNums(int i, int j);
                    }
                   \s
                    class TwoParamSAMImplementor implements TwoParamSAM {
                        @Override
                        public int addNums(int i, int j) {
                            return i+j;
                        }
                    }
                   \s
                    TwoParamSAMImplementor implementor = new TwoParamSAMImplementor();
                    int implementorInt = implementor.addNums(2,3);
               \s""");
        TwoParamSAMImplementor implementor = new TwoParamSAMImplementor();
        int implementorInt = implementor.addNums(2,3);
        System.out.println("Standard implemetation output = " + implementorInt);

        System.out.println("""
                
                
                Inline implementation of interface:
                TwoParamSAM inlineImplementation = new TwoParamSAM() {
                            @Override
                            public int addNums(int i, int j) {
                                return i + j;
                            }
                        };
                        int j = inlineImplementation.addNums(3,4);""");
        TwoParamSAM inlineImplementation = new TwoParamSAM() {
            @Override
            public int addNums(int i, int j) {
                return i + j;
            }
        };

        int inlineInt = inlineImplementation.addNums(3,4);
        System.out.println("Inline implementation = " + inlineInt);

        System.out.println("""
                Lambda implementation - as it is one function, the reference can be implied.
                TwoParamSAM inlineImplementation = new TwoParamSAM() {
                   @Override
                   public int addNums(int i, int j) { ...
                becomes
                TwoParamSAM inlineImplementation = (i,j) -> { i+j; };
                int lambdaResult = lambda.addNums(5,6);""");
        TwoParamSAM lambda = (i,j) -> i+j;
        int lambdaResult = lambda.addNums(5,6);
        System.out.println("Lambda result: " + lambdaResult);
    }

    private void anonymousClass() {
        Util.printHeader("Anonymous Class");
        System.out.println("""
                    class StandardClass {
                        public void print()
                        {
                            System.out.println("Inside standard inner class");
                        }
                    }
                    ... StandardClass standardClass = new StandardClass();
                        standardClass.print();\
                """);
        StandardClass standardClass = new StandardClass();
        standardClass.print();

        System.out.println("""
                        StandardClass anonymousClass = new StandardClass(){
                            @Override
                            public void print() {
                                System.out.println("Inside anonymous class, overriding the Standard class implementation");
                            }
                        };
                        anonymousClass.print();\
                """);
        StandardClass anonymousClass = new StandardClass(){
            @Override
            public void print() {
                System.out.println("Inside anonymous class, overriding the Standard class implementation");
            }
        };
        anonymousClass.print();
    }

    private void anonymousInnerClass() {
        Util.printHeader("Anonymous inner class");
        AbstractClass as = new AbstractClass() {
            @Override
            public void printAbstract() {
                System.out.println("Anonymous inner class implementation of abstract class");
            }
        };
        System.out.println("""
                        AbstractClass as = new AbstractClass() {
                            @Override
                            public void printAbstract() {
                                System.out.println("Anonymous inner class implementation of abstract class");
                            }
                        };\
                """);
        as.printAbstract();
    }

    private void innerClass() {
        Util.printHeader("Inner class");
        System.out.println("""
                    class OuterInnerClass {
                        class InnerInnerClass {
                            public void innerInner() {
                                System.out.println("Inside inner inner class");
                            }
                        }
                
                        public void outerInner() {
                            System.out.println("Inside OuterInnerClass");
                        }
                    }\
                """);
        System.out.println("        OuterInnerClass oic = new OuterInnerClass();\n" +
                           "        oic.outerInner();");
        OuterInnerClass oic = new OuterInnerClass();
        oic.outerInner();
        System.out.println("        OuterInnerClass.InnerInnerClass iic = oic.new InnerInnerClass();\n" +
                           "        iic.innerInner();");
        OuterInnerClass.InnerInnerClass iic = oic.new InnerInnerClass();
        iic.innerInner();
    }

    private void abstractClass() {
        Util.printHeader("Abstract class");
        System.out.println("Gives a signature with no implementation. They are implemented in an extending class");
        System.out.println("""
                    abstract class AbstractClass {
                        public abstract void printAbstract();
                    }
                
                    class ImplementerClass extends AbstractClass {
                        @Override
                        public void printAbstract() {
                            System.out.println("In implementerClass");
                        }
                    }\
                """);
        ImplementerClass implementer = new ImplementerClass();
        implementer.printAbstract();
    }
}
