package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */
public class quickSort3ways {

    public void sort(int[] arr, int n) {
        __quickSort(arr, 0, n - 1);
    }

    private void __quickSort(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        }
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));

        // partition
        int v = arr[l];
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if(arr[i] < v) {
                swap(arr, lt + 1, i);
                lt ++;
                i ++;
            } else if(arr[i] > v) {
                swap(arr, gt - 1, i);
                gt --;
            } else {
                i++;
            }
        }
        swap(arr, lt, l);
        lt --;
        __quickSort(arr, l, lt);
        __quickSort(arr, gt, r);
    }


    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new quickSort3ways()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
