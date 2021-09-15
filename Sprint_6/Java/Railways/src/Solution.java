//53003727
//
// Принцип работы алгоритма:
//      На вход подается строка с типом железной дороги из города i в город i + j + 1. Из города i в город i + j + 1
//      можно добраться как по дорогам типа R, так и по дорогам типа B. Переведя в графы задачу можно представить в виде
//      вершин - городов и ребер - железных дорог.
//      Возьмем пример из трех городов. В котором из первого город можно добраться в город 2 с помощью дороги типа В,
//      а в город 3 с помощью дороги типа R. Из второго города можно добраться в город 3 с помощью дороги типа В.
//      На примере из трех городов видно что в город 3 можно добраться двумя путями:
//          - из города 1 через город 2 по дорогам типа В;
//          - из города 1 напрямую по дороге типа R.
//      Образуется цикл, состоящий из двух дороги типа В (города 1 - 2 и 2 - 3) и дороги типа R (города 1 - 3).
//      Таким образом чтобы дать ответ на задачу оптимальна ли сеть железных дорог или нет необходимо построить
//      граф и определить имеются ли в нем циклы или нет.
//      Чтобы трансформировать входные данные в граф выберем для железной дороги типа B направление ребра из города i
//      в город i + j + 1, а для типа R наоборот.
//      В основе алгоритма для нахождения цикла в графе лежит алгоритм DFS. В хоже обхода графа вершины будут раскрашиваться.
//      Изначально все вершины белые. При первом заходе в нее цвет меняется на серый. При выходе цвет меняется на черный.
//      При этом, если в ходе обхода графа мы попадаем в вершину с серым цветом, это говорит о том, что в графе есть цикл.
//
// Обоснование корректности:
//      Алгоритм корректен, так как в ходе обхода в глубину посещенные вершины раскрашиваются в серый и черный цвета.
//      Где серый цвет говорит о том, что в вершину уже заходили и добавили в очередь на обработку вершины, находящиеся
//      на концах исходящих из этой вершины ребер. Но серый цвет также говорит о том, что выхода из этой вершины еще
//      не было, в отличии от вершины с черным цветом. Поэтому попадание в вершину с серым цветом говорит о том,
//      что в графе есть цикл.
//
// Временная сложность:
//      Временная сложность будет складываться из:
//          - просмотра всех вершин, O(V), где V - количество вершин;
//          - просмотра всех ребер, O(E), где E - количество ребер.
//      В итоге суммарная временная сложность составляет O(V * E).
//
// Пространственная сложность:
//      Пространственная сложность складывается из хранения:
//          - массива для хранения цветов раскраски вершин, O(V);
//          - стека для хранения вершин, подлежащих обработке, O(V).
//      Итоговая пространственная сложность составляет O(V).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static int vertexQuantity;
    public static int[] color;
    public static ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputDirectedGraph();
        chekLoopInGraph();
    }

    private static void inputDirectedGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        vertexQuantity = Integer.parseInt(bufferedReader.readLine());

        initializeAdjacentList();
        addEdge(bufferedReader);
    }

    private static void initializeAdjacentList() {
        for (int i = 0; i <= vertexQuantity; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            adjacentList.add(list);
        }
    }

    private static void addEdge(BufferedReader bufferedReader) throws IOException {
        for (int i = 1; i < vertexQuantity; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < line.length(); j++) {
                int firstVertex;
                int secondVertex;
                if (line.charAt(j) == 'R') {
                    firstVertex = i;
                    secondVertex = i + j + 1;
                } else {
                    firstVertex = i + j + 1;
                    secondVertex = i;
                }

                adjacentList.get(firstVertex).add(secondVertex);
            }
        }
    }

    private static void chekLoopInGraph() {
        if (findLoop()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static boolean findLoop() {
        color = new int[vertexQuantity + 1];//0 - white, 1 - grey, 2 - black, первый элемент фиктивный
        for (int i = 1; i <= vertexQuantity; i++) {
            if (color[i] == 0) {
                if (hasLoop(i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasLoop(int startVertex) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (color[vertex] == 0) {
                color[vertex] = 1;
                stack.add(vertex);
                if (adjacentList.get(vertex) == null) {
                    continue;
                }

                for (Integer adjacentVertex : adjacentList.get(vertex)) {
                    if (color[adjacentVertex] == 0) {
                        stack.add(adjacentVertex);
                    }

                    if (color[adjacentVertex] == 1) {
                        return true;
                    }
                }
            } else {
                if (color[vertex] == 1) {
                    color[vertex] = 2;
                }
            }
        }

        return false;
    }
}
