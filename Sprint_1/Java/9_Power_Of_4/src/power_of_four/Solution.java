package power_of_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number= Integer.parseInt(bufferedReader.readLine());
        while (number != 1) {
            if (number % 4 != 0) {
                System.out.println("False");
                return;
            }
            number /= 4;
        }

        System.out.println("True");
    }
}
