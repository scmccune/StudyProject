package FunctionalProgramming;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class implementsFunctionalInterface implements StudyFunctionalInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello World - inmplementing  class");
    }
}

@FunctionalInterface
interface Calculate {
    Integer calculate(int x, int y);
}

public class FunctionalProgramming {
    public FunctionalProgramming()
    {
        //2_1
        functionalInterfaces();
        existingInterfaces();
        simpleStream();
        creatingStreams();
        advancedStreams();
        function();
        consumer();
        supplier();
        predicate();
        aCoolThingSomeoneDid();



    }

    public static Map<String, Integer> countStream(List<String> input, String prefix) {
        return input.stream()
                .filter(name -> name.toLowerCase().startsWith(prefix.toLowerCase()))
                .collect(Collectors.toMap(x -> x, x -> x.chars().distinct().boxed().collect(Collectors.toSet()).size()));
    }

    private void aCoolThingSomeoneDid() {
        List<String> abc = Arrays.asList("AABCD", "ABCD", "AAAAAABCBCBBBC", "AABBCCEFGHIJK");
        Map<String, Integer> count = countStream(abc, "AA");
        Map<String, Integer> output = abc.stream().filter(s -> s.startsWith("AA")).collect(Collectors.toMap(s -> s, s -> Math.toIntExact(s.chars().distinct().count())));
        System.out.println(count);
        System.out.println(output);
    }

    private void predicate() {
        System.out.println("Predicate<Integer> isEven = x -> x%2==0;");
        Predicate<Integer> isEven = x -> x%2==0;
        System.out.println("isEven.test(12); : " + isEven.test(12));

    }

    private void supplier() {
        Supplier<Integer> intSupplier = () -> new Random().nextInt(500);
        List<String> countries = Arrays.asList("China", "Spain", "Ireland", "Sri Lanka");
        Supplier<String> countrySupplier = () -> countries.get(new Random().nextInt(countries.size() - 1));
        for (int i = 0; i < intSupplier.get(); i++) {
            System.out.print(countrySupplier.get());
        }
        System.out.println();
    }

    private void function() {
        Function<Integer, String> doStuffWithAFunction = (x) -> "This is what the number was: " + x;
        System.out.println(doStuffWithAFunction.apply(2));
        BiFunction<Integer, Integer, String> doStuffWithABiFunction = (x,y) -> x + " + " + y + " = " + (x+y);
        System.out.println(doStuffWithABiFunction.apply(347543075, 3));
        DoubleToIntFunction dtif = x -> (int)x;
        ToIntBiFunction<Double, Double> addThenInt = (x,y) -> dtif.applyAsInt(x+y);
        System.out.println(addThenInt.applyAsInt(4.2535,3.9));
        IntFunction<String> intToString = x -> "FFIFKJFIFIFIFIFIFIFIFIFIFI" + x;
        intToString.apply(43224);
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(55));


    }

    private void consumer() {
        List<String> numberStrings = Arrays.asList("One", "Two", "Three", "Four");
        Function<String, String> doubleLetters = s -> {
            StringBuilder outputString = new StringBuilder();
            for(char i: s.toCharArray()) {
                outputString.append(i).append(i);
            }
            return outputString.toString();
        };
        Consumer<String> doubleprint = s -> System.out.println(doubleLetters.apply(s)+s);
        numberStrings.forEach(doubleprint);

        Map<String, String> biMap = new HashMap<>();
        biMap.put("One", "1");
        biMap.put("Two", "2");
        biMap.put("Three", "3");
        biMap.put("Four", "4");
        biMap.put("Five", "5");

        BiConsumer<String, String> joinStringsWithFun = (x,y) -> System.out.println(x + " - " + y);
        biMap.forEach(joinStringsWithFun);
        joinStringsWithFun.accept("this", "that");
        addTwo("thon", "t'other", joinStringsWithFun);
        addTwo("th", "ter", joinStringsWithFun);


    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T,T> c)
    {
        c.accept(a1,a2);
    }

    private void advancedStreams() {
        List<String> countries = Arrays.asList("China", "Spain", "Ireland", "Sri Lanka");
        // New Method
        countries.stream().map(String::toUpperCase) // Map to iterate through each, modifying them, and returning them in another stream
                .filter(s -> !s.startsWith("C")) // Filter to reduce the amount of elements
                .sorted() //
                .forEach(s -> System.out.println("Streamed upper case country not starting with C: " + s));

        List<String> processedList = countries.stream().map(String::toUpperCase) // Map to iterate through each, modifying them, and returning them in another stream
                .filter(s -> !s.startsWith("C")) // Filter to reduce the amount of elements
                .sorted() //
                .collect(Collectors.toList());

    }

    private void creatingStreams() {
        Integer[] scores = new Integer[]{12,34,56,78,90};
        Stream<Integer> integerStream = Arrays.stream(scores);

        List<String> countries = Arrays.asList("China", "Spain", "Ireland", "Sri Lanka");
        Stream<String> countStream = countries.stream();
        Stream<String> stringStream = Stream.of("A", "b", "C");
        countries.stream().sorted().forEach(s -> System.out.println("aaa " + s));

    }

    private void simpleStream() {
        List<String> countries = Arrays.asList("China", "Spain", "Ireland", "Sri Lanka");


        //Original method
        Collections.sort(countries);
        for (String country: countries) {
            String s = country.toUpperCase();
            if(!s.startsWith("C"))
            {
                System.out.println("Upper case country not starting with C: " + s);
            }
        }

        countries = Arrays.asList("China", "Spain", "Ireland", "Sri Lanka");
        // New Method
        countries.stream().map(String::toUpperCase) // Map to iterate through each, modifying them, and returning them in another stream
                .filter(s -> !s.startsWith("C")) // Filter to reduce the amount of elements
                .sorted() //
                .forEach(s -> System.out.println("Streamed upper case country not starting with C: " + s));
    }

    private void existingInterfaces() {
        // Using Java.util.function

    }

    private void functionalInterfaces() {
        StudyFunctionalInterface fInterface = new implementsFunctionalInterface();
        fInterface.sayHello();
        StudyFunctionalInterface fInterface2 = new StudyFunctionalInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello World - Overridden locally");
            }
        };
        fInterface2.sayHello();
        StudyFunctionalInterface fInterface3 = () -> System.out.println("Hello world - Lambda");
        fInterface3.sayHello();

        Calculate r = (x,y) -> {
            Random random = new Random();
            return x*random.nextInt(50) + y;
        };
        System.out.println(r.calculate(12,15));

        IntBinaryOperator calc3 = (x,y) -> { Random rand = new Random(); return x*rand.nextInt(50) + y;};
        System.out.println(calc3.applyAsInt(12,15));

    }
}
