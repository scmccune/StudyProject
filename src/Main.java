import AdvancedJava.AdvancedObjects;
import AdvancedJava.Exceptions;
import AdvancedJava.Resources;
import AdvancedJava.Threads;
import CoreJava.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Functions.runOperators();
        DataTypes.runDataTypes();
        Objects o = new Objects();
        Exceptions ex = new Exceptions();
        AdvancedObjects adO = new AdvancedObjects();
        Resources re = new Resources();
        Threads t = new Threads();

    }


}