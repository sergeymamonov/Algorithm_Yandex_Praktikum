import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int islandsQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> islandsSquare = new ArrayList<>();
        for (int i = 0; i < islandsQuantity; i++) {
            islandsSquare.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int k = Integer.parseInt(bufferedReader.readLine());

        

    }
}
