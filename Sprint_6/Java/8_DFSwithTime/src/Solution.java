import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;

    public static void main(String[] args) throws IOException {
        inputDirectedGraph();
        int startVertex = 1;
        System.out.println(DFSwithTime(startVertex, vertexQuantity, adjacentMap));
    }

    public static void inputDirectedGraph() throws IOException {
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
        }
    }

    public static String DFSwithTime(int startVertex, int vertexesQuantity, HashMap<Integer, ArrayList<Integer>> adjacentMap) {
        int[] color = new int[vertexesQuantity + 1];//0 - white, 1 - grey, 2 - black, первый элемент фиктивный
        int[] entry = new int[vertexesQuantity + 1];//первый элемент фиктивный
        int[] leave = new int[vertexesQuantity + 1];//первый элемент фиктивный

        int time = -1;
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (color[vertex] == 0) {
                time++;
                entry[vertex] = time;
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
                    time++;
                    leave[vertex] = time;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < entry.length; i++) {
            stringBuffer.append(entry[i]).append(" ").append(leave[i]).append("\n");
        }

        return stringBuffer.toString();
    }
}
