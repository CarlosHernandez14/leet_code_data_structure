package com.charly;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray_26 {
    public static void main(String[] args) {


        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);
        System.out.println("K: " + k);
    }

    public static int removeDuplicates(int[] nums) {

        int indexReplace = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[indexReplace++] = nums[i];
        }

        //Arrays.stream(nums).forEach(System.out::println);

        return indexReplace;
    }
}
