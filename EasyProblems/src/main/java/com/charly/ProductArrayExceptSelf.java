package com.charly;

import java.util.Arrays;
import java.util.List;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        Arrays.stream(result)
                .forEach(System.out::println);

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            totalProduct *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = totalProduct / nums[i];
        }


        return answer;
    }

}
