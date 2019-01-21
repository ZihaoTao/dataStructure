package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */

// O(n^2)

public class selectionSort{

    public void sort(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < (arr[minIndex])) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new selectionSort()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}