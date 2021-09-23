import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Long> dp = new ArrayList<>();
        dp.add(1L);
        dp.add(1L);
        long mod = 1_000_000_007L;

        for (int i = 2; i < n; i++) {
            if (i - k - 1 >= 0) {
                dp.add((2L * dp.get(i - 1) + mod - dp.get(i - k - 1)) % mod);
            } else {
                dp.add(2L * dp.get(i - 1) % mod);
            }
        }

        System.out.println(dp.get(n - 1));
    }
}
