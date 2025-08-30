package sorting;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr =  {9,6, 3, 5,1, -1, 3, 2, 91, 56, -56, 21, -101};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(n ->{
            System.out.print(" "+n);
        });
    }

    private static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pi = pivotIndex(arr, left, right);

            quickSort(arr, left, pi-1);
            quickSort(arr, pi+1, right);
        }
    }

    private static int pivotIndex(int[] arr, int left, int right) {
        int pivot = arr[right];

        int i = left;
        for(int j=left; j<right; j++){
            if(arr[j] < pivot){
                swap(arr, i++, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
