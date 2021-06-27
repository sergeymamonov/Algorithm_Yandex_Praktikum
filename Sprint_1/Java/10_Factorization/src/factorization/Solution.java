package factorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int originalNumber = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int number = originalNumber;
        int currentDivider = 2;
        boolean plusTwo = false;
        while (number != 1) {
            if (number % currentDivider != 0) {
                if (!plusTwo) {
                    currentDivider++;
                    plusTwo = true;
                } else {
                    currentDivider += 2;
                }
            } else {
                number /= currentDivider;
                stringBuilder.append(currentDivider);
                stringBuilder.append(" ");
            }
        }
        if (stringBuilder.toString().equals("")) {
            System.out.println(originalNumber);
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
