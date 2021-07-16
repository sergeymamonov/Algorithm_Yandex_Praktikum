package cookies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int childrenQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> child = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < childrenQuantity; i++) {
            child.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        ArrayList<Integer> cookies = new ArrayList<>();
        int cookiesQuantity = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cookiesQuantity; i++) {
            cookies.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(child);
        Collections.sort(cookies);

        int childrenIndex = 0;
        int cookieIndex = 0;
        int result = 0;
        while (childrenIndex < childrenQuantity && cookieIndex < cookiesQuantity) {
            if (child.get(childrenIndex) <= cookies.get(cookieIndex)) {
                result++;
                childrenIndex++;
            }
            cookieIndex++;
        }
        System.out.println(result);
    }
}
