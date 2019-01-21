package Kruskal;

/**
 * Created by tino on 1/19/19.
 */
public class MinHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    public MinHeap(int capacity) {
        data = (Item[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public MinHeap(Item arr[]){
        int n = arr.length;
        data = (Item[])new Comparable[n + 1];
        capacity = n;

        for( int i = 0 ; i < n ; i ++ ){
            data[i+1] = arr[i];
        }
        count = n;

        for( int i = count/2 ; i >= 1 ; i -- )
            shiftDown(i);
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private void shiftDown(int k) {
        while(k * 2 <= count ) {
            int j = 2 * k;
            if(j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                j++;
            }

            if(data[k].compareTo(data[j]) <= 0) {
                break;
            }
            else {
                swap(data, j, k);
                k = j;
            }
        }
    }

    public void insert(Item item) {
        assert(count + 1 < capacity);
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }

    private void shiftUp(int k) {

        while(k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(data, k, k / 2);
            k /= 2;
        }
    }

    private void swap(Item[] data, int a, int b) {
        Item temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public Item extractMin() {
        assert(count > 0);
        Item res = data[1];
        swap(data, 1, count);
        count--;
        shiftDown(1);
        return res;
    }

}
