import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int firstArrayLength = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] firstArray = new int[firstArrayLength];
        for (int i = 0; i < firstArrayLength; i++) {
            firstArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int secondArrayLength = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] secondArray = new int[secondArrayLength];
        for (int i = 0; i < secondArrayLength; i++) {
            secondArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(getLCS(firstArray, secondArray));
    }

    public static int getLCS(int[] firstArray, int[] secondArray) {
        int maxLength = 0;
        int left = 1;
        int right = Math.max(firstArray.length, secondArray.length);

        while (left <= right) {
            int middle = (left + right) / 2;
            if (checkCollision(firstArrayHashes, secondArrayHashes, middle)) {
                maxLength = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return maxLength;
    }

    private static boolean checkCollision(int[] firstArray, int[] secondArray, int window) {

    }
}
