import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    /*
        Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
        Return any possible rearrangement of s or return "" if not possible.



        Example 1:

        Input: s = "aab"
        Output: "aba"
        Example 2:

        Input: s = "aaab"
        Output: ""
    * */

    public static void main(String[] args) {

//        String testString = "aab";
//        String testString = "bbbbbbbbbb";
//        String testString = "aaab";
//        String testString = "abbabbaaab";
        String testString = "aabbcc";
        System.out.println("Result: \"" + reorganizeString(testString) + "\"");

    }

    public static String reorganizeString(String s) {

        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> charFrequency = new HashMap<>();

        // Get the char frequency
        for (Character character : s.toCharArray()) {
            charFrequency.put(character, charFrequency.getOrDefault(character, 0) + 1);
        }

        // Store the pairs in a max heap to always poll the max freq character
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())
        );

        // Add all the elements to the queue
        maxHeap.addAll(charFrequency.entrySet());

        while(!maxHeap.isEmpty()) {
            // We start building our result based on the max freq chars
            Map.Entry<Character, Integer> firstEntry = maxHeap.poll(), secondEntry =  maxHeap.poll();

            if (secondEntry == null && !result.isEmpty()) {
                if (result.toString().charAt(result.length() - 1) == firstEntry.getKey() || firstEntry.getValue() > 1)
                    return "";
                else {
                    result.append(firstEntry.getKey());
                    break;
                }
            } else if (secondEntry == null)
                return "";

            // Start alternating the characters of the first two entries
            result.append(firstEntry.getKey()).append(secondEntry.getKey());
            // Decrement their freq
            firstEntry.setValue(firstEntry.getValue() - 1);
            secondEntry.setValue(secondEntry.getValue() - 1);

            // So we add the firstEntry and second entry chars to the maxHeap again with the updated freq
            if (firstEntry.getValue() > 0)
                maxHeap.offer(firstEntry);
            if (secondEntry.getValue() > 0)
                maxHeap.offer(secondEntry);
        }

        return result.toString();

    }

}
