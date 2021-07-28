package substrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int NO_OF_CHARS = 256;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();

        int n = string.length();
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int i;
        int[] visited = new int[NO_OF_CHARS];

        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        visited[string.charAt(0)] = 0;

        for (i = 1; i < n; i++) {
            prev_index = visited[string.charAt(i)];
            if (prev_index == -1 || i - cur_len > prev_index) {
                cur_len++;
            }
            else {
                if (cur_len > max_len) {
                    max_len = cur_len;
                }
                cur_len = i - prev_index;
            }
            visited[string.charAt(i)] = i;
        }

        if (cur_len > max_len) {
            max_len = cur_len;
        }

        System.out.println(max_len);
    }
}
