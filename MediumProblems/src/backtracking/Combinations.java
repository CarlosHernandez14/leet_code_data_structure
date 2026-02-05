package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> result;
    int n, k;

    public static void main(String[] args) {

        int nIn = 4, kIn = 2;
        System.out.println("Combination: " + new Combinations().combine(nIn, kIn));
    }

    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;
        this.result = new ArrayList<>();
        backtrack(1, new ArrayList<>());
        return this.result;
    }

    public void backtrack(int nIdx, List<Integer> current) {

        if(current.size() == this.k) {
            this.result.add(new ArrayList<>(current));
            return;
        }

        if (nIdx > n) return;
        current.add(nIdx);
        backtrack(nIdx + 1, current);
        current.remove(current.size() - 1);
        if (nIdx < n) {
            backtrack(nIdx + 1, current);
        }

    }



}
