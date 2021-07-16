package home_purchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int homeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int amount = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> prices = new ArrayList<>();
        for (int i = 0; i < homeQuantity; i++) {
            prices.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(prices);

        int index = 0;
        int result = 0;
        while (amount >= prices.get(index)) {
            amount -= prices.get(index);
            result++;
            index++;
            if (index == prices.size()) {
                break;
            }
        }
        System.out.println(result);
    }
}
