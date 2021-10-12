import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) % 2 == 0) {
                stringBuilder1.append(str1.charAt(i));
            }
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) % 2 == 0) {
                stringBuilder2.append(str2.charAt(i));
            }
        }

        int result = stringBuilder1.compareTo(stringBuilder2);
        System.out.println(Integer.compare(result, 0));
    }
}
