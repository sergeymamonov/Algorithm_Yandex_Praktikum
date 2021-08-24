package combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = bufferedReader.readLine();
        int[] digits = new int[numbers.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        StringBuffer stringBuffer = new StringBuffer("");
//        LinkedList<String> combinations = getCombinations(digits);
        ArrayList<String> combinations = getCombinations2(digits);
        for (int i = 0; i < combinations.size(); i++) {
            stringBuffer.append(combinations.get(i)).append(" ");
        }
        System.out.print(stringBuffer.toString());
    }

    public static LinkedList<String> getCombinations(int[] digits) {
        String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> combinations = new LinkedList<>();
        combinations.add("");
        for (int i = 0; i < digits.length; i++) {
            while (combinations.getFirst().length() == i) {
                for (String letter : alphabet[digits[i]].split("")) {
                    combinations.add(combinations.getFirst() + letter);
                }
                combinations.pop();
            }
        }
        return combinations;
    }

    public static ArrayList<String> getCombinations2(int[] digits) {
        String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> combinations = new ArrayList<>();
        combinations.add("");
        for (Integer digit : digits) {
            ArrayList<String> temp = new ArrayList<>();
            for (String combination : combinations) {
                for (String letter : alphabet[digit].split("")) {
                    temp.add(combination + letter);
                }
            }
            combinations.clear();
            combinations.addAll(temp);
        }
        return combinations;
    }
}
