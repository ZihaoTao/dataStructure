package SearchTree;

import LinearSort.SortTestHelper;
import Heap.heapSort;

/**
 * Created by tino on 1/15/19.
 */
// O(logn)
public class binarySearch {
    public int binarySearch(int arr[], int n, int target) {
        // search in [l, r]
        int l = 0, r = n - 1;
        while(l <= r) {
            //int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) {
                return mid;
                // search in [l, mid - 1]
            } else if(target < arr[mid]) {
                r = mid - 1;
                // search in [mid + 1, r]
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchR(int[] arr, int n, int target) {
        return __binarySearchR(arr, 0, n - 1, target);
    }

    private int __binarySearchR(int[] arr, int l, int r, int target) {
        if(l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] > target) {
            return __binarySearchR(arr, l, mid - 1, target);
        } else {
            return  __binarySearchR(arr, mid + 1, r, target);
        }
    }


    public static void main(String[] args) {
        int n = 1000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new heapSort()).heapSort(arr, n);
        int index = (new binarySearch()).binarySearch(arr, n, 500);
        int index2 = (new binarySearch()).binarySearchR(arr, n, 500);
        System.out.println(index);
        System.out.println(index2);
        if(index >= 0) {
            System.out.println(arr[index]);
        }
    }
}
