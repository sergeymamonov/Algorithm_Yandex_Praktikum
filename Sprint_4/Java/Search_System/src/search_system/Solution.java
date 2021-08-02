package search_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int textsQuantity = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, ArrayList<HashMap<Integer, Integer>>> textIndexes = new HashMap<>();//Слово : {номер текста : релевантность}
        for (int i = 0; i < textsQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                if (textIndexes.containsKey(word)) {
                    for (int j = 0; j < textIndexes.get(word).size(); j++) {
                        if (textIndexes.get(word).get(j).containsKey(i + 1)) {
                            int relevance = textIndexes.get(word).get(j).get(i + 1) + 1;
                            textIndexes.get(word).get(j).put(i + 1, relevance);
                        } else {                                                        //для данного слова еще не добавлен данный текст
                            HashMap<Integer, Integer> map = new HashMap<>();
                            map.put(i + 1, 1);
                            textIndexes.get(word).add(map);
                        }
                    }
                } else {
                    HashMap<Integer, Integer> texts = new HashMap<>();
                    texts.put(i + 1, 1);
                    ArrayList<HashMap<Integer, Integer>> arrayList = new ArrayList<>();
                    arrayList.add(texts);
                    textIndexes.put(word, arrayList);
                }
            }
        }

//        for (Map.Entry<String, ArrayList<HashMap<Integer, Integer>>> pairs : textIndexes.entrySet()) {
//            System.out.println("Word: " + pairs.getKey());
//            for (HashMap<Integer, Integer> maps : pairs.getValue()) {
//                for (Integer textNumber : maps.keySet()) {
//                    System.out.println("TextNumber: " + textNumber + "\t" + "Relevance: " + maps.get(textNumber));
//                }
//            }
//        }
//        System.out.println(textIndexes.size());
//        System.out.println("----------------------------");


        int queriesQuantity = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer("");
        ArrayList<HashMap<Integer, Integer> resultTextRelevance = new ArrayList<>();
        for (int i = 0; i < queriesQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                if (textIndexes.containsKey(word)) {
                    ArrayList<HashMap<Integer, Integer>> textNumberRelevanceForWord = textIndexes.get(word);
                    for (int k = 0; k < textNumberRelevanceForWord.size(); k++) {
                        for (int textNumber = 0; textNumber < textsQuantity; textNumber++) {
                            if (textNumberRelevanceForWord.get(k).containsKey(textNumber)) {
                                if (resultTextRelevance.containsKey(textNumber)) {
                                    int relevance = textIndexes.get(word).get(k).get(textNumber) + resultTextRelevance.get(textNumber);
                                    resultTextRelevance.put(textNumber, relevance);
                                } else {
                                    resultTextRelevance.put(textNumber, textNumberRelevanceForWord.get(k).get(textNumber));
                                }
                            }
                        }
                    }
                }
            }


            for (Map.Entry<Integer, Integer> textNumber_relevance : resultTextRelevance.entrySet()) {
                stringBuffer.append(textNumber_relevance.getKey()).append(" : ").append(textNumber_relevance.getValue()).append("\t");
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}






/*
        HashMap<String, HashMap<Integer, Integer>> textIndexes = new HashMap<>();//Слово : {номер текста : релевантность}
        for (int i = 0; i < textsNumber; i++) {
            String[] words = bufferedReader.readLine().split(" ");
            for (String word : words) {
                if (textIndexes.containsKey(word)) {
                    if (textIndexes.get(word).containsKey(i + 1)) {
                        int relevance = textIndexes.get(word).get(i + 1) + 1;
                        textIndexes.get(word).put(i + 1, relevance);
                    } else {
                        textIndexes.put(word, );
                    }
                } else {
                    HashMap<Integer, Integer> text_ = new HashMap<>();
                    text_.put(i + 1, 1);
                    textIndexes.put(word, text_);
                }
            }
        }
        for (Map.Entry<String, HashMap<Integer, Integer>> pairs : textIndexes.entrySet()) {
            for (Map.Entry<Integer, Integer> pair : pairs.getValue().entrySet()) {
                System.out.println("Word: " + pairs.getKey() + "\t" + "Text: " + pair.getKey() + "\t" + "Relevance: " + pair.getValue());
            }
        }
        System.out.println(textIndexes.size());
        System.out.println("----------------------------");

        int queriesNumber = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < queriesNumber; i++) {
            ArrayList<HashMap<Integer, Integer>> result = new ArrayList<>();
            String[] words = bufferedReader.readLine().split(" ");
            for (String word : words) {
                for (Map.Entry<String, HashMap<Integer, Integer>> pair : textIndexes.entrySet()) {
                    if (pair.getKey().equals(word)) {
                        result.add(pair.getValue());
                    }
                }
            }
            System.out.println("Query " + i);
            for (int j = 0; j < result.size(); j++) {
                for (Map.Entry<Integer, Integer> p : result.get(j).entrySet()) {
                    System.out.println("Text: " + p.getKey() + "\tRelevance: " + p.getValue());
                }
            }
            System.out.println("---------------");
//                stringBuffer.append(number).append(" ");
        }

 */

