package search_system;

import java.util.Comparator;
import java.util.Map;

public class ComparatorTreeMap1 implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> map1, Map.Entry<Integer, Integer> map2) {
        if (map1.getValue() < map2.getValue()) {
            return 1;
        }
        if (map1.getValue() > map2.getValue()) {
            return -1;
        }
        if (map1.getKey() > map2.getKey()) {
            return 1;
        }
        return -1;
    }
}
