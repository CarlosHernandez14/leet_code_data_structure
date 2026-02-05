import java.util.Arrays;
import java.util.Collections;

public class TwoSum2 {

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int firstIndex = 0, secondIndex = numbers.length - 1;

        while (firstIndex < secondIndex) {
            int sum = numbers[firstIndex] + numbers[secondIndex];
            if (sum == target)
                break;

            if (sum < target)
                firstIndex++;
            else
                secondIndex--;
        }

        return new int[] {++firstIndex, ++secondIndex};
    }

}
