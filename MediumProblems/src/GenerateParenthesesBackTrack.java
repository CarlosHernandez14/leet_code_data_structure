import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesBackTrack {

    List<String> result;
    int n;

    public static void main(String[] args) {

        int input = 3;
        System.out.println("PAIRS : " + new GenerateParenthesesBackTrack().generateParenthesis(input));


    }


    public List<String> generateParenthesis(int n) {

        this.n = n;
        this.result = new ArrayList<>();
        backtrack(n, n, new StringBuilder());

        return result;
    }

    public void backtrack(int open, int close, StringBuilder current) {

        // recursive case
        if (open == 0 && close == 0) {
            result.add(current.toString());
            return;
        }

        // Add open parens
        if (open > 0) {
            current.append("(");
            backtrack(open - 1, close, current);
            current.deleteCharAt(current.length() - 1);
        }

        if (close > 0) {
            if (open < close) {
                current.append(")");
                backtrack(open, close - 1, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

}
