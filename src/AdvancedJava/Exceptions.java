package AdvancedJava;

import CoreJava.Util;

class StephenException extends RuntimeException {
    public StephenException(String s)
    {
        super(s);
    }
}
public class Exceptions {
    public Exceptions()
    {
        tryCatch();
        throwException();
        throwOwnException();
        throwExceptionUp();
    }

    private void throwExceptionUp() {
        Util.printHeader("Throw Exception Up");
        System.out.println("""
                    private void getAndThrowStephenException() {
                        try {
                            throwStephenException();
                        } catch (StephenException e) {
                            throw e;
                        }
                    }\
                """);
        try{
            getAndThrowStephenException();
        } catch (StephenException e)
        {
            System.out.println("Caught thrown exception: " + e.getMessage());
        }
        System.out.println("Alternatively this can be done through the signature");
        System.out.println("""
                    private void getAndThrowStephenExceptionSig() throws StephenException{
                    throwStephenException();
                    }\
                """);
        try{
            getAndThrowStephenExceptionSig();
        } catch (StephenException e)
        {
            System.out.println("Caught thrown exception: " + e.getMessage());
        }
    }

    private void getAndThrowStephenExceptionSig() throws StephenException{
    throwStephenException();
    }

    private void getAndThrowStephenException() {
        try {
            throwStephenException();
        } catch (StephenException e) {
            throw e;
        }
    }

    private void throwOwnException() {
        Util.printHeader("Throw Own Exception");
        System.out.println("""
                class StephenException extends RuntimeException {
                    public StephenException(String s)
                    {
                        super(s);
                    }
                }
                
                    private void throwStephenException() {
                            throw new StephenException("Stephen is Exceptional");
                    }
                   try{
                   throwStephenException();
                   } catch (StephenException e)
                   {
                       System.out.println("Caught exception: " + e.getMessage());
                   }""");
        try{
            throwStephenException();
        }
        catch (StephenException e)
        {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    private void throwStephenException() {
            throw new StephenException("Stephen is Exceptional");
    }

    private void throwException() {
        Util.printHeader("Throw Exception");
        try{
            throwArithmeticException();
        }
        catch (ArithmeticException e)
        {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    private void throwArithmeticException() {
        System.out.println("        if(10-10==0)\n" +
                           "            throw new ArithmeticException(\"Manually throwing ArithmeticException\");");
        if(10-10==0)
            throw new ArithmeticException("Manually throwing ArithmeticException");
    }


    private void tryCatch() {
        Util.printHeader("Try / Catch");
        System.out.println("""
                        try {\s
                            int i = 1/0;\s
                        }
                        catch (ArithmeticException e) {
                            System.out.println("ArithmeticException: " + e.getMessage());
                        }
                        catch (Exception e) {
                            System.out.println("Exception: " + e.getMessage());
                        }""");
        try {
            int i = 1/0;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
