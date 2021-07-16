package two_bicycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int dayQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> money = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < dayQuantity; i++) {
            money.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int bicyclePrice = Integer.parseInt(bufferedReader.readLine());
        System.out.println(binarySearch(money, bicyclePrice) + 1);
        System.out.println(binarySearch(money, bicyclePrice * 2) + 1);
    }

    private static int binarySearch(ArrayList<Integer> money, int bicyclePrice) {
        if (bicyclePrice > money.get(money.size() - 1)) {
            return -1;
        }
        int first = 0, last = money.size() - 1;
        int result1 = last;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (bicyclePrice == money.get(mid)) {
                while (mid >= first) {
                    if (mid - 1 >= 0) {
                        if (bicyclePrice <= money.get(--mid)) {
                            result1 = mid;
                        }
                    }
                }
            }
            if (money.get(mid) > bicyclePrice)
                last = mid - 1;
            else
                first = mid + 1;
        }
        int result2 = last + 1 == money.size() ? -1 : last + 1;
        return Math.min(result1, result2);


    }
        /*
        private static int binarySearch(ArrayList<Integer> money, int bicyclePrice, int leftBound, int rightBound) {
        if (rightBound <= leftBound) {
            return -1;
        }
        int middle = (rightBound - leftBound) / 2;
        System.out.println("BicyclePrice: " + bicyclePrice + "\tMiddle: " + middle);
        if (bicyclePrice <= money.get(middle)) {
            if (middle - 1 >= 0) {
                if (bicyclePrice > money.get(middle - 1)) {
                    return middle;
                }
                return binarySearch(money, bicyclePrice, leftBound, middle);
            } else {
                return middle;
            }
        } else {
            return binarySearch(money, bicyclePrice, middle + 1, rightBound);
        }
    }
         */
}
