package the_longest_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<String> text = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            text.add(stringTokenizer.nextToken());
        }

        int positionOfLongestWord = 0;
        int maxLength = text.get(0).length();
        int lengthOfCurrentWord;
        for (String word : text) {
            lengthOfCurrentWord = word.length();
            if (lengthOfCurrentWord > maxLength) {
                maxLength = lengthOfCurrentWord;
                positionOfLongestWord = text.indexOf(word);
            }
        }

        System.out.println(text.get(positionOfLongestWord));
        System.out.println(maxLength);
    }
}
