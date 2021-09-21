import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        String string = bufferedReader.readLine();
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<Integer> result = getPositions(string, n, k, 539L, 2147483648L);
        for (int position : result) {
            stringBuffer.append(position).append(" ");
        }
        System.out.println(stringBuffer.toString());
    }

    public static ArrayList<Integer> getPositions(String string, int n, int k, long base, long mod) {
        HashMap<Long, Integer> counter = new HashMap<>();
        HashMap<Long, Integer> hashToPos = new HashMap<>();
        long hash = getHash(string.substring(0, n), base, mod);
        long power = getPower(n, base, mod);
        counter.put(hash, 1);
        hashToPos.put(hash, 0);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i + n - 1 < string.length(); i++) {
            hash = (hash + mod - (long) string.charAt(i - 1) * power % mod) % mod;
            hash = (hash * base % mod + (long) string.charAt(i + n - 1)) % mod;
            if (!counter.containsKey(hash)) {
                counter.put(hash, 1);
                hashToPos.put(hash, i);
            } else {
                counter.put(hash, counter.get(hash) + 1);
            }

            if (counter.get(hash) == k) {
                result.add(hashToPos.get(hash));
            }
        }
        return result;
    }

    public static long getHash(String string, long base, long mod) {
        long hash = 0L;
        for (int i = 0; i < string.length(); i++) {
            hash = (hash * base % mod + (long) string.charAt(i)) % mod;
        }

        return hash;
    }

    public static long getPower(int n, long base, long mod) {
        long power = 1L;
        for (int i = 0; i < n; i++) {
            power = (power * base) % mod;
        }

        return power;
    }

}
