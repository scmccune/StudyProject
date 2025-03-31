package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Employee(String name, int salary){}
record Employees(String name, String job){}
record Employee3(String name, int salary, String job, List<String> skills){}


public class FunctionalQuestions {
    List<Employee3> employees = Arrays.asList(
            new Employee3("John", 50000, "Developer" , Arrays.asList("Reading", "Writing")),
            new Employee3("Jane", 60000, "Manager" , Arrays.asList("Reading", "Shooting")),
            new Employee3("Jane", 60000, "Manager" , Arrays.asList("Reading", "Shooting")),
            new Employee3("Mark", 55000, "Developer" , Arrays.asList("Reading", "Writing")),
            new Employee3("Sophia", 75000, "Manager" , Arrays.asList("Nothing", "Shouting")),
            new Employee3("Alex", 40000, "Designer" , Arrays.asList("Reading", "Bungee"))
    );
    public FunctionalQuestions(){
        groupByLengthCounting();
        findMaxInt();
        employeeHighestSalary();
        concatenatingString();
        groupByEven();
        groupByDesignation();
        countLongerThan4();
        sortListStringReverse();
        distinctElements();
        checkAllPositive();
        employeeSortedSalary();
        anagrams();
        fibonacci();
        fibonacci2();
        depmapsalary();
        depmapsalary2();
        mapEmpNameSalary();
        removeDupeName();
        flatMapSkills();
        flatMapWords();
        sumList();
        secondHighestSalary();
    }

    private void secondHighestSalary() {
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee3::salary).reversed()).skip(1).limit(1));
    }

    private void sumList() {

        //18. Given List<Integer>, Find Pair of numbers whose sum is equal to given target number.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;

    }

    private void flatMapWords() {
        //17. Use flatMap to create a List<String> of all individual words from a list of sentences.

        List<String> sentences = Arrays.asList("Hello world", "Java 8 Streams", "flatMap example world");
        System.out.println(sentences.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().toList());

    }

    private void flatMapSkills() {
        // 16. GivenList<Employee> where each Employee has a List<String> of skills. Use flatMap to create a List<String> that contains all unique skills across all employees.
        System.out.println(employees.stream().distinct().flatMap(emp -> emp.skills().stream()).distinct().toList());
        System.out.println(employees.stream().distinct().map(s -> s.skills()).flatMap(Collection::stream).distinct().toList());

    }

    private void removeDupeName() {
        Set<String> names = new HashSet<>();
        System.out.println(employees.stream().filter(emp -> names.add(emp.name())).toList());
    }

    private void mapEmpNameSalary() {
        System.out.println(employees.stream().distinct().collect(Collectors.toMap(Employee3::name, Employee3::salary)));

    }

    private void depmapsalary2() {


        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee3::job, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee3::salary)), emp -> emp.map(s -> s.name()).orElse("Null")))));
    }

    private void depmapsalary() {
        //13. Given List<Employee>, Get a Map which has Department, and Employee Name drawing highest salary in the department.
        //Map<String, String> highestSalaryEmployees = employees.stream()
        //            .collect(Collectors.groupingBy(Employee::getDepartment,
        //                    Collectors.collectingAndThen(
        //                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
        //                        emp -> emp.map(Employee::getName).orElse(null)
        //                    )

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee3::job)));
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee3::job, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee3::salary)),
                emp -> emp.map(Employee3::name).orElse(null)))));
    }

    private void fibonacci2() {
        Stream.iterate(new long[]{0,1}, s -> new long[]{s[1], s[0]+s[1]}).limit(10).map(s -> s[0]).forEach(System.out::println);

    }



    private void fibonacci() {
        // Generate first 10 Fibonacci numbers
        Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
                .limit(10) // Limit to the first 10 numbers
                .map(n -> n[0]) // Extract the first element of each pair
                .forEach(System.out::println);
    }

    private void anagrams() {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog", "evil", "vile", "veil");
        words.stream().collect(Collectors.groupingBy(s -> {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        })).values().stream().filter(s -> s.size() > 1).forEach(System.out::println);
  }

    private void checkAllPositive() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().sorted().findFirst().orElse(1) > 0);

        System.out.println(numbers.stream().allMatch(s -> s > 0));
    }

    private void distinctElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(numbers.stream().distinct().toList());
    }

    private void sortListStringReverse() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Comparator<String> reverseCompare = (s,t) -> s.compareTo(t) == 1 ?-1:1;
        System.out.println(words.stream().sorted(reverseCompare).toList());
        System.out.println(words.stream().sorted(Comparator.reverseOrder()).toList());
    }

    private void countLongerThan4() {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "cherry");
        System.out.println((Long) words.stream().filter(s -> s.length() > 4).count());

    }

    private void groupByDesignation() {
        List<Employees> employees = Arrays.asList(
                new Employees("Alice", "Developer"),
                new Employees("Bob", "Manager"),
                new Employees("Charlie", "Developer"),
                new Employees("David", "Manager"),
                new Employees("Eve", "Designer")
        );
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employees::job)));

    }

    private void groupByEven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers.stream().collect(Collectors.groupingBy(s -> s%2 == 0)));
    }

    private void concatenatingString() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println(words.stream().collect(Collectors.joining(", ")));
        System.out.println(String.join(", ", words));
    }

    private void employeeHighestSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Mark", 55000),
                new Employee("Sophia", 75000),
                new Employee("Alex", 40000)
        );
        Comparator<Employee> employeeComparator = (e,f) -> e.salary() > f.salary() ? 1 : -1;
        System.out.println(employees.stream().max(employeeComparator));

        // Their solution:
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::salary)));

    }
    private void employeeSortedSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Mark", 55000),
                new Employee("Sophia", 75000),
                new Employee("Alex", 40000)
        );

        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::salary).reversed()).toList());

    }

    private void findMaxInt() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("findMaxInt() >  Arrays.asList(1, 2, 3, 4, 5) = : " + numbers.stream().reduce(Integer::max));
        // Their answer:
        System.out.println("findMaxInt() >  Arrays.asList(1, 2, 3, 4, 5) = : " + numbers.stream().max(Integer::compareTo));

    }

    private void groupByLengthCounting() {
        // Given a list of strings, write a Java 8 Stream program to group the strings by their
        // length and count the number of strings in each group.

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(words);

        Map<Integer, Long> stringMap = words.stream().collect(Collectors.groupingBy(s -> s.length(), Collectors.counting() ));
        System.out.println(stringMap);
    }
}
