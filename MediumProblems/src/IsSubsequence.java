public class IsSubsequence {

    public static void main(String[] args) {

        String s = "axc";
        String t = "ahbgdc";

        System.out.printf("Is Subsequence = %b", isSubsequence(s, t));

    }

    public static boolean isSubsequence(String s, String t) {

        if (s.length() > t.length()) {
            return false;
        }

        int sPoint = 0, tPoint = 0;

        while (tPoint < t.length() && sPoint < s.length()) {
            if (t.charAt(tPoint) == s.charAt(sPoint)) {
                sPoint++;
            }
            tPoint++;
        }

        return sPoint == s.length();
    }

}
