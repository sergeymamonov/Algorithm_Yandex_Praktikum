package correct_bracket_seq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        gen_brackets(n, 0, 0, "");
    }

    private static void gen_brackets(int n, int counter_open, int counter_close, String prefix) {
        if (counter_open + counter_close == 2 * n) {
            System.out.println(prefix);
            return;
        }
        if (counter_open < n) {
            gen_brackets(n, counter_open + 1, counter_close, prefix + "(");
        }
        if (counter_open > counter_close) {
            gen_brackets(n, counter_open, counter_close + 1, prefix + ")");
        }
    }
}
