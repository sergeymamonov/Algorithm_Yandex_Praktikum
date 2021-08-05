//52285633


package search_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int textsQuantity = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, HashMap<Integer, Integer>> textIndexes = new HashMap<>();
        for (int textNumber = 0; textNumber < textsQuantity; textNumber++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                if (textIndexes.containsKey(word)) {
                    if (textIndexes.get(word).containsKey(textNumber + 1)) {
                        int relevance = textIndexes.get(word).get(textNumber + 1) + 1;
                        textIndexes.get(word).put(textNumber + 1, relevance);
                    } else {
                        textIndexes.get(word).put(textNumber + 1, 1);
                    }
                } else {
                    HashMap<Integer, Integer> texts = new HashMap<>();
                    texts.put(textNumber + 1, 1);
                    textIndexes.put(word, texts);
                }
            }
        }

        int queriesQuantity = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer("");
        for (int queryNumber = 0; queryNumber < queriesQuantity; queryNumber++) {
            Map<Integer, Integer> resultForQuery = new HashMap<>();
            HashSet<String> queryWords = new HashSet<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                if (!queryWords.contains(word)) {
                    queryWords.add(word);
                    if (textIndexes.containsKey(word)) {
                        for (Map.Entry<Integer, Integer> pair : textIndexes.get(word).entrySet()) {
                            int textNumber = pair.getKey();
                            if (resultForQuery.containsKey(textNumber)) {
                                int newRelevance = pair.getValue() + resultForQuery.get(textNumber);
                                resultForQuery.put(textNumber, newRelevance);
                            } else {
                                resultForQuery.put(textNumber, pair.getValue());
                            }
                        }
                    }
                }
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(resultForQuery.entrySet());
            Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();
            comparator = comparator.reversed().thenComparing(Map.Entry::getKey);

            entryList.sort(comparator);

            int resultForQuerySize = 0;
            for (Map.Entry<Integer, Integer> pair : entryList) {
                if (resultForQuerySize < 5 && pair.getValue() != 0) {
                    stringBuffer.append(pair.getKey()).append(" ");
                    resultForQuerySize++;
                }
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}
