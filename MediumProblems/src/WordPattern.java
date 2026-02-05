import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {

        String pattern = "abba";
        String s = "dog cat cat dog";
        String pattern2 = "aaaa";
        String s2 = "dog cat cat dog";

        String patternTest = "abba";
        String sTest = "dog dog dog dog";
        System.out.printf("Word pattern: %s", wordPattern(patternTest, sTest));
    }

    public static boolean wordPattern(String pattern, String s){

        if (pattern == null || s == null) {
            return false;
        }

        Map<Character, String> wordMap = new HashMap<>();

        String[] sArr = s.split("\\s+");

        if (sArr.length != pattern.length()) return false;

        for (int pIdx = 0; pIdx < pattern.length(); pIdx++) {
            Character pLetter = pattern.charAt(pIdx);
            if (!wordMap.containsKey(pLetter) && !wordMap.containsValue(sArr[pIdx])) {
                wordMap.put(pLetter, sArr[pIdx]);
            }

            if (!wordMap.containsKey(pLetter) || !wordMap.get(pLetter).equals(sArr[pIdx])){
                return false;
            }
        }
        return true;
    }

}
