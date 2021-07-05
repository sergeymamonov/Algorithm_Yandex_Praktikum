package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(fibonacci(n, k));
    }

    private static long fibonacci(int n, int k) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long first = 1L;
        long second = 1L;
        long next;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next % (long) Math.pow(10, k);
        }
        return second;
    }
}
