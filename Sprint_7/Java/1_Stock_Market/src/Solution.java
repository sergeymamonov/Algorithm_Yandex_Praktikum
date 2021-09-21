import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int daysQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] prices = new int[daysQuantity + 1];
        for (int i = 1; i <= daysQuantity; i++) {
            prices[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (daysQuantity < 2) {
            System.out.println(0);
        }

        int i = 2;
        int currentMin = prices[1];
        int currentMax = prices[1];
        int profit = 0;
        while (i <= daysQuantity) {
            if (prices[i] <= currentMax) {
                profit += currentMax - currentMin;
                currentMin = prices[i];
            }
            currentMax = prices[i];
            i++;
        }

        System.out.println(profit + currentMax - currentMin);
    }
}
