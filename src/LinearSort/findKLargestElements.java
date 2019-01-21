package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/10/19.
 */
public class findKLargestElements {
    public int quickSort(int[] arr, int n, int k) {
        return __sort(arr, 0, n - 1, n - k);
    }

    private int __sort(int[] arr, int l, int r, int k) {
        if(l > r) {
            return 0;
        }
        int p = __partition(arr, l, r);
        if(p == k) {
            return arr[k];
        }
        return __sort(arr, l, p - 1, k) + __sort(arr, p + 1, r, k);

    }

    private int __partition(int[] arr, int l, int r) {

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
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        System.out.println(Arrays.toString(arr));
        int a = (new findKLargestElements()).quickSort(arr, n, 6);
        System.out.println(Arrays.toString(arr));
        System.out.println(a);
    }


}
