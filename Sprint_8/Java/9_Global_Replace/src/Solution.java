import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        String pattern = bufferedReader.readLine();
        String replacement = bufferedReader.readLine();

        StringBuilder buffer = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    buffer.append(text.charAt(i));
                } else {
                    result.append(buffer);
                    buffer.setLength(0);
                    if (j != 0) {
                        j = 0;
                        break;
                    }
                    result.append(text.charAt(i));
                    i++;
                    break;
                }

                if (buffer.length() == pattern.length()) {
                    result.append(replacement);
                    buffer.setLength(0);
                }
                i++;
            }
        }
        System.out.println(result.toString());
    }
}
