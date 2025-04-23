import java.util.Arrays;
import java.util.List;

public class MostWater {

    public static void main(String[] args) {

        List<Integer> testList = List.of(8,7,2,1);

        Integer[] testArray = new Integer[testList.size()];

        System.out.println("Max Area: " + maxArea(testList.toArray(testArray)));

    }

    public static int maxArea(Integer[] height) {

        int left = 0, right = height.length -1;

        int maxArea = 0;

        while(left < right) {

            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;

            // Chnage in case the calculated area it's greater
            maxArea = Math.max(maxArea, minHeight * width);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

}
