package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */
// O(n^2)
// if the data is nearly ordered, insertion sort is fast

public class insertionSort {

    public void sort(int[] arr, int n) {
        for (int i = 1; i < n; i ++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new insertionSort()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

}
