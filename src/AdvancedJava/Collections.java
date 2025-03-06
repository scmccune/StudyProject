package AdvancedJava;

import CoreJava.Util;

import java.util.*;

import static java.util.Collections.sort;

public class Collections {
    public Collections() {
        arrays();
        arrayList();
        set();
        iterator();
        map();
        comparator();
        compareClass();
    }

    class Beer implements Comparable<Beer> {
        double abv;
        String name;
        public Beer(double abv, String name)
        {
            this.abv = abv;
            this.name = name;
        }

        public int compareTo(Beer otherBeer)
        {
            if(this.abv < otherBeer.abv)
                return 1;
            else if (this.abv == otherBeer.abv)
                return 0;
            return -1;
        }

        public String toString()
        {
            return "You've added " + name + " (" + abv + "%abv) to your bag of cans";
        }
    }

    private void compareClass() {
        Util.printHeader("Compare Class");
        System.out.println("Compare by implementing Comparable<Type> ");
        System.out.println("""
                Class:\s
                    class Beer implements Comparable<Beer> {
                        double abv;
                        String name;
                        ...
                        public int compareTo(Beer otherBeer)
                        {
                            if(this.abv < otherBeer.abv)
                                return 1;
                            else if (this.abv == otherBeer.abv)
                                return 0;
                            return -1;
                        }
                
                        public String toString()
                        {
                            return "You've added " + name + " (" + abv + "%abv) to your bag of cans";
                        }
                    }
                
                            List<Beer> carryOut = new ArrayList<>();
                            carryOut.add(new Beer(4.2, "Guinness"));
                            carryOut.add(new Beer(7.8, "Special Brew"));
                            carryOut.add(new Beer(3.4, "Carlsberg"));
                            carryOut.add(new Beer(4.8, "Lion"));
                            List:
                """);



        List<Beer> carryOut = new ArrayList<>();
        carryOut.add(new Beer(4.2, "Guinness"));
        carryOut.add(new Beer(7.8, "Special Brew"));
        carryOut.add(new Beer(3.4, "Carlsberg"));
        carryOut.add(new Beer(4.8, "Lion"));

        for(Beer tinny:carryOut)
        {
            System.out.println(tinny.toString());
        }
        System.out.println("\nLets sort the carry out, start on the good stuff first\njava.util.Collections.sort(carryOut);\n");
        java.util.Collections.sort(carryOut);

        for(Beer tinny:carryOut)
        {
            System.out.println(tinny.toString());
        }


    }
private void comparator() {
        Util.printHeader("Comparator");
        System.out.println("Comparator allows custom sorting. Create a comparator and use it to sort list");
        Comparator<Integer> comp = (o1,o2) -> {
                if(o1%10 > o2%10)
                    return 1;
                else if (o1%10 == o2%10)
                    return 0;
                return -1;
        };
        List<Integer> listToSort = new ArrayList<>();
        listToSort.add(14);
        listToSort.add(37);
        listToSort.add(19);
        listToSort.add(98);
        System.out.println("""
                Comparator<Integer> comp = (o1,o2) -> {
                                if(o1%10 > o2%10)
                                    return 1;
                                else if (o1%10 == o2%10)
                                    return 0;
                                return -1;
                        };
                        List<Integer> listToSort = new ArrayList<>();
                        listToSort.add(14);
                        listToSort.add(37);
                        listToSort.add(19);
                        listToSort.add(98);
                
                
                        System.out.println(Arrays.toString(listToSort.toArray()));""");

        System.out.println(Arrays.toString(listToSort.toArray()));
        System.out.println("sort(listToSort, comp);\n" +
                "        System.out.println(Arrays.toString(listToSort.toArray()));");
        listToSort.sort(comp);
        System.out.println(Arrays.toString(listToSort.toArray()));

    System.out.println("Sorting reverse with Lambda.\nComparator<Integer> lambdaComp = (i,j) -> i<j?1:-1;\n");

    Comparator<Integer> lambdaComp = (i,j) -> i<j?1:-1;
    listToSort.sort(lambdaComp);
    System.out.println(Arrays.toString(listToSort.toArray()));
}

    private void map() {
        Util.printHeader("Map");

        System.out.println("""
                Map works with a Key/Value pair. you define the types. Keys are unique
                        Map<String, Integer> numbers = new HashMap<>();
                        numbers.put("One", 3);
                        numbers.put("Two", 2);
                        numbers.put("Three", 3);
                        numbers.put("One", 1);
                
                        for(String s : numbers.keySet())
                        {
                            System.out.println("s + \\" - \\" + numbers.get(s) : " + s + " - " + numbers.get(s));
                        }""");
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 3);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("One", 1);

