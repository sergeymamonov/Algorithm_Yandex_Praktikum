package polinomial_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        long m = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();
        long sum;
        if (line.length() > 1) {
            sum = Math.floorMod((long) line.charAt(0) * a, m) + (long) line.charAt(1);
        } else if (line.length() == 1) {
            sum = (long) line.charAt(0);
        } else {
            sum = 0;
        }
        for (int i = 2; i < line.length(); i++) {
            sum = Math.floorMod(sum * a, m) + (long) line.charAt(i);
        }
        System.out.println(Math.floorMod(sum, m));
    }
}
