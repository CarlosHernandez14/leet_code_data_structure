package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result;
    int[] nums;

    public static void main(String[] args) {

        int[] input = {1, 2, 3};
        System.out.println("Backtrack result: " + new Subsets().subsets(input));
    }


    public List<List<Integer>> subsets(int[] nums) {

        this.nums = nums;
        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);

        return result;
    }

    public void backtrack(int index, List<Integer> current) {

        // recursive case
        if(index == this.nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, current);
        // remove last element
        current.remove(current.size() - 1);
        backtrack(index + 1, current);

    }

    // [1, 2 , 3]
    // i =  1

    // - [1, 2]
    // - i = 2
    // - [1, 2, 3]
    // - i = 3 -> backtrack
    // - i = 2
    // - [1, 2]
    // - i = 3 -> backtrack
    // - i = 1
    // - [1]
}
