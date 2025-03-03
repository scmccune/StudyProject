package CoreJava;

public class DataTypes {
    public static void runDataTypes()
    {
        types();
        conversion();
        arrays();
        random();
        string();
        arrayList();
        maps();
        sets();
    }

    public static void types() {
        // Integers
        Util.printHeader("Types");
        System.out.println("Integers:");
        int num1 = 9; // 4 bytes -2^31 to 2^31 -1
        System.out.printf("Integer: " + num1 + " - 4 bytes -2^31 to 2^31 -1. Min = " + Integer.MIN_VALUE + " Max = " + Integer.MAX_VALUE + "\r\n");
        long longNum = 12345L; // Suffix with L, 8 bytes, -2^61 to 2^61 -1
        System.out.printf("Long number: " + longNum + " - Suffix with L, 8 bytes, -2^61 to 2^61 -1. Min = " + Long.MIN_VALUE + " Max = " + Long.MAX_VALUE + "\r\n");
        short shortNum = 123; // 2 bytes, -2^15 to 2^15-1
        System.out.printf("Short: " + shortNum + " - 2 bytes, -2^15 to 2^15-1. Min = " + Short.MIN_VALUE + " Max = " + Short.MAX_VALUE + "\r\n");
        byte byteNum = 123; // 1 byte, -2^7 to 2^7-1
        System.out.printf("Byte: " + byteNum + " - 1 byte, -2^7 to 2^7-1. Min = " + Byte.MIN_VALUE + " Max = " + Byte.MAX_VALUE + "\r\n");
        System.out.println("=================================================");
        // Decimals
        System.out.println("Decimals");
        float floatDec = 1.23F; // Suffix with F - defaults to double. 2^4
        System.out.printf("Float: " + floatDec + " - Suffix with F - defaults to double. 2^4. Min = " + Float.MIN_VALUE + " Max = " + Float.MAX_VALUE + "\r\n");
        double doubleDec = 1.23;
        System.out.printf("Double: " + doubleDec + " - 2^8. Min = " + Double.MIN_VALUE + " Max = " + Double.MAX_VALUE + "\r\n");
        double doubleExp = 1e23;
        System.out.printf("Double: " + doubleExp + " - can do exponents with double doubleExp = 1e23\r\n");
        System.out.println("=================================================");
        char c = 'C'; // 2 bytes to store unicode value
        System.out.printf("Char: " + c + " - 2 Bytes to store unicode value - surrounded by single quotes\r\n");
        c++;
        System.out.printf("Can increment a char. C++ = " + c + "\r\n");
        boolean b = true;
        System.out.printf("Boolean: " + b + " - true or false\r\n");
    }

    public static void conversion() {
        Util.printHeader("Conversion");
        byte thisByte = 123;
        int thisByteInt = thisByte;
        System.out.printf("You can implicitly convert upwards for int/float/byte/etc eg.\r\n  byte thisByte = 123;\r\n  int thisByteInt = thisByte;\r\n  thisByteInt = " + thisByteInt + "\r\n");
        int thatSmallerInt = 12;
        System.out.printf("Implicit conversion downwards gives a compile error. Explicit casting can lose data downwards: + \n");
        byte thatSmallIntByte = (byte) thatSmallerInt;
        System.out.printf("Casting downwards works for valid number eg. \n  int thatSmallerInt = 12;\n  byte thatSmallIntByte = (byte)thatSmallerInt;\nthatSmallIntByte = " + thatSmallIntByte + "\n");
        int thatBigInt = 300;
        byte thatBigIntByte = (byte) thatBigInt;
        System.out.printf("Casting downwards gives a remainder for too large a number eg.\n  int thatBigInt = 300;\n  byte thatBigIntByte = (byte)thatBigInt; \nthatBigIntByte = " + thatBigIntByte + "\n");
    }

    public static void arrays(){
        Util.printHeader("Arrays");
        int[] newArray = new int[5];
        System.out.println("int[] newArray = new int[5]; -> " + Util.printMyFnArray(newArray));
        int[] popArray = {1,2,3,4,5};
        System.out.println("int[] popArray = {1,2,3,4,5}; -> " + Util.printMyFnArray(popArray));
        int[][] multiArray = {{1,2,3},{4,5,6}};
        System.out.println("int[][] multiArray = {{1,2,3},{4,5,6}}; -> " + Util.printMyFnArray(multiArray));
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[4];
        jaggedArray[1] = new int[1];
        jaggedArray[2] = new int[6];
        System.out.println("""
                int[][] jaggedArray = new int[3][];
                        jaggedArray[0] = new int[4];
                        jaggedArray[1] = new int[1];
                        jaggedArray[2] = new int[6];
                """);
        System.out.println(Util.printMyFnArray(jaggedArray));
    }

    private static void random() {
        Util.printHeader("Random Number");
        System.out.println("Raw random: Math.random(): " + Math.random());
        System.out.println("between 1 and 100: (int)(Math.random()*100); : " + (int)(Math.random()*100));
    }

    private static void string() {
        Util.printHeader("Strings");
        String name = "Strings are immutable";
        System.out.println("String name = \"Strings are immutable\";\nSystem.out.println(name); : " + name);
        System.out.println("System.out.println(name.concat(\" Yes\")); : " + name.concat(" Yes"));

        StringBuffer buffer = new StringBuffer(name);
        buffer.insert(12, "not ");
        System.out.println("\nStringBuffer buffer = new StringBuffer(name);\n" +
                "        buffer.insert(11, \"not \");\n" + buffer);

        StringBuilder s = new StringBuilder("I'm similar to StringBuffer");
        s.append(" but I'm not thread safe");
        System.out.println("\nStringBuilder s = new StringBuilder(\"I'm similar to StringBuffer\");\n" +
                "        s.append(\" but I'm not thread safe\");\n" + s);

    }

    public static void arrayList(){

    }

    public static void maps(){

    }

    public static void sets(){

    }




    //    public static void bitwise()
//    {
//        printHeader("BitWise");
//        int a = 3;
//        int b = 6;
//        System.out.println("a = " + a + " ~a = " + ~a + " b = " + b + " ~b = " + ~b);
//        System.out.println("(~a & b) = " + (~a & b));
//        System.out.println("(a & ~b) = " + (a & ~b));
//        int result = (~a & b) | (a & ~b);
//        System.out.println("(~a & b) | (a & ~b) = " + result);
//
//    }

}