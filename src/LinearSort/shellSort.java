package LinearSort;

import java.util.Arrays;

/**
 * Created by tino on 1/9/19.
 */
public class shellSort {
    public void sort(int arr[], int n){

        int h = 1;
        while( h < n/3 )
            h = 3 * h + 1;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...

        while( h >= 1 ){

            // h-sort the array
            for( int i = h ; i < n ; i ++ ){

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int e = arr[i];
                int j;
                for( j = i ; j >= h && e < arr[j-h] ; j -= h )
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new shellSort()).sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

}
