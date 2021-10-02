import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static int startVertex;
    public static int endVertex;

    public static void main(String[] args) throws IOException {
        inputUndirectedGraph();
        System.out.println(findDistance());
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
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        startVertex = Integer.parseInt(stringTokenizer.nextToken());
        endVertex = Integer.parseInt(stringTokenizer.nextToken());
    }

    public static int findDistance() {
        if (startVertex == endVertex) {
            return 0;
        }

        int[] color = new int[vertexQuantity + 1];//0 - white, 1 - grey, 2 - black, первый элемент фиктивный
        int countEdges = 0;
        ArrayList<Integer> currentLayer = new ArrayList<>();
        ArrayList<Integer> nextLayer = new ArrayList<>();
        nextLayer.add(startVertex);
        color[startVertex] = 1;

        while (!nextLayer.isEmpty()) {
            currentLayer.addAll(nextLayer);
            nextLayer.clear();
            countEdges++;

            while (!currentLayer.isEmpty()) {
                int currentVertex = currentLayer.remove(currentLayer.size() - 1);
                if (adjacentMap.get(currentVertex) == null) {
                    continue;
                }

                for (Integer adjacentVertex : adjacentMap.get(currentVertex)) {
                    if (adjacentVertex == endVertex) {
                        return countEdges;
                    }

                    if (color[adjacentVertex] == 0) {
                        color[adjacentVertex] = 1;
                        nextLayer.add(adjacentVertex);
                    }
                }
                color[currentVertex] = 2;
            }
        }

        return -1;
    }
}

