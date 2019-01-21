package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */
public class mergeSort {
    public void sort(int[] arr, int n) {
        __sort(arr, 0, n-1);

    }

    // sort [l,r] of data
    private void __sort(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        __sort(arr, l, mid);
        __sort(arr, mid + 1, r);
        if(arr[mid] >= arr[mid+1]) {
            __merge(arr, l, mid, r);
        }
    }

    public void sortBU(int[] arr, int n) {
        for(int sz = 1; sz <= n; sz += sz) {
            for(int i = 0; i + sz < n; i += sz * 2) {
                __merge(arr, i, i + sz - 1, Math.min(i + sz + sz -1, n - 1));
            }
        }
    }

    // merge [l,mid] and [mid + 1, r] of data
    private void __merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for(int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            if(i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if(j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if(aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new mergeSort()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
