import java.util.Arrays;

public class MaxSumCircularSubarray {

    public static void main(String[] args) {

        int[] testArray = {-3,-2,-3};

        System.out.println("Max sum circular: " + maxSubarraySumCircular(testArray));

    }


    public static int maxSubarraySumCircular(int[] nums) {

        int maxNormalSum = kadanesMaxSum(nums);

        int sumArr = Arrays.stream(nums).sum();


        int[] invertedSignArray = Arrays
                .stream(nums)
                .map(operand -> operand * (-1))
                .toArray();

        // In case the max sum is on the circular case
        int circularMaxSum = kadanesMaxSum(invertedSignArray) + sumArr;

        for(int num : nums) {
            if (num >= 0) return Math.max(maxNormalSum, circularMaxSum);
        }

        // Means there's no possitive numbers in the array
        return maxNormalSum;
    }

    public static int kadanesMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {

            currentSum += num;

            if (currentSum < num)
                currentSum = num; // Start over the sum

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
