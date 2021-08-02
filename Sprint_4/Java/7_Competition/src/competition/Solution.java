package competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numbersQuantity = Integer.parseInt(bufferedReader.readLine());
        if (numbersQuantity == 0) {
            System.out.println(0);
            return;
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[numbersQuantity];
        for (int i = 0; i < numbersQuantity; i++) {
            int digit = Integer.parseInt(stringTokenizer.nextToken());
            if (digit == 0) {
                array[i] = -1;
            } else {
                array[i] = 1;
            }
        }

        System.out.println(maxLength(array, 0));
    }

    public static int maxLength(int[] arr, int k) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
