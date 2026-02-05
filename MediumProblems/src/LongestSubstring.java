public class LongestSubstring {

    public static void main(String[] args) {

        String input = "abcabcbb";
        String input1 = "bbbbbb";
        String empty = " ";
        String input3 = "dvdf";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(input3));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int leftInd = 0, rightInd = 0, longest = 0;

        String subS = "";

        while(rightInd < s.length()) {
            // if the letter at right pos repeats move left side of window
            if (subS.contains(String.valueOf(s.charAt(rightInd)))) {
                // a char repeats
                longest = Math.max(longest, subS.length()); // calc longest again
                // move left idx to find the idx of the char that repeats
                while (leftInd <= rightInd) {
                    if (s.charAt(leftInd++) == s.charAt(rightInd)) break;
                }
            }
            subS = s.substring(leftInd, rightInd + 1);
            rightInd++;
        }
        longest = Math.max(longest, subS.length());

        return longest;
    }

}


