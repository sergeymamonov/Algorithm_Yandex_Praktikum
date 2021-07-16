package combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, String> keyboard = new HashMap<>();

    static {
        keyboard.put('2', "abc");
        keyboard.put('3', "def");
        keyboard.put('4', "ghi");
        keyboard.put('5', "jkl");
        keyboard.put('6', "mno");
        keyboard.put('7', "pqrs");
        keyboard.put('8', "tuv");
        keyboard.put('9', "wxyz");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = bufferedReader.readLine();
        getCombinations(numbers, numbers.length(), 0, 0, "");
    }

    public static void getCombinations(String numbers, int len, int countButton, int countSign, String prefix) {
        if (countButton == len) {
            System.out.print(prefix + " ");
            return;
        }

        if (countButton < len) {
        char button = numbers.charAt(countButton);
            if (countSign + 1 < keyboard.get(button).length()) {
                getCombinations(numbers, len, countButton, countSign + 1, prefix + keyboard.get(button).charAt(countSign));
            }
//            getCombinations(numbers, len, countButton + 1, countSign, prefix + keyboard.get(button).charAt(countSign));
        }
    }
}
