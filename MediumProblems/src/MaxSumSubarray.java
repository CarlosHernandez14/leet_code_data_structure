public class MaxSumSubarray {

    public static void main(String[] args) {

        int[] testArray = {5,4,-1,7,8};

        System.out.println("Max sum subArray = " + maxSubArray(testArray));

    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            // Should start a new sum or continue with current one
            if (currentSum < nums[i]){
                // Start over the sum
                currentSum = nums[i];
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
