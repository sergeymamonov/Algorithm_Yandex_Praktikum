import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[vertexQuantity + 1][vertexQuantity + 1];

        for (int i = 1; i <= vertexQuantity; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            matrix[firstVertex][secondVertex] = Math.min(matrix[firstVertex][secondVertex], weight);
            matrix[secondVertex][firstVertex] = Math.min(matrix[secondVertex][firstVertex], weight);
        }

        for (int i = 1; i <= vertexQuantity; i++) {
            for (int j = 1; j <= vertexQuantity; j++) {
                for (int k = 1; k <= vertexQuantity; k++) {
                    if (matrix[j][i] != Integer.MAX_VALUE && matrix[i][k] != Integer.MAX_VALUE) {
                        matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                    }
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= vertexQuantity; i++) {
            for (int j = 1; j <= vertexQuantity; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    stringBuffer.append(-1).append(" ");
                } else {
                    stringBuffer.append(matrix[i][j]).append(" ");
                }
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}
