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
        int vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
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

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= vertexQuantity; i++) {
            if (adjacentMap.containsKey(i)) {
                int currentEdgeQuantity = adjacentMap.get(i).size();
                stringBuffer.append(currentEdgeQuantity).append(" ");
                Collections.sort(adjacentMap.get(i));
                for (Integer vertex : adjacentMap.get(i)) {
                    stringBuffer.append(vertex).append(" ");
                }
                stringBuffer.append("\n");
            } else {
                stringBuffer.append(0).append("\n");
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
