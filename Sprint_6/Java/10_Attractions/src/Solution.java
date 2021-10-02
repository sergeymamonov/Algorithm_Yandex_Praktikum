import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[vertexQuantity + 1][vertexQuantity + 1];

        for (int i = 1; i <= vertexQuantity; i++) {
            Arrays.fill(matrix[i], -1);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            matrix[firstVertex][secondVertex] = weight;
            matrix[secondVertex][firstVertex] = weight;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= vertexQuantity; i++) {
            for (int j = 1; j <= vertexQuantity; j++) {
                stringBuffer.append(matrix[i][j]).append(" ");
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());

    }
}
