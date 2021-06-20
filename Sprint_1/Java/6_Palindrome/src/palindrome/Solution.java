package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        String lowerCaseText = text.toLowerCase(Locale.ROOT);
        int i = 0;
        int j = lowerCaseText.length() - 1;
        char char_left;
        char char_right;
        while (i < j) {
            char_left = lowerCaseText.charAt(i);
            char_right = lowerCaseText.charAt(j);
            if (Character.isLetter(char_left)) {
                if (Character.isLetter(char_right)) {
                    if (char_left != char_right) {
                        System.out.println("False");
                        return;
                    }
                } else {
                    j--;
                    continue;
                }
                j--;
            }
            i++;
        }
        System.out.println("True");
    }
}
