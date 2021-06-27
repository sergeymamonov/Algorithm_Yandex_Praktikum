package extra_letter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lineOne = bufferedReader.readLine();
        String lineTwo = bufferedReader.readLine();
        String[] letter_1 = lineOne.split("");
        String[] letter_2 = lineTwo.split("");
        HashMap<String, Integer> lettersLineOne = new HashMap<>();
        HashMap<String, Integer> lettersLineTwo = new HashMap<>();
        for (int i = 0; i < lineOne.length(); i++) {
            if (lettersLineOne.containsKey(letter_1[i])) {
                lettersLineOne.put(letter_1[i], lettersLineOne.get(letter_1[i]) + 1);
            } else {
                lettersLineOne.put(letter_1[i], 1);
            }
        }

        for (int i = 0; i < lineTwo.length(); i++) {
            if (lettersLineTwo.containsKey(letter_2[i])) {
                lettersLineTwo.put(letter_2[i], lettersLineTwo.get(letter_2[i]) + 1);
            } else {
                lettersLineTwo.put(letter_2[i], 1);
            }
        }

        for (Map.Entry<String, Integer> entrySecond : lettersLineTwo.entrySet()) {
            if (!lettersLineOne.containsKey(entrySecond.getKey())) {
                System.out.println(entrySecond.getKey());
            }
            for (Map.Entry<String, Integer> entryFirst : lettersLineOne.entrySet()) {
                if (entrySecond.getKey().equals(entryFirst.getKey())) {
                    if (!entrySecond.getValue().equals(entryFirst.getValue())) {
                        System.out.println(entrySecond.getKey());
                    }
                }
            }
        }
    }
}
