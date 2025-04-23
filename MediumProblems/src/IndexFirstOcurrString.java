import java.util.*;

public class IndexFirstOcurrString {

    public static void main(String[] args) {

        String haystack = "misisisippi";
        String needle = "isisip";

        System.out.println("Index first ocurr = " + strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {

        int leftInd = -1, rightIndex = 0;
        int needleInd = 0;

        Queue<Integer> possibleStart = new LinkedList<>();

        for (int i = 0; i < haystack.length() && needleInd < needle.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                possibleStart.add(i);
                leftInd = leftInd == (-1) ? i : leftInd;
                if (possibleStart.contains(leftInd)) possibleStart.remove();
            }

            if (haystack.charAt(i) == needle.charAt(needleInd)) {
                needleInd++;
            } else {
                // Reset the left ind
                leftInd = !possibleStart.isEmpty() ? possibleStart.remove() : -1;
                rightIndex = leftInd == (-1) ? 0 : leftInd + needle.length();
                i = leftInd == (-1) ? i : leftInd - 1;
                needleInd = 0;
            }

        }

        return needleInd >= needle.length() ? leftInd : -1;
    }

}
