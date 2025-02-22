package com.charly;

import java.util.ArrayList;
import java.util.List;

public class EncryptedNumArray {

    public static void main(String[] args) {


        // Test list 4, 1 ,2 ,3 , 4
        // Expected output: 82
        List<Integer> numbers = new ArrayList<>(List.of(4, 1, 2, 3, 4));

        String encryptedNum = findNumber(numbers);

        System.out.println("Encrypted number: " + encryptedNum);


    }


    public static String findNumber(List<Integer> numbers) {

        String encryptedNum = "";

        for (int i = 0; numbers.size() > 2; i++) {
            String sumValue = String.valueOf(numbers.get(i) + numbers.get(i + 1));
            String replaceVal = sumValue.length() > 1 ? sumValue.charAt(sumValue.length() - 1) + "" : sumValue;

            numbers.set(i, Integer.parseInt(replaceVal));

            if (i + 1 == numbers.size() - 1) {
                // Remove the last element
                numbers.remove(numbers.size() - 1);
                // Restart the index on the first element to start summing again
                i = 0;
            }
        }

        // Get the two encrypted elements on the array
        encryptedNum = "" + numbers.get(0) + numbers.get(1);

        return encryptedNum;

    }

}
