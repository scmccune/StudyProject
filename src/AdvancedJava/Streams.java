package AdvancedJava;

import CoreJava.Util;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams {
    List<Integer> nums = Arrays.asList(4,7,6,2,3,9);
    public Streams() {
        basicStreams();
        predicate();
        function();
        reduce();
        optional();
        methodReference();
    }

    private void methodReference() {
        Util.printHeader("Method Reference");

    }

    private void optional() {
        Util.printHeader("Optional");
        System.out.println("Made to avoid NullPointerException");
        System.out.println("List<String> beers = Arrays.asList(\"Guinness\",\"Budweiser\",\"Carlsberg\");\n" +
                "        Optional<String> optionalReturnGood = beers.stream().filter(s -> s.contains(\"G\")).findFirst();");
        List<String> beers = Arrays.asList("Guinness","Budweiser","Carlsberg");
        Optional<String> optionalReturnGood = beers.stream().filter(s -> s.contains("G")).findFirst();
        System.out.println("optionalReturnGood.get() > Return good letter: " + optionalReturnGood.get());
        Optional<String> optionalReturnBad = beers.stream().filter(s -> s.contains("X")).findFirst();
        System.out.println("        Optional<String> optionalReturnBad = beers.stream().filter(s -> s.contains(\"X\")).findFirst();\n" +
                "    System.out.println(optionalReturnBad.get());" +
                "Note: I've put a try/catch around this as it fails");
        try{
            System.out.println(optionalReturnBad.get());
        } catch (NoSuchElementException e)
        {
            System.out.println("No such element exception thrown as it wasn't there");
            System.out.println("You can check this first by using optionalReturnBad.isPresent() or use orElse()");
        }
        System.out.println("        System.out.println(optionalReturnBad.orElse(\"OrElse to fallback\"));\n");
        System.out.println(optionalReturnBad.orElse("OrElse to fallback"));






    }

    private void reduce() {
    Util.printHeader("Reduce");
        System.out.println("This reduces the elements in a stream  and returns the reduced value");
        System.out.println("Identity, (carry + element) -> function");
        System.out.println("""
                BinaryOperator<Integer> bio = new BinaryOperator<Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) {
                                return integer + integer2;
                            }
                        };
                """);
        BinaryOperator<Integer> bio = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer i2) {
                return i + i2;
            }
        };

        System.out.println("nums reduced: ");
        System.out.println(nums.stream().reduce(0, bio));

        System.out.println("What happens with identity 10: System.out.println(nums.stream().reduce(10, bio));");
        System.out.println("nums reduced identity 10: ");
        System.out.println(nums.stream().reduce(10, bio));
        BinaryOperator<Integer> lambdaBio = (c, e) -> c + e;
        System.out.println("Reduced to: System.out.println(nums.stream().reduce(0, lambdaBio));");
        System.out.println("nums reduced: ");
        System.out.println(nums.stream().reduce(0, lambdaBio));



    }


    private void function() {
        Util.printHeader("Function (Map)");
        System.out.println("Map applies a Function<> to a stream returning another stream");
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };

        System.out.println("nums mapped: ");
        nums.stream().map(function).forEach(System.out::println);

        System.out.println("This can be simplified to: Function<Integer,Integer> lambdaFunction = n -> n*2;");
        Function<Integer,Integer> lambdaFunction = n -> n*2;

        System.out.println("nums mapped: ");
        nums.stream().map(lambdaFunction).forEach(System.out::println);

    }

    private void predicate() {
        Util.printHeader("Predicate");
        System.out.println("A predicate is a filter applied to a stream. Can be defined separately. Eg. to filter on even");
        System.out.println("""
                        Predicate<Integer> p =
                                new Predicate<Integer>() {
                                    public boolean test(Integer n) {
                                        if (n%2 == 0)
                                            return true;
                                        return false; }
                        };\
                """);
        Predicate<Integer> p =
                new Predicate<Integer>() {
                    public boolean test(Integer n) {
                        if (n%2 == 0)
                            return true;
                        return false; }
        };
        System.out.println("nums filtered: ");
        nums.stream().filter(p).forEach(n -> System.out.println(n));
        Predicate<Integer> lambdaP = n -> n%2==0;
        System.out.println("This simplifies to: Predicate<Integer> lambdaP = n -> n%2==0;\n" );
        System.out.println("nums filtered: ");
        nums.stream().filter(p).forEach(System.out::println);
    }

    private void basicStreams() {
        Util.printHeader("Basic Streams");
        System.out.println("Translate the following to a stream");

        System.out.println("""
                        int sum = 0;
                        for(int n:nums){
                            if(n%2==0){
                                n *= 2;
                                sum += n;
                            }
                        }\
                """);
        int sum = 0;
        for(int n:nums){
            if(n%2==0){
                n *= 2;
                sum += n;
            }
        }
        System.out.println("Sum of double all even numbers: " + sum);

        System.out.println("""
                int result = nums.stream()
                                .filter(n -> n%2 == 0) // Filter to only have even numbers
                                .map(n -> n*2) // Apply function (n*2) to each value
                                .reduce(0, (c,e) -> c+e); //something""");
        int result = nums.stream()
                .filter(n -> n%2 == 0) // Filter to only have even numbers
                .map(n -> n*2) // Apply function (n*2) to each value
                .reduce(0, (c,e) -> c+e); //Start at 0, add the carry over from prev iteration (c) to this element (e), returns an int
        System.out.println("Streamed result = " + result);


    }
}
