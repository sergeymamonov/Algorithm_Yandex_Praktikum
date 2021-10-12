import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int stringsQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<String> strings = new ArrayList<>();
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < stringsQuantity; i++) {
            String str = bufferedReader.readLine();
            strings.add(str);
            if (str.length() < shortest) {
                shortest = str.length();
            }
        }
        int maxCommonPrefix = 0;
        for (int i = 0; i < shortest; i++) {
            char currentLetter = strings.get(0).charAt(i);
            for (int j = 0; j < stringsQuantity; j++) {
                if (strings.get(j).charAt(i) != currentLetter) {
                    System.out.println(maxCommonPrefix);
                    return;
                }
            }
            maxCommonPrefix++;
        }
        System.out.println(maxCommonPrefix);
    }
}
