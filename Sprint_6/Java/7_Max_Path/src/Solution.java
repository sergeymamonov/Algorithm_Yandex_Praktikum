import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static int startVertex;

    public static void main(String[] args) throws IOException {
        inputUndirectedGraph();
        BFS();
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

        startVertex = Integer.parseInt(bufferedReader.readLine());
    }

    public static void BFS() {
        int[] color = new int[vertexQuantity + 1];//0 - white, 1 - grey, 2 - black, первый элемент фиктивный
        int[] previous = new int[vertexQuantity + 1];
        int[] distance = new int[vertexQuantity + 1];

        LinkedList<Integer> planned = new LinkedList<>();
        planned.add(startVertex);
        color[startVertex] = 1;
        distance[startVertex] = 0;
        StringBuffer stringBuffer = new StringBuffer();

        while (!planned.isEmpty()) {
            int currentVertex = planned.pop();
            stringBuffer.append(currentVertex).append(" ");
            if (adjacentMap.get(currentVertex) == null) {
                continue;
            }
            Collections.sort(adjacentMap.get(currentVertex));
            for (Integer adjacentVertex : adjacentMap.get(currentVertex)) {
                if (color[adjacentVertex] == 0) {
                    distance[adjacentVertex] = distance[currentVertex] + 1;
                    previous[adjacentVertex] = currentVertex;
                    color[adjacentVertex] = 1;
                    planned.add(adjacentVertex);
                }
            }
            color[currentVertex] = 2;
        }
        System.out.println(stringBuffer.toString());
    }

    public static void maxPath() {
ArrayList<Integer> stack = new ArrayList<>();

    }
}
