import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqK {

    public static void main(String[] args) {

        int[] testArray = {1,1,1};
        int k  = 2;

        System.out.println("Num possible arrays: " + subarraySum(testArray, k));

    }

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        int prefixSum = 0, count = 0;

        // Calculate the prefix sum
        for (int num : nums) {
            prefixSum += num;

            int prefSumLef = prefixSum - k;

            if (prefixSumFreq.containsKey(prefSumLef)) {
                count += prefixSumFreq.get(prefSumLef);
            }

            prefixSumFreq.put(
                    prefixSum,
                    prefixSumFreq.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

}
