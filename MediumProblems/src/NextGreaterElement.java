import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums2 = {1,2,3,4};
        int[] nums1 = {2,4};

        Arrays.stream(nextGreater(nums1, nums2))
                .forEach(el -> System.out.print(el + ", "));

    }


    public static int[] nextGreater(int[] nums1, int[] nums2) {

        int[] result = new int[nums2.length];

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> mapChangedNums = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {

            while(!stack.isEmpty()) {
                if (nums2[i] > nums2[stack.peek()]) {
                    // Replace the result at stack position
                    result[stack.peek()] = nums2[i];
                    // Put the previous value as a key, and the changed value as the key value
                    mapChangedNums.put(nums2[stack.peek()], nums2[i]);
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mapChangedNums.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

}
