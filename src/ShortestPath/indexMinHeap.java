package ShortestPath;

/**
 * Created by tino on 1/20/19.
 */
public class indexMinHeap<Item extends Comparable> {
    int[] indexes;
    int[] reverse;
    Item[] data;
    int capacity;
    int count;
    public indexMinHeap(int capacity) {
        this.capacity = capacity;
        count = 0;
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for(int i = 0; i < capacity + 1; i++) {
            reverse[i] = 0;
        }
        data = (Item[])new Comparable[capacity+1];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, Item item) {
        assert(count + 1 < capacity);
        assert(i + 1 >= 1 && i + 1 <= capacity);
        i++;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) > 0) {
            swap(indexes, k/2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public Item extractMin() {
        assert(count > 0);
        Item res = data[indexes[1]];
        swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0; // delete
        count--;
        shiftDown(1);
        return res;
    }

    public int extractMinIndex() {
        assert(count > 0);
        int res = indexes[1] - 1;
        swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0; // delete
        count--;
        shiftDown(1);
        return res;
    }

    public Item getItem(int i) {
        assert(contain(i));
        return data[i + 1];
    }

    public void change(int i, Item newItem) {
        assert(contain(i));
        i += 1;
        data[i] = newItem;
        int j = reverse[i];
        shiftDown(j);
        shiftUp(j);
    }

    public boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }

    private void shiftDown(int k) {
        while(2 * k < count) {
            int j = 2 * k;
            if(j + 1 <= count  && data[indexes[j + 1]].compareTo(data[indexes[j]]) < 0) {
                j++;
            }

            if(data[indexes[k]].compareTo(data[indexes[j]]) < 0) {
                break;
            }
            swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }
}
