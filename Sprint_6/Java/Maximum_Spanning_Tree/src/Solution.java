//53044568
//
// Принцип работы алгоритма:
//      В основу взят алгоритм Прима. Начиная с первой вершины определяем, какое ребро, исходящее из этой вершины
//      имеет наибольший вес. Для этого ребра добавляются в кучу, что дает определение ребра с максимальным весом
//      за O(1).
//      За каждую итерацию в максимальное остовное дерево (в соответствующие структуры данных) добавляются
//      по одному ребру и одной вершине.
//      Если после обработки всех доступных из первой вершины вершин в массиве не посещенных вершин останутся вершины,
//      значит граф состоит более чем из одной компоненты связанности.
//      После нахождения максимального остовного дерева суммируются все веса этого дерева.
//
// Обоснование корректности:
//      Алгоритм корректен, так как сравниваются веса всех ребер, доступных из каждой вершины. Если остаются не посещенные
//      ребра, значит компонент связанности в графе более чем одна. Построение остовного дерева для такого графа невозможно.
//      Алгоритм заканчивает работу с выводом соответствующего сообщения.
//
// Временная сложность:
//      Временная сложность будет складываться из:
//          - просмотра вершин, которые находятся на концах ребер с максимальным весом, O(logV), так как элементы в куче,
//              а для нее добавление за логарифм от глубины, а извлечение за единицу;
//          - просмотра всех ребер O(E).
//      В итоге суммарная временная сложность O(E * logV).
//
// Пространственная сложность:
//      Пространственная сложность складывается из:
//          - множества для добавляемых вершин, в худшем случае O(V), где V - количество вершин;
//          - множества для еще не добавленных вершин, в худшем случае O(V);
//          - массива для хранения ребер максимального остовного дерева, в худшем случае O(E), где E - количество ребер.
//          - кучи для хранения добавляемых ребер, в худшем случае O(E).
//      Итоговая пространственная сложность будет O(V + E).


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
    public static int vertexQuantity;
    public static int edgeQuantity;
    public static int[][] weights;
    public static HashSet<Integer> added = new HashSet<>();
    public static Set<Integer> not_added = new HashSet<>();
    public static ArrayList<Edge> maximumSpanningTree = new ArrayList<>();
    public static PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            return edge2.getWeight() - edge1.getWeight();
        }
    });

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
            if (secondVertex == firstVertex) {
                continue;
            }
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
            if (weight > weights[firstVertex][secondVertex]) {
                weights[firstVertex][secondVertex] = weight;
                weights[secondVertex][firstVertex] = weight;
            }
        }

        for (int i = 1; i <= vertexQuantity; i++) {
            adjacentMap.putIfAbsent(i, null);
        }
    }

    public static String findMaximumSpanningTree() {
        not_added.addAll(adjacentMap.keySet());
        int startVertex = 1;
        addVertex(startVertex);

        while (!not_added.isEmpty() && !edges.isEmpty()) {
            Edge maxEdge = extractMaximum(edges);
            if (not_added.contains(maxEdge.getEndVertex())) {
                maximumSpanningTree.add(maxEdge);
                addVertex(maxEdge.getEndVertex());
            }
        }

        if (!not_added.isEmpty()) {
            return "Oops! I did it again";
        }

        int resultWeight = 0;
        for (Edge edge : maximumSpanningTree) {
            resultWeight += weights[edge.getStartVertex()][edge.getEndVertex()];
        }

        return String.valueOf(resultWeight);
    }

    private static void addVertex(int vertex) {
        added.add(vertex);
        not_added.remove(vertex);
        if (adjacentMap.get(vertex) != null) {
            for (Integer adjacentVertex : adjacentMap.get(vertex)) {
                if (not_added.contains(adjacentVertex)) {
                    edges.add(new Edge(vertex, adjacentVertex, weights[vertex][adjacentVertex]));
                }
            }
        }
    }

    private static Edge extractMaximum(PriorityQueue<Edge> edges) {
        return edges.poll();
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
