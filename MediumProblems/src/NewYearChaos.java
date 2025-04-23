import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NewYearChaos {

    public static void main(String[] args) {

        // 1, 2, 3, 5, 4, 6, 7, 8
        // 4, 1, 2, 3
        // 2, 1, 5, 3, 4
        // 2, 5, 1, 3, 4
        List<Integer> q = List.of(1, 2, 5, 3, 7 , 8, 6, 4); // 1, 2, 3, 4, 5, 6, 7, 8

        minimumBribes(q);
    }

    public static void minimumBribes(List<Integer> q) {

        ArrayList<Integer> swapList = new ArrayList<>(q);

        int swaps = 0;

        for (int i = swapList.size() - 1; i >= 0; i--) {

            // Check if we need to swap
            if (swapList.get(i) != i + 1) {
                // Case of 1 swap
                if ((i-1) >= 0 && swapList.get(i - 1) == (i + 1)) {
                    // Swap from 1 before
                    int tempValue = swapList.get(i-1);
                    swapList.set(i-1, swapList.get(i));
                    swapList.set(i, tempValue);
                    swaps++;
                } else if ((i-2) >= 0 && swapList.get(i-2) == (i+1)) {
                    int temp = swapList.get(i-2);
                    swapList.set(i-2, swapList.get(i - 1));
                    swapList.set(i - 1, swapList.get(i));
                    swapList.set(i, temp);
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }

        }

        System.out.println(swaps);
    }


}
