package Heap;

import LinearSort.SortTestHelper;

/**
 * Created by tino on 1/11/19.
 */
public class MaxHeap {
    private int[] arr;
    private int count;
    private int capacity;

    // O(nlogn)
    public MaxHeap(int capacity){
        this.capacity = capacity;
        arr = new int[capacity + 1];
        count = 0;
    }

    // O(n)   heapify
    public MaxHeap(int[] array) {
        this.capacity = array.length;
        arr = new int[this.capacity + 1];
        for(int i = 0; i < this.capacity; i++) {
            arr[i + 1] = array[i];
        }
        count = this.capacity;

        for(int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // shift up
    public void insert(int item) {
        assert(count + 1 <= capacity);
        arr[count + 1] = item;
        count++;
        shiftUp(count);

    }

    private void shiftUp(int k) {
        while (k > 1 && arr[k / 2] < arr[k]) {
            swap(arr, k/2, k);
            k /= 2;
        }
    }

    // shiftDown
    public int extractMax() {
        assert(count > 0);
        int ret = arr[1];
        swap(arr, 1, count);
        count --;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while(k * 2 <= count ) {
            int j = 2 * k;
            if(j + 1 <= count && arr[j + 1] > arr[j]) {
                j++;
            }

            if(arr[k] >= arr[j]) {
                break;
            }
            else {
                swap(arr, j, k);
                k = j;
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] get() {
        return arr;
    }

    public static void main(String[] args) {

        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        MaxHeap maxHeap = new MaxHeap(arr);

        while(maxHeap.size() > 0) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
