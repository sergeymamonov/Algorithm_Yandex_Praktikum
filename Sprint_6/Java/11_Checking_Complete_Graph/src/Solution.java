import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static HashMap<Integer, HashSet<Integer>> matrix = new HashMap<>();

    public static void main(String[] args) throws IOException {
        inputGraph();
        checkingCompleteGraph();
    }

    private static void inputGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            if (firstVertex == secondVertex) {
                continue;
            }
            if (matrix.containsKey(firstVertex)) {
                matrix.get(firstVertex).add(secondVertex);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(secondVertex);
                matrix.put(firstVertex, set);
            }
            if (matrix.containsKey(secondVertex)) {
                matrix.get(secondVertex).add(firstVertex);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(firstVertex);
                matrix.put(secondVertex, set);
            }
        }
    }

    private static void checkingCompleteGraph() {
        for (int i = 1; i <= vertexQuantity; i++) {
            for (int j = i + 1; j <= vertexQuantity; j++) {
                if (matrix.get(i) == null) {
                    System.out.println("NO");
                    return;
                }
                if (!matrix.get(i).contains(j)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
