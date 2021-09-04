import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vertexesQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int edgesQuantity = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<Integer, ArrayList<Integer>> adjacentMap = writeInAdjacentList(bufferedReader, edgesQuantity);
        int startVertex = Integer.parseInt(bufferedReader.readLine());
        System.out.println(DFS(startVertex, vertexesQuantity, adjacentMap));
    }

    public static HashMap<Integer, ArrayList<Integer>> writeInAdjacentList(BufferedReader bufferedReader, int edgesQuantity) throws IOException {
        HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
        StringTokenizer stringTokenizer;
        for (int i = 0; i < edgesQuantity; i++) {
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
        return adjacentMap;
    }

    public static String DFS(int startVertex, int vertexesQuantity, HashMap<Integer, ArrayList<Integer>> adjacentMap) {
        int[] color = new int[vertexesQuantity + 1];//0 - white, 1 - grey, 2 - black, первый элемент фиктивный
        ArrayList<Integer> stack = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (color[vertex] == 0) {
                stringBuffer.append(vertex).append(" ");
                color[vertex] = 1;
                stack.add(vertex);
                if (adjacentMap.get(vertex) == null) {
                    continue;
                }
                Collections.sort(adjacentMap.get(vertex));
                Collections.reverse(adjacentMap.get(vertex));
                for (Integer adjacentVertex : adjacentMap.get(vertex)) {
                    if (color[adjacentVertex] == 0) {
                        stack.add(adjacentVertex);
                    }
                }
            } else {
                if (color[vertex] == 1) {
                    color[vertex] = 2;
                }
            }
        }

        return stringBuffer.toString();
    }
}
