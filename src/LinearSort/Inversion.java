package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/10/19.
 */
public class Inversion {
    public int inversion(int[] arr, int n) {
        return __sort(arr, 0, n-1);

    }

    // sort [l,r] of data
    private int __sort(int[] arr, int l, int r) {
        if(l >= r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int count = __sort(arr, l, mid) + __sort(arr, mid + 1, r);

        if(arr[mid] >= arr[mid+1]) {
            count += __merge(arr, l, mid, r);
        }
        return count;
    }

    public void sortBU(int[] arr, int n) {
        for(int sz = 1; sz <= n; sz += sz) {
            for(int i = 0; i + sz < n; i += sz * 2) {
                __merge(arr, i, i + sz - 1, Math.min(i + sz + sz -1, n - 1));
            }
        }
    }

    // merge [l,mid] and [mid + 1, r] of data
    private int __merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for(int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        int count = 0;

        for (int k = l; k <= r; k++) {
            if(i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if(j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if(aux[i - l] <= aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
                count += (mid - i) + 1;
            }
        }

        return count;
    }

    public static int getInvCount(int n, int[] arr) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    inv_count++;

        return inv_count;
    }


    public static void main(String[] args) {
        int n = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);

//        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        System.out.println(getInvCount(n, arr));
        int a = (new Inversion()).inversion(arr, n);
        System.out.println(Arrays.toString(arr));
        System.out.println(a);
    }
}
