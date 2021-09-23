import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Long> dp = new ArrayList<>();
        dp.add(1L);
        dp.add(1L);

        long mod = 1_000_000_007;

        for (int i = 2; i <= n; i++) {
            dp.add((dp.get(i - 2) + dp.get(i - 1)) % mod);
        }
        System.out.println(dp.get(n));
    }
}
