public class TrappingRainWater {

    public static void main(String[] args) {


        int[] testHeight = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Trapped Water = " + trap(testHeight));

    }

    public static int trap(int[] height) {

        int leftBound = 0, rightBound = height.length - 1;

        int trappedWater = 0;
        int currentLeftInd = 0, currentRightInd = height.length - 1;

        while(currentLeftInd < currentRightInd) {

            int minBound = height[leftBound] <= height[rightBound] ? leftBound : rightBound;

            if (minBound == leftBound)  {
                currentLeftInd++;
                // Calculate trap water
                int trapped = height[leftBound] - height[currentLeftInd];
                trappedWater += Math.max(trapped, 0);
                leftBound = height[leftBound] < height[currentLeftInd] ? currentLeftInd : leftBound;
            } else {
                currentRightInd--;
                // Means the right bound is the minBound
                int trapped = height[rightBound] - height[currentRightInd];
                trappedWater += Math.max(trapped, 0);
                rightBound = height[rightBound] < height[currentRightInd] ? currentRightInd : rightBound;
            }

        }

        return trappedWater;
    }

}
