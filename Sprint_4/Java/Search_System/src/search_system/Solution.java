//52322201

//Принцип работы алгоритма:
//      Для каждого слова в тексте вычисляется количество раз, сколько это слово встречается в тексте.
//      Таким образом создается хеш-таблица где ключами являются слова, а значениями являются вложенные
//      хеш-таблицы, где ключами являются номера текстов, а значениями являются частота, с которой встречается
//      слово в тексте. Создание такой таблицы называется построением обратного поискового индекса (inverted index).
//      Далее для каждого слова из запроса делается запрос в хеш-таблицу и возвращается сколько раз встречается это
//      слово в каждом тексте. Далее происходит суммирование частот слов по текстам и таким образом вычисляется
//      самый релевантный текст к запросу.
//
//Обоснование корректности:
//      Алгоритм корректен, так как хеш-таблице хранятся только те ключи, которые встрачались в текстах.
//      Предвычисление позволяет сократить время поиска, так как не нужно для каждого слова в запросе просматривать
//      все тексты. А возвращается только номера текстов, в которых встречалось это слово из запроса, и его частота.
//
//Временная сложность:
//      Для создания хеш-таблицы потребуется просмотреть все тесты со всеми словами в них O(Nтекстов * Mсловвтекстах),
//      где N - количество тестов, M - количество слов в этих текстах.
//      Для поиска каждого запроса, для каждого уникального слова из запроса сделать запрос к хэш-таблице и
//      проитерироваться по хеш-таблице номер текста : частота слова, то есть O(Nзапросов * Mсловвзапросах * Mсловвтекстах).
//
//Пространственная сложность:
//      Создается хеш-таблица (количество уникальных слово в текстах : (количество текстов : частота).
//      Пространственная сложность такой хэш-таблицы будет O(Mсловвтекстах * Nтекстов).


package search_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static final int maxResultOutput = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, HashMap<Integer, Integer>> textIndex = new HashMap<>();
        int textsQuantity = Integer.parseInt(bufferedReader.readLine());
        for (int textNumber = 1; textNumber <= textsQuantity; textNumber++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            createTextIndexForText(textIndex, textNumber, stringTokenizer);
        }

        int queriesQuantity = Integer.parseInt(bufferedReader.readLine());
        StringBuffer result = new StringBuffer("");
        for (int queryNumber = 0; queryNumber < queriesQuantity; queryNumber++) {
            Map<Integer, Integer> resultForQuery = new HashMap<>();
            HashSet<String> queryWords = new HashSet<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            searchForQuery(textIndex, resultForQuery, queryWords, stringTokenizer);

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(resultForQuery.entrySet());
            sortResultForQuery(entryList);
            addInCommonResult(result, entryList);
        }
        System.out.println(result.toString());
    }

    private static void createTextIndexForText(HashMap<String, HashMap<Integer, Integer>> textIndex, int textNumber, StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            if (textIndex.containsKey(word)) {
                if (textIndex.get(word).containsKey(textNumber)) {
                    int frequency = textIndex.get(word).get(textNumber) + 1;
                    textIndex.get(word).put(textNumber, frequency);
                } else {
                    textIndex.get(word).put(textNumber, 1);
                }
            } else {
                HashMap<Integer, Integer> texts = new HashMap<>();
                texts.put(textNumber, 1);
                textIndex.put(word, texts);
            }
        }
    }

    private static void searchForQuery(HashMap<String, HashMap<Integer, Integer>> textIndex, Map<Integer, Integer> resultForQuery, HashSet<String> queryWords, StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            if (!queryWords.contains(word)) {
                queryWords.add(word);
                if (textIndex.containsKey(word)) {
                    for (Map.Entry<Integer, Integer> pair : textIndex.get(word).entrySet()) {
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
    }

    private static void sortResultForQuery(List<Map.Entry<Integer, Integer>> entryList) {
        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();
        comparator = comparator.reversed().thenComparing(Map.Entry::getKey);
        entryList.sort(comparator);
    }

    private static void addInCommonResult(StringBuffer result, List<Map.Entry<Integer, Integer>> entryList) {
        int resultForQuerySize = 0;
        for (Map.Entry<Integer, Integer> pair : entryList) {
            if (resultForQuerySize < maxResultOutput && pair.getValue() != 0) {
                result.append(pair.getKey()).append(" ");
                resultForQuerySize++;
            }
        }
        result.append("\n");
    }
}
