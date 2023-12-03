package Chuwa;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        this.mergeSortHelper(arr, 0, arr.length - 1);
    }

    public void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, left + 1, right);
        this.merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[index++] = arr[l++];
            } else {
                temp[index++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = arr[l++];
        }

        while (r <= right) {
            temp[index++] = arr[r++];
        }

        System.arraycopy(temp, 0, arr, left + 0, temp.length);
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] testCase1 = {51, 46, 20, 18, 65, 98, 102, -4, 3, 2, 56, 46};

        solution.mergeSort(testCase1);
        System.out.println(Arrays.toString(testCase1));
        solution.mergeSort(null);
    }
}
