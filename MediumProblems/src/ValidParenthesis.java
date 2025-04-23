import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String testString = "{[([])]}}";

        System.out.println("Is valid?: " + isValid(testString));

    }

    public static boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> hashBrackets = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        for (int i = 0; i < s.length(); i++) {
            // If the character is an opening bracket
            if(hashBrackets.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }

            // Check in the top of the stack the corresponding opening
            if (!stack.isEmpty() && stack.peek() == hashBrackets.get(s.charAt(i)))
                stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }

//    public static char getClosingBracket(char bracket) {
//        char closingB = ' ';
//
//        switch (bracket) {
//            case '(' -> closingB = ')';
//            case '[' -> closingB = ']';
//            case '{' -> closingB = '}';
//        }
//
//        return closingB;
//    }
//
//    public static char getOpenBracket(char bracket) {
//        char openB = ' ';
//
//        switch (bracket) {
//            case ')' -> openB = '(';
//            case ']' -> openB = '[';
//            case '{' -> openB = '}';
//        }
//
//        return openB;
//    }

}
