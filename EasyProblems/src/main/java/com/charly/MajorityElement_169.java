package com.charly;

import java.util.HashMap;

public class MajorityElement_169 {

    public static void main(String[] args) {

        // int[] nums = {1};
        int[] nums = {2,2,1,1,1,2,2};

        int majElement =majorityElement(nums);

        System.out.println("Majority element: " + majElement);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> reps = new HashMap<>();

        for (int num : nums) {
            int numReps = 0;
            if (reps.containsKey(num)) {
                numReps = reps.get(num) + 1;
                reps.replace(num, numReps);
            } else {
                reps.put(num, 1);
            }
            numReps = numReps != 0 ? numReps : reps.get(num);

            if (numReps > (nums.length / 2)) return num;
        }
        return 0;
    }

    public static int majorityElmenentWithoutHashMap(int[] nums) {

        // Applying Moore Voting Alghoritm
        int majorNumb = nums[0], reps = 1;

        for (int i = 1; i < nums.length; i++) {
            reps += nums[i] == majorNumb ? 1 : -1;

            if (reps == 0) {
                // Change the major element
                majorNumb = nums[i];
                reps = 1;
            }
        }

        return majorNumb;
    }

}
