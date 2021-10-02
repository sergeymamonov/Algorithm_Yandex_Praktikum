import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int[] result = prefixFunction(str);
        printResult(result);
    }

    private static int[] prefixFunction(String str) {
        int[] result = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int k = result[i - 1];
            while (k > 0 && str.charAt(k) != str.charAt(i)) {
                k = result[k - 1];
            }
            if (str.charAt(k) == str.charAt(i)) {
                k++;
            }
            result[i] = k;
        }

        return result;
    }

    private static void printResult(int[] result) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : result) {
            stringBuffer.append(i).append(" ");
        }
        System.out.println(stringBuffer.toString());
    }
}
