package lists;

import java.sql.SQLOutput;

public class MinSizeSubarraySum {

    public static void main(String[] args) {

        int[] testArray = {2,3,1,2,4,3};
        int target = 7;

        System.out.println("MinLengthArr = " + minSubArrayLen(target, testArray));

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int leftIndex = 0, rightIndex = 0;

        int sum = nums[rightIndex];
        int minLength = nums.length + 1;

        while (rightIndex < nums.length) {
            if (sum < target) {
                rightIndex++; // Make array bigger
                sum = rightIndex < nums.length ? sum + nums[rightIndex] : sum;
            } else {
                // Calculate the current subarray size
                minLength = Math.min((rightIndex - leftIndex) + 1, minLength);
                sum -= nums[leftIndex];
                leftIndex++;
            }

        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }

    public static int minSubArrayLen2(int target, int[] nums) {

        int leftIndex = 0;

        int sum = 0, minLength = nums.length + 1;

        for (int rightIndex = 0 ; rightIndex < nums.length ; rightIndex ++)  {
            sum += nums[rightIndex];

            while (sum >= target) {
                minLength = Math.min((rightIndex - leftIndex) + 1, minLength);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }

        return (minLength == nums.length + 1) ? 0 : minLength;
    }

}
