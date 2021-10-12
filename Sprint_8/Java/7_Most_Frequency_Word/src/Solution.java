import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordsQuantity = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> wordsCount = new HashMap<>();
        int maxFrequency = 0;
        for (int i = 0; i < wordsQuantity; i++) {
            String word = bufferedReader.readLine();
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
            if (wordsCount.get(word) > maxFrequency) {
                maxFrequency = wordsCount.get(word);
            }
        }

        ArrayList<String> mostFrequencyWords = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : wordsCount.entrySet()) {
            if (pair.getValue() == maxFrequency) {
                mostFrequencyWords.add(pair.getKey());
            }
        }

        Collections.sort(mostFrequencyWords);
        System.out.println(mostFrequencyWords.get(0));
    }
}
