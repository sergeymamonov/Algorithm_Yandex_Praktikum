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
        int index = 0;
        int number = 0;
        int result = 0;
        int max = 0;
        while (index < numberQuantity) {
            if (numbers.get(index) > max) {
                max = numbers.get(index);
            }
            if (numbers.get(index) == number && index == max) {
                result++;
                index++;
                number = index;
            } else {
                index++;
            }
        }
        if (result == 0) {
            result = 1;
        }
        System.out.println(result);
    }
}
