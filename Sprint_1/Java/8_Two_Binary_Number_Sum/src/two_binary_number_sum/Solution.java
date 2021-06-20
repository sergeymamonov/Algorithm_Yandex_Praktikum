package two_binary_number_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String first = bufferedReader.readLine();
        String second = bufferedReader.readLine();
        int maxLength = Math.max(first.length(), second.length());
        String first_number = toMaxLength(first, maxLength);
        String second_number = toMaxLength(second, maxLength);

        char carry = '0';
        StringBuilder result = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = Character.digit(carry, 10) +
                    Character.digit(first_number.charAt(i), 10) +
                    Character.digit(second_number.charAt(i), 10);
            switch (sum) {
                case 0:
                    result = result.insert(0, 0);
                    carry = '0';
                    break;
                case 1:
                    result = result.insert(0, 1);
                    carry = '0';
                    break;
                case 2:
                    result = result.insert(0, 0);
                    carry = '1';
                    break;
                case 3:
                    result = result.insert(0, 1);
                    carry = '1';
                    break;
            }
        }

        if (carry == '1') {
            result.insert(0, carry);
        }

        System.out.println(result);
    }

    private static String toMaxLength(String number, int maxLength) {
        StringBuilder result = new StringBuilder(number);
        while (result.length() < maxLength) {
            result = result.insert(0, "0");
        }
        return result.toString();
    }
}
