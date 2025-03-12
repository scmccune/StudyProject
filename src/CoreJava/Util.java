package CoreJava;

public class Util {
    public static void printHeader(String s) {
        System.out.println();
        System.out.println("======" +  "=".repeat(s.length()));
        System.out.println("=  " + s + "  =");
        System.out.println("======" +  "=".repeat(s.length()));
    }

    static String printMyFnArray(int[] array)
    {
     StringBuilder outputString = new StringBuilder();
     outputString.append("[");
        for(int i: array)
        {
            outputString.append(i);
            outputString.append(',');
        }
        outputString.deleteCharAt(outputString.length()-1);
        outputString.append("]");
        return outputString.toString();
    }

    static String printMyFnArray(int[][] array)
    {
     StringBuilder outputString = new StringBuilder();
     outputString.append("[");
        for(int[] i: array)
        {
            outputString.append(printMyFnArray(i));
            outputString.append(",");
        }
        outputString.deleteCharAt(outputString.length()-1);
        outputString.append("]");
        return outputString.toString();
    }
}