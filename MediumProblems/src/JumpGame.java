import java.sql.SQLOutput;

public class JumpGame {

    public static void main(String[] args) {


//        int[] testArray = {2,3,1,1,4}; // 2

//        int[] testArray = {0}; // 0
//        int[] testArray = {1,3,2}; // 2
//        int[] testArray = {1,1,1,1}; // 3

//        int[] testArray = {1,2}; // 1
//        int[] testArray = {5,9,3,2,1,0,2,3,3,1,0,0}; // 3

//        int[] testArray = {10,9,8,7,6,5,4,3,2,1,1,0}; // 2

//        int[] testArray = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}; // 2

//        System.out.println("MAX JUMPS: " + jump(testArray));

        int[][] arrayInts = {
                {2,3,1,1,4},
                {0},
                {1,3,2},
                {1,1,1,1},
                {1,2},
                {5,9,3,2,1,0,2,3,3,1,0,0},
                {10,9,8,7,6,5,4,3,2,1,1,0},
                {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}
        };

        for (int[] test : arrayInts) {
            System.out.println("MIN JUMPS: " + jump2(test));
        }
    }

    public static int jump(int[] nums) {
        int jumps = 0;

        int currentPosition = 0;
        int maxViableIndexToJump = currentPosition;

        for (int i = currentPosition + 1; currentPosition != nums.length - 1; ) {
            if (currentPosition + nums[currentPosition] >= nums.length - 1) {
                currentPosition = nums.length - 1;
                jumps++;
                break;
            }
            if (i <= (currentPosition + nums[currentPosition])) {
//                maxViableIndexToJump = nums[maxViableIndexToJump] <= nums[i] ? i : maxViableIndexToJump;
                // Determine the most viable index to jump
                int newReachablePos = Math.min(i + nums[i], nums.length - 1);
                int maxReachablePos = maxViableIndexToJump + nums[maxViableIndexToJump];
                maxViableIndexToJump =
                        newReachablePos >= maxReachablePos
                                ? i : maxViableIndexToJump;
                i++;
            } else {
                currentPosition = maxViableIndexToJump;
                i = currentPosition + 1;
                maxViableIndexToJump = currentPosition + nums[currentPosition];
                jumps++; // We increment the jumps
                if (currentPosition == nums.length - 1) break;
            }
        }


        return jumps;
    }

    public static int jump2(int[] nums) {

        int n = 0, jumps = 0; // nearest position
        int furtherPos = 0; // furhter position of the range

        int farthestPos = 0;
        for (int i = 0; furtherPos < nums.length - 1; ) {
            if(i <= furtherPos) {
                // Check if we hava a greater farthesPosition on i
                farthestPos = Math.max(i + nums[i], farthestPos);
                i++;
            } else {
                n = furtherPos + 1;
                furtherPos = farthestPos;
                farthestPos=0;
                jumps++;
            }
        }

        return jumps;
    }


}
