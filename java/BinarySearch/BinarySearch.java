package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] S, int k, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int e = S[mid];

        if (k == e) {
            return mid;
        } else if (k < e) {
            return binarySearch(S, k, low, mid - 1);
        } else {
            return binarySearch(S, k, mid + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 8, 10, 2};
        Arrays.sort(arr);

        int target = 3;

        int index = binarySearch(arr, target, 0, arr.length - 1);

        if (index == -1) {
            System.out.println("원소 x");
        } else {
            System.out.println("index = " + index);
        }


    }

}
