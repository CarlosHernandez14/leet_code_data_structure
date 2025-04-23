import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElementArray {

    public static void main(String[] args) {

        int[] testArray = {0};

        Arrays.stream(nextGreater(testArray))
                .forEach(el -> System.out.print(el + ", "));

    }


    public static int[] nextGreater(int[] nums) {

        int[] result = new int[nums.length];

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            while(!stack.isEmpty()) {
                if (nums[i] > nums[stack.peek()]) {
                    // Replace the result at stack position
                    result[stack.peek()] = nums[i];
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }

        return result;
    }

}
