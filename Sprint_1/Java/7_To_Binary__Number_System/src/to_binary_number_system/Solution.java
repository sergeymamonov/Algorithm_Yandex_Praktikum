package to_binary_number_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        if (number == 0) {
            System.out.println("0");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (number >= 1) {
            stringBuilder.append(number % 2);
            number /= 2;
        }
        System.out.println(stringBuilder.reverse());
    }
}
