package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */

// very late when used in a ordered data, need to randomize first
// very late when the value range is small.

public class quickSort {
    public void sort(int[] arr, int n) {
        __quickSort(arr, 0, n - 1);
    }

    private void __quickSort(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        }
        int p = __partition2(arr, l, r);

        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);
    }

    private int __partition(int[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1) + l)); // randomization

        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] <= v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);

        return j;
    }

    private int __partition2(int[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1) + l)); // randomization

        int v = arr[l];

       // arr[l, i) <= v, arr(j, r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l && arr[j] > v) j--;

            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);

        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
        (new quickSort()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
