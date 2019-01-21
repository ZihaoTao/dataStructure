package Heap;

import LinearSort.SortTestHelper;

import java.util.Arrays;

/**
 * Created by tino on 1/15/19.
 */
public class selectMLargestElementsInNElements {
    public int[] selectMLargestElementsInNElements(int[] arr, int m) {
        assert(m <= arr.length);
        int[] res = new int[m];
        int index = 0;
        while(index < m) {
            res[index] = arr[index];
            index ++;
        }

        heapSort(res, m);
        while(index < arr.length) {
            if (arr[index] > res[m - 1]) {
                res[m - 1] = arr[index];
            }
            heapSort(res, m);
            index++;
        }
        return res;
    }

    public void heapSort(int[] arr, int n) {
        for(int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for(int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i,  0);
        }
    }

    private void shiftDown(int[] arr, int n, int k) {
        while(2 * k + 1 < n) {
            int j = 2 * k + 1;
            if(j + 1 < n && arr[j] > arr[j + 1]) {
                j++;
            }
            if(arr[k] <= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        int[] res = (new selectMLargestElementsInNElements()).selectMLargestElementsInNElements(arr, 50);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}
