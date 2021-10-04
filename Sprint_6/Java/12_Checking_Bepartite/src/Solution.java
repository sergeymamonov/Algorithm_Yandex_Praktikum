import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;

    public static void main(String[] args) throws IOException {
        inputUndirectedGraph();
        checkingBipartite();
    }

    public static void inputUndirectedGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            if (!adjacentMap.containsKey(firstVertex)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(secondVertex);
                adjacentMap.put(firstVertex, list);
            } else {
                adjacentMap.get(firstVertex).add(secondVertex);
            }

            if (!adjacentMap.containsKey(secondVertex)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(firstVertex);
                adjacentMap.put(secondVertex, list);
            } else {
                adjacentMap.get(secondVertex).add(firstVertex);
            }
        }
    }

    public static void checkingBipartite() {
        int[] color = new int[vertexQuantity + 1];

        for (int i = 1; i <= vertexQuantity; i++) {
            if (color[i] == 0) {
                if (!checkVertex(color, i)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static boolean checkVertex(int[] color, int startVertex) {
        //color[] 0 - white, 1 - green, 2 - red, первый элемент фиктивный

        LinkedList<Integer> planned = new LinkedList<>();
        planned.add(startVertex);
        color[startVertex] = 1;

        while (!planned.isEmpty()) {
            int currentVertex = planned.pop();
            if (adjacentMap.get(currentVertex) == null) {
                continue;
            }
            for (Integer adjacentVertex : adjacentMap.get(currentVertex)) {
                if (color[adjacentVertex] == 0) {
                    color[adjacentVertex] = 3 - color[currentVertex];
                    planned.add(adjacentVertex);
                }
                if (color[adjacentVertex] == color[currentVertex]) {
                    return false;
                }
            }
        }

        return true;
    }
}
