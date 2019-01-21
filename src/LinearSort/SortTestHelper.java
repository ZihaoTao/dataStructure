package LinearSort;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tino on 1/9/19.
 */

public class SortTestHelper {

    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert(rangeL <= rangeR);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (int)Math.floor(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static int[] generateRandomUniqueArray(int n, int rangeL, int rangeR) {
        assert(rangeL <= rangeR);
        int[] arr = new int[n];
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int item = (int)Math.floor(Math.random() * (rangeR - rangeL + 1) + rangeL);
            if(!set.contains(item)) {
                arr[i] = item;
                set.add(item);
            } else {
                i--;
            }

        }
        return arr;
    }
}
