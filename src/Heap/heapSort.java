package Heap;

import LinearSort.SortTestHelper;

import java.util.Arrays;

/**
 * Created by tino on 1/14/19.
 */
public class heapSort {
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
            if(j + 1 < n && arr[j] < arr[j + 1]) {
                j++;
            }
            if(arr[k] >= arr[j]) {
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
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new heapSort()).heapSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
