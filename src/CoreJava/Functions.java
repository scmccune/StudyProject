package CoreJava;

import java.util.Arrays;
import java.util.List;

public class Functions {

    public static void runOperators()
    {
        mathOperators();
        relationalOperators();
        logicalOperators();
        conditional();
        loops();
    }

    public static void mathOperators(){
        Util.printHeader("Maths operators");
        System.out.printf("5 + 2 = %1$s \n" , (5+2));
        System.out.printf("5 - 2 = %1$s \n" , (5-2));
        System.out.printf("5 * 2 = %1$s \n" , (5*2));
        System.out.printf("5 / 2 = %1$s - remainder is discarded\n" , (5/2)); // Note remainder is discarded
        System.out.printf("5 %% 2 = %1$s - The remainder of the division\n",  (5%2)); // gets the remainder
        System.out.println();
        int num = 2;
        num += 3;
        System.out.printf("int num = 2; num +=3; num = %1$s \n" , num);
        num = 2;
        num *= 3;
        System.out.printf("int num = 2; num *=3; num = %1$s \n" , num);
        num = 2;
        num++;
        System.out.printf("int num = 2; num++; num = %1$s \n" , num);
        num = 2;
        int postIncNum = num++;
        System.out.println("num++ increments num after assignment. ++num before.");
        System.out.printf("int num = 2; int postIncNum = num++; postIncNum = %1$s and num = %2$s \n" , postIncNum, num);
        num = 2;
        int preIncNum = ++num;
        System.out.printf("int num = 2; int preIncNum = ++num; preIncNum = %1$s and num = %2$s \n" , preIncNum, num);

    }

    public static void relationalOperators(){
        Util.printHeader("Relational Operators");
        int x = 1;
        int y = 2;
        System.out.println("X=1 Y=2. Output = boolean");
        System.out.println("== - Equal. X==Y = " + (x==y));
        System.out.println("!= - Not equal. X!=Y = " + (x!=y));
        System.out.println(">  - Greater than X>Y = " + (x>y));
        System.out.println(">= - Greater or equal. X>=Y = " + (x>=y));
        System.out.println("<  - Less than. X<Y = " + (x<y));
        System.out.println("<= - Less or equal. X<=Y = " + (x<=y));

    }

    public static void logicalOperators(){
        Util.printHeader("Logical Operators");
        System.out.println("&& - and - ie. All true" +
                "\n    T && T && T = " + (true && true && true) +
                "\n    T && T && F = " + (true && true && false) +
                "\n    F && F && F = " + (false && false && false));
        System.out.println("|| - Or - ie. Any true " +
                "\n   T || T || T = " + (true || true || true)+
                "\n   T || T || F = " + (true || true || false)+
                "\n   F || F || F = " + (false || false || false));
        System.out.println("!= - not - Reverse T/F\n   !true = " + (!true) + "\n   !false = " + (!false));
        System.out.println("Short Circuit = && instead of & or | instead of ||. With || or && It will stop when proven");
        int a = 2;
        int b = 3;
        boolean bool = a<b || ++b > a;
        System.out.println("a=2; b=3; a<b || ++b > a : a = " + a + " b = " + b + " bool = " + bool + " - first condition was true, stopped checking");
        bool = a<b | ++b > a;
        System.out.println("a=2; b=3; a<b |  ++b > a : a = " + a + " b = " + b + " bool = " + bool + " - first condition was true, still executed second");
    }

    public static void conditional(){
        Util.printHeader("Conditional Statements");
        System.out.println("if (condition == true){\n\t   result = true;\n\t} else if (secondCondition == true) {\n\t   result = true; \n\t } else { \n\t   result = false; }");
        System.out.println("Tenery: return bool ? true : false;");
        System.out.println("Old switch: switch(num) { \n\tcase 1:\n\t\tresult=\"one\";\r\n\t\tbreak;\n\tdefault:\n\t\tresult=\"notOne\";}");
        System.out.println("Java 17 switch: String dayName = switch (day) {\n" +
                "            case 1 -> \"Monday\";\n" +
                "            case 2 -> \"Tuesday\";\n" +
                "            default -> \"Invalid day\";};");
        System.out.println("Can also yield in default: default -> {\n" +
                "                if (score < 60) {\n" +
                "                    yield \"F\";\n" +
                "                } else {\n" +
                "                    yield \"Invalid score\";\n" +
                "                }");
        System.out.println("Java 21 Switch: String result = switch (obj) {\n" +
                "            case String s -> \"It's a string: \" + s;\n" +
                "            case Integer i -> \"It's an integer: \" + i;\n" +
                "            default -> \"Unknown type\";\n" +
                "        };\n");

    }

    public static void loops() {
        Util.printHeader("Loops");
        int i=1;
        System.out.println("while (i<3) {\n" +
                "   System.out.printf(\"i = %1$s\", i++);\n" +
                "}");
        while(i<3){
            System.out.printf("i = %1$s | ", i++);
        }

        i=1;
        System.out.println("\ndo {    // Runs atleast once\n" +
                "   System.out.printf(\"i = %1$s\", i++);\n" +
                "} while (i<1);");
        do {
            System.out.printf("i = %1$s | ", i++);
        } while(i<1);

        for (int j = 0; j < 3; j++) {
            System.out.printf("j = %1$s | ",j);
        }
        List<String> stringArray = Arrays.asList("Apple", "Banana", "Cherry");
//         Using a traditional for loop
//        for (int w = 0; w < stringArray.size(); w++) {
//            System.out.println(stringArray.get(w));
//        }
//         Or
//        for (String s : stringArray) {
//            System.out.println(s);
//        }
//         Using lambda expression
//        stringArray.forEach(s -> System.out.println(s));
//         Using method reference
        System.out.println("\n// Using a traditional for loop\n" +
                "        for (int w = 0; w < stringArray.size(); w++) {\n" +
                "            System.out.println(stringArray.get(w));\n" +
                "        }\n" +
                "// Or\n" +
                "        for (String s : stringArray) {\n" +
                "            System.out.println(s);\n" +
                "        }\n" +
                "// Using lambda expression\n" +
                "        stringArray.forEach(s -> System.out.println(s));\n" +
                "// Using method reference\n" +
                "        stringArray.forEach(System.out::printf);");
        stringArray.forEach(System.out::printf);

    }




}
