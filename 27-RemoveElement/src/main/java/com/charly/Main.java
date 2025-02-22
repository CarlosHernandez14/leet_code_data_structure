package com.charly;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        int[] nums = {3,2,2,3,5};

        int val = 3;

        int k = removeElement(nums, val);
        System.out.println("K: " + k);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static int removeElementLessEfficient(int[] nums, int val) {

        int[] tempNums = new int[nums.length];
        int k = 0; // Num of non-equals elements
        for (int num : nums) {
            if (num != val) // Add to temp array
                tempNums[k++] = num;
        }

        // Modify the original  array in-place
        System.arraycopy(tempNums, 0, nums, 0, tempNums.length);

        return k;
    }

    public static  int removeElement(int[] nums, int val) {

        int indexReplace = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) // Replace in the array iR
                nums[indexReplace++] = nums[i];
        }

        return indexReplace;
    }
}