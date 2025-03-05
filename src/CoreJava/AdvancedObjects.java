package CoreJava;

public class AdvancedObjects {

    abstract class AbstractClass {
        public abstract void printAbstract();
    }

    interface TwoParamSAM {
        int addNums(int i, int j);
    }

    class TwoParamSAMImplementor implements TwoParamSAM {
        @Override
        public int addNums(int i, int j) {
            return i+j;
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
