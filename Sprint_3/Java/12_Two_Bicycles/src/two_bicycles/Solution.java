package two_bicycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int dayQuantity = Integer.parseInt(bufferedReader.readLine());
        int[] money = new int[dayQuantity];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < dayQuantity; i++) {
            money[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int bicyclePrice = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(binarySearch(money, bicyclePrice)).append(" ").append(binarySearch(money, bicyclePrice * 2));
        System.out.println(stringBuffer.toString());
    }

    private static int binarySearch(int[] money, int bicyclePrice) {
        if (bicyclePrice > money[money.length - 1]) {
            return -1;
        }
        int first = 0, last = money.length - 1;
        while (first < last) {
            int mid = first + (last - first) / 2;
            if (money[mid] < bicyclePrice) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        if (money[first] < bicyclePrice) {
            return -1;
        } else {
            return first + 1;
        }
    }
}
