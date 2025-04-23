import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println("Larges Kth = " + findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k)
                minHeap.poll();// Remove the head of the queue
        }

        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }



}
