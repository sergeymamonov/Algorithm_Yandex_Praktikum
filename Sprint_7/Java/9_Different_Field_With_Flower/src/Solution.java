import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] field = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                field[i][j] = Character.digit(line.charAt(j), 10);
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = field[0][0];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + field[i - 1][j - 1];
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        if (n > 1 && m > 1) {
            int i = n;
            int j = m;
            while (i > 0 && j > 0) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    stringBuffer.append("U");
                    i--;
                } else {
                    stringBuffer.append("R");
                    j--;
                }
                if (i == 1 && j == 1) {
                    break;
                }
            }
        }

        System.out.println(dp[n][m]);
        System.out.println(stringBuffer.reverse().toString());
    }
}
