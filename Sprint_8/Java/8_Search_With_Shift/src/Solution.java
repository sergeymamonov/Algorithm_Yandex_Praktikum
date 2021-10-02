import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int numbersQuantity;
    public static int patternLength;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        numbersQuantity = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = readNumbers(bufferedReader);
        patternLength = Integer.parseInt(bufferedReader.readLine());
        int[] pattern = readPattern(bufferedReader);

        findAllPatterns(numbers, pattern);
    }

    private static int[] readNumbers(BufferedReader bufferedReader) throws IOException {
        int[] numbers = new int[numbersQuantity];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numbersQuantity; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return numbers;
    }

    private static int[] readPattern(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer;
        int[] pattern = new int[patternLength];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < patternLength; i++) {
            pattern[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return pattern;
    }

    private static void findAllPatterns(int[] numbers, int[] pattern) {
        int start = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int pos = findPattern(numbers, pattern, start);
        stringBuffer.append(pos + 1).append(" ");
        while (pos != -1) {
            start = pos + 1;
            pos = findPattern(numbers, pattern, start);
            if (pos == -1) {
                break;
            }
            stringBuffer.append(pos + 1).append(" ");
        }
        System.out.println(stringBuffer.toString());
    }

    private static int findPattern(int[] numbers, int[] pattern, int start) {
        for (int pos = start; pos <= numbersQuantity - patternLength; pos++) {
            int constant = 0;
            boolean match = true;
            for (int offset = 0; offset < patternLength; offset++) {
                if (pattern[offset] != numbers[offset + pos] - constant) {
                    if (constant == 0) {
                        constant = numbers[offset + pos] - pattern[offset];
                    } else {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                return pos;
            }
        }
        return -1;
    }
}
