import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numberQuantity; i++) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int parts = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numberQuantity; i++) {
            max = Math.max(max, numbers.get(i));
            if (max == i) {
                parts++;
            }
        }
        System.out.println(parts);
    }
}
