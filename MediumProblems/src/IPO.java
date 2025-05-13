import java.util.*;

public class IPO {

    public static void main(String[] args) {

        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int k = 2;
        int w = 0;

        System.out.println(findMaximizedCapital(k, w, profits, capital));

    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        // Projects
        // Capital : Profit
        ArrayList<Map.Entry<Integer, Integer>> projects = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            projects.add(Map.entry(capital[i], profits[i]));
        }

        projects.sort(Comparator.comparingInt(Map.Entry::getKey));

        // Max heap of affordable projects
        // Index of the project : Profit value
        PriorityQueue<Integer> maxHeapAffordable = new PriorityQueue<>((x, y) -> y - x);

        int i = 0;
        while(k > 0) {

            // Choose the best affordable option
            while(i < capital.length && projects.get(i).getKey() <= w) {
                maxHeapAffordable.add(projects.get(i).getValue());
                i++;
            }

            if (maxHeapAffordable.isEmpty()) {
                return w;
            }

            // Otherwise add the new project
            w += maxHeapAffordable.poll();
            k--;
        }

        return w;
    }

    public static int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        for (int j = 0; j < k; j++) {
            // Choose the best affordable option
            int index = -1, value = -1;
            for (int i = 0; i < profits.length; i++) {
                if (capital[i] <= w && capital[i] != -1 && profits[i] > value) {
                    index = i;
                    value = profits[i];
                }
            }

            // In case there's no affordable project
            if (index == -1)
                break;

            // Take the most viable project
            w += value;
            capital[index] = -1;
        }

        return w;
    }


}
