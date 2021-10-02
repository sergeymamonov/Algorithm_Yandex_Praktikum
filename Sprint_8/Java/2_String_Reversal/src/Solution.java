import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer result = new StringBuffer();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while (stringTokenizer.hasMoreTokens()) {
            result.insert(0, " ");
            result.insert(0, stringTokenizer.nextToken());
        }

        System.out.println(result.toString());
    }
}
