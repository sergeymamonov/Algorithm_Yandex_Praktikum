package even_and_odd_numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        boolean isEven = numbers.get(0) % 2 == 0;

        for (int i = 1; i < 3; i++) {
            if ((numbers.get(i) % 2 == 0) != isEven) {
                System.out.println("FAIL");
                return;
            }
        }
        System.out.println("WIN");
    }
}
