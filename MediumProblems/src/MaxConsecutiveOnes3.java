public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

//        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int k = 3;

        System.out.println("Max Consec Ones = " + longestOnes(nums, k));

    }

    public static int longestOnes(int[] nums, int k) {

        int maxOnes = 0, zeroCount = 0;

        int lefPointer = 0, rightPointer;
        for(rightPointer = 0 ; rightPointer < nums.length ; rightPointer++) {

            zeroCount += nums[rightPointer] == 0 ? 1 : 0;

            // Case of max ceros
            if (zeroCount > k) {
                while (zeroCount > k) {
                    zeroCount -= nums[lefPointer] == 0 ? 1 : 0;
                    lefPointer++;
                }
            }

            maxOnes = Math.max(maxOnes, rightPointer - lefPointer + 1);

        }


        return maxOnes;
    }

}
