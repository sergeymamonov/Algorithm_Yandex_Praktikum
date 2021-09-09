import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static HashMap<Integer, ArrayList<Integer>> components = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static int component_count = 1;

    public static void main(String[] args) throws IOException {
        inputUndirectedGraph();
        componentCount();
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

    public static void componentCount() {
        int[] color = new int[vertexQuantity + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= vertexQuantity; i++) {
            if (color[i] == -1) {
                DFS(i, color);
                component_count++;
            }
        }

        vertexToComponent(color);
        printResult();
    }

    public static void DFS(int startVertex, int[] color) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (color[vertex] == -1) {
                color[vertex] = component_count;
                stack.add(vertex);
                if (adjacentMap.get(vertex) == null) {
                    continue;
                }
                Collections.sort(adjacentMap.get(vertex));
                Collections.reverse(adjacentMap.get(vertex));
                for (Integer adjacentVertex : adjacentMap.get(vertex)) {
                    if (color[adjacentVertex] == -1) {
                        stack.add(adjacentVertex);
                    }
                }
            }
        }
    }

    private static void vertexToComponent(int[] color) {
        for (int vertex = 1; vertex < color.length; vertex++) {
            if (components.containsKey(color[vertex])) {
                components.get(color[vertex]).add(vertex);
            } else {
                ArrayList<Integer> vertexes = new ArrayList<>();
                vertexes.add(vertex);
                components.put(color[vertex], vertexes);
            }
        }
    }

    private static void printResult() {
        System.out.println(component_count - 1);
        StringBuffer stringBuffer = new StringBuffer();
        for (int currentComponent = 1; currentComponent < component_count; currentComponent++) {
            for (Integer vertex : components.get(currentComponent)) {
                stringBuffer.append(vertex).append(" ");
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}
