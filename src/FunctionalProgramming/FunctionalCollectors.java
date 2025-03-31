package FunctionalProgramming;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

record Beer(String name, double abv){}

public class FunctionalCollectors {
    public FunctionalCollectors() {

        collToList();
        collToSet();
        collCollect();
        collToMap();
        collAndThen();
        collGroupingBy();
        collAndThenMap();
        collJoining();
        playing();
    }

    private void playing() {
        BinaryOperator<Double> bin = (i,j) -> i+j;
        System.out.println(getBeers().stream().map(Beer::abv).reduce(0d, bin));
        System.out.println(getBeers().stream().collect(Collectors.groupingBy(Beer::name)));

    }

    private void collAndThen() {
        Map<Double, Integer> andThen = getBeers().stream().collect(Collectors.groupingBy(s -> s.abv(), Collectors.collectingAndThen(Collectors.counting(), s -> s.intValue())));
        System.out.println(andThen);
    }

    private void collToMap() {
        Map<String, Double> asMap = getBeers().stream().filter(s -> !s.name().startsWith("S")).distinct().collect(Collectors.toMap(s -> s.name(), s-> s.abv()));
        System.out.println(asMap);
    }
    private void collJoining() {
        String joined = getBeers().stream().filter(s -> !s.name().startsWith("S")).distinct().map(Beer::name).sorted().collect(Collectors.joining(", "));
        System.out.println(joined);
    }

    private void collGroupingBy() {
        Map<Double,List<Beer>> groupBy = getBeers().stream().collect(Collectors.groupingBy(Beer::abv));
        System.out.println(groupBy);
    }

    private void collAndThenMap() {
        Map<Double, Integer> andThen = getBeers().stream().collect(Collectors.groupingBy(s -> s.abv(), TreeMap::new, Collectors.collectingAndThen(Collectors.counting(), s -> s.intValue())));
        System.out.println(andThen);
    }


    private void collToList() {
        // Return a list of beers over 4%
        List<String> beers = getBeers().stream().filter(s -> s.abv()>4).map(s -> s.name()).collect(Collectors.toList());
        System.out.println(beers);
    }

    private void collCollect() {
        // Return a list of beers over 4%
        List<String> beers = getBeers().stream().filter(s -> s.abv()>4).map(s -> s.name()).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(beers);
    }


    private void collToSet() {
        // Return a Set of beers over 4%
        Set<String> beers = getBeers().stream().filter(s -> s.abv()>4).map(s -> s.name()).collect(Collectors.toSet());
        System.out.println(beers);
    }

    private List<Beer> getBeers() {
        return Arrays.asList(new Beer("Guiness", 4.2),
                new Beer("Carlsberg", 3.2),
                new Beer("Special Brew", 7.8),
                new Beer("Lion", 4.8),
                new Beer("Tiger", 5.0),
                new Beer("Harp", 4),
                new Beer("Kronenberg", 4.6),
                new Beer("Kronenberg", 4.6)
                );
    }
}
