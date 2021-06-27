//52034513

package nearest_zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int streetLength = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> zeroIndexes = new ArrayList<>();
        for (int i = 0; i < streetLength; i++) {
            if (Integer.parseInt(stringTokenizer.nextToken()) == 0) {
                zeroIndexes.add(i);
            }
        }

        StringBuffer distances = calculateDistance(streetLength, zeroIndexes);
        System.out.println(distances);
    }

    private static StringBuffer calculateDistance(int streetLength, ArrayList<Integer> zeroIndexes) {
        StringBuffer distances = new StringBuffer();
        int middleIndex;
        for (int i = 0; i < zeroIndexes.size(); i++) {
            if (i == 0) {
                distances.append(outputDistanceDecrease(zeroIndexes.get(0)));
                distances.append(outputZero());
            }
            if (i + 1 < zeroIndexes.size()) {
                if (zeroIndexes.get(i + 1) == zeroIndexes.get(i) + 1) {
                    distances.append(outputZero());
                    continue;
                } else {
                    middleIndex = zeroIndexes.get(i) + (zeroIndexes.get(i + 1) - zeroIndexes.get(i)) / 2;
                    distances.append(outputDistanceIncrease(middleIndex - zeroIndexes.get(i) + 1));
                    distances.append(outputDistanceDecrease(zeroIndexes.get(i + 1) - middleIndex - 1));
                }
                distances.append(outputZero());
            }

            if (i == zeroIndexes.size() - 1) {
                distances.append(outputDistanceIncrease(streetLength - zeroIndexes.get(i)));
            }
        }
        return distances;
    }

    private static StringBuffer outputDistanceDecrease(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i > 0) {
            stringBuffer.append(i--).append(" ");
        }
        return stringBuffer;
    }

    private static StringBuffer outputDistanceIncrease(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int k = 1;
        while (k < i) {
            stringBuffer.append(k++).append(" ");
        }
        return stringBuffer;
    }

    private static StringBuffer outputZero() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0 ");
        return stringBuffer;
    }
}
