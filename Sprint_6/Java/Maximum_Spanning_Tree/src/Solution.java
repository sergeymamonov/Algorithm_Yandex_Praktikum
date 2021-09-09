import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static int[][] weights;
    public static ArrayList<Edge> maximumSpanningTree = new ArrayList<>();
    public static PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            return edge2.getWeight() - edge1.getWeight();
        }
    });
    public static HashSet<Integer> added = new HashSet<>();
    public static Set<Integer> not_added = new HashSet<>();


    public static void main(String[] args) throws IOException {
        inputUndirectedGraph();
        System.out.println(findMaximumSpanningTree());
    }

    public static void inputUndirectedGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        weights = new int[vertexQuantity + 1][vertexQuantity + 1];
        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
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
            weights[firstVertex][secondVertex] = weight;
        }
    }

    public static String findMaximumSpanningTree() {
        not_added = adjacentMap.keySet();
        int startVertex = 1;
        addVertex(startVertex);

        while (!not_added.isEmpty() && !edges.isEmpty()) {
            Edge maxEdges = extractMaximum(edges);
            if (not_added.contains(maxEdges.getEndVertex())) {
                maximumSpanningTree.add(maxEdges);
                addVertex(maxEdges.getEndVertex());
            }
        }

        if (!not_added.isEmpty()) {
            return "Oops! I did it again";
        } else {
            int resultWeight = 0;
            for (Edge edge : maximumSpanningTree) {
                resultWeight += weights[edge.getStartVertex()][edge.getEndVertex()];
            }
            return String.valueOf(resultWeight);
        }
    }

    private static Edge extractMaximum(PriorityQueue<Edge> edges) {
        return edges.poll();
    }

    private static void addVertex(int vertex) {
        added.add(vertex);
        not_added.remove(vertex);
        if (adjacentMap.get(vertex) != null) {
            for (Integer adjacentVertex : adjacentMap.get(vertex)) {
                if (not_added.contains(vertex)) {
                    edges.add(new Edge(vertex, adjacentVertex, weights[vertex][adjacentVertex]));
                }
            }
        }
    }
}

class Edge {
    int startVertex;
    int endVertex;
    int weight;

    public Edge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public int getWeight() {
        return weight;
    }
}
