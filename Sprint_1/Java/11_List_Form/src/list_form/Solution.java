package list_form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumberLength = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < firstNumberLength; i++) {
            digits.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int firstNumber = 0;
        int power = 0;
        for (int i = firstNumberLength - 1; i >= 0; i--) {
            firstNumber += digits.get(i) * (int) (Math.pow(10, power));
            power++;
        }
        int secondNumber = Integer.parseInt(bufferedReader.readLine());
        int sum = firstNumber + secondNumber;
        String sumString = String.valueOf(sum);
        int len = sumString.length();

        for (int i = 0; i < len; i++) {
            System.out.print(sumString.charAt(i) + " ");
        }
    }
}
