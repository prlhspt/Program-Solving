package BinarySearch;

import java.util.Scanner;

/*
4 6
19 15 10 17
 */
public class MakeRiceCake {

    static int N;
    static int M;

    static long result = 0;

    static void binarySearch(int[] arr, int start, int end) {
        if (start > end) return;

        long total = 0;
        int mid = (start + end) / 2;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                total += arr[i] - mid;
            }
        }
        if (total < M) {
            binarySearch(arr, start, mid - 1);
        } else {
            result = mid;
            binarySearch(arr, mid+1, end);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        binarySearch(height, 0, Integer.MAX_VALUE);

        System.out.println("result = " + result);

    }
}