        for(String s : numbers.keySet())
        {
            System.out.println("s + \" - \" + numbers.get(s) : " + s + " - " + numbers.get(s));
        }



    }

    private void iterator() {
        Util.printHeader("Iterator");
        System.out.println("""
                        Set<Integer> hashSet = new HashSet<>();
                        hashSet.add(12);
                        hashSet.add(77);
                        Iterator<Integer> setIterator = hashSet.iterator();
                       \s
                        while(setIterator.hasNext()){
                            System.out.println(setIterator.next());
                        }\
                """);
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(12);
        hashSet.add(77);
        Iterator<Integer> setIterator = hashSet.iterator();

        while(setIterator.hasNext()){
            System.out.println(setIterator.next());
        }
    }

    private void set() {
        Util.printHeader("Sets");
        System.out.println("""
                HashSet:
                        Set<Integer> hashset = new HashSet<>();
                        hashSet.add("12");
                        hashSet.add("77");
                        hashSet.add("36");
                        hashSet.add("999");
                        hashSet.add("999");""");
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(12);
        hashSet.add(77);
        hashSet.add(36);
        hashSet.add(999);
        hashSet.add(999);

        System.out.println("hashset =" +Arrays.toString(hashSet.toArray()));
        System.out.println("Note - random order of retrieval");

        System.out.println("\nLinkedHashSet - maintains insertion order");
        System.out.println("""
                        Set<Integer> linkedHashSet = new LinkedHashSet<>();
                        linkedHashSet.add(12);
                        linkedHashSet.add(77);
                        linkedHashSet.add(36);
                        linkedHashSet.add(999);\
                """);
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(12);
        linkedHashSet.add(77);
        linkedHashSet.add(36);
        linkedHashSet.add(999);
        System.out.println("LinkedHashSet =" + Arrays.toString(linkedHashSet.toArray()));

        System.out.println("\nTreeSet - uses comparison order");
        System.out.println("""
                        Set<String> treeSet = new TreeSet<>();
                        treeSet.add("one");
                        treeSet.add("two");
                        treeSet.add("three");\
                """);
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        System.out.println("TreeSet =" + Arrays.toString(treeSet.toArray()));
    }

    private void arrayList() {
        Util.printHeader("ArrayList");
        System.out.println();
        System.out.println("        ArrayList<String> strings = new ArrayList<>();\n" +
                "        strings.add(\"This\");\n" +
                "        strings.add(\"is\");\n" +
                "        strings.add(\"JAVAAAA\");\n" +
                "        strings.indexOf(\"JAVAAAA\");");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("This");
        strings.add("is");
        strings.add("JAVAAAA");
        System.out.println(strings.indexOf("JAVAAAA"));
        System.out.println("        strings.get(strings.indexOf(\"JAVAAAA\"));");
        strings.get(strings.indexOf("JAVAAAA"));


        System.out.println("Linked list works the same, put stored differently - each entry points to next added. Faster add/pop. slower seek. FIFO POP");
        System.out.println("""
                LinkedList<String> linked = new LinkedList<>();
                        linked.add("one");
                        linked.add("two");
                        linked.add("three");
                        linked.add("four");""");
        LinkedList<String> linked = new LinkedList<>();
        linked.add("one");
        linked.add("two");
        linked.add("three");
        linked.add("four");
        System.out.println("linked: " + Arrays.toString(linked.toArray()));
        System.out.println("linked.pop() = " + linked.pop());
        System.out.println("linked.pop() = " + linked.pop());
        System.out.println("linked.pop() = " + linked.pop());
        System.out.println("linked: " + Arrays.toString(linked.toArray()));

    }

    private void arrays() {
        Util.printHeader("Arrays");
        System.out.println("Plain old boring arrays. Pro - fast and easy to access Cons - fixed size, one type ");
        String[][] stringArray = new String[2][2];
        stringArray[0][0] = "this";
        stringArray[0][1] = "array";
        stringArray[1][0] = "is";
        stringArray[1][1] = "2d";
        System.out.println("""
                String[][] stringArray = new String[2][2];
                        stringArray[0][0] = "this";
                        stringArray[0][1] = "array";
                        stringArray[1][0] = "is";
                        stringArray[1][1] = "2d";""");
        for(String[] strings:stringArray) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println("""
                Init on declaration:
                String[] populateOnInit = {"AAA", "BBB"};
                int[] num = {1,2,3,4,5};""");
        String[] populateOnInit = {"AAA", "BBB"};
        System.out.println(Arrays.toString(populateOnInit));
        int[] num = {1,2,3,4,5};
        System.out.println(Arrays.toString(num));
    }



}
