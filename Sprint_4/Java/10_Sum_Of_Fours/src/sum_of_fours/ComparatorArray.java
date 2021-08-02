package sum_of_fours;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorArray implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        for (int i = 0; i < 4; i++) {
            if (array1.get(i) > array2.get(i)) {
                return 1;
            }
            if (array1.get(i) < array2.get(i)) {
                return -1;
            }
        }
        return 0;
    }
}
