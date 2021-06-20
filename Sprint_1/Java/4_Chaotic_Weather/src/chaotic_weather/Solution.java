package chaotic_weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> temperatures = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            temperatures.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        if (size == 1) {
            System.out.println(1);
            return;
        }

        int result = 0;
        if (temperatures.get(0) > temperatures.get(1)) {
            result++;
        }
        if (temperatures.get(size - 2) < temperatures.get(size - 1)) {
            result++;
        }
        for (int i = 1; i <= size - 2; i++) {
            if (temperatures.get(i - 1) < temperatures.get(i) && temperatures.get(i) > temperatures.get(i + 1)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
