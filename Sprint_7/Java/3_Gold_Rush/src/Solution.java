import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int backpack = Integer.parseInt(bufferedReader.readLine());
        int heapsQuantity = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Pair> pairs = new ArrayList<>();
        StringTokenizer stringTokenizer;
        for (int i = 0; i < heapsQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int price = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            pairs.add(new Pair(price, weight));
        }

        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair2.getPrice() - pair1.getPrice();
            }
        });

        int currentWeight = 0;
        int i = 0;
        long result = 0;
        while (i < pairs.size() && currentWeight != backpack) {
            int addedWeight = Math.min((backpack - currentWeight), pairs.get(i).getWeight());
            if (addedWeight > 0) {
                result += (long) addedWeight * pairs.get(i).getPrice();
                currentWeight += addedWeight;
            }
            i++;
        }

        System.out.println(result);
    }
}

class Pair {
    int price;
    int weight;

    public Pair(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
