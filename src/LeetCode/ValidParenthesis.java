package LeetCode;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidParenthesis {
//    Predicate<Character> isOpen = c -> Arrays.asList('{', '[', '(').contains(c);
//    BiPredicate<Character, Character> isValid = (c,d) -> switch (c){
//       case '{' ->  d.equals('}');
//       case '[' ->  d.equals(']');
//       case '(' ->  d.equals(')');
//       default -> false;
//    } ;

    public ValidParenthesis() {
        // Fun way with recursion

        System.out.println("Are the following parenthesis valid? ({({})}) " + validParenthesis("({({})})"));
        System.out.println("Are the following parenthesis valid? ({({}{}())()}) " + validParenthesis("({({}{}())()})"));
        System.out.println("Are the following parenthesis valid? ({({}}) " + validParenthesis("({({}})"));



    }

    private String validParenthesis(String s) {
        String res = pairParenthesis(s);
        if(res.isEmpty())
            return "Yes it's valid";
        return "No - remaining string: " + res;

    }

    Predicate<Character> isOpen = c -> Arrays.asList('{', '[', '(').contains(c);
    BiPredicate<Character, Character> isValid = (c,d) -> switch (c){
        case '{' ->  d.equals('}');
        case '[' ->  d.equals(']');
        case '(' ->  d.equals(')');
        default -> false;
    } ;

    private String pairParenthesis(String s) {
        if(s.length() <2)
            return s;
        Character thisChar = s.charAt(0);
        if (isOpen.test(thisChar)){
            String compareTo = pairParenthesis(s.substring(1));
            if(isValid.test(thisChar,compareTo.charAt(0))) {
                return compareTo.length() < 2 ? "" : pairParenthesis(compareTo.substring(1));
            }
        }
        return s;
    }


}
