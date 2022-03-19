package BinarySearch;

import java.util.Scanner;

/*
7 7
1 1 7 7 7 7 10
 */
public class SpeciesNumber {

    static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        int e = arr[mid];

        if (target == e) {
            int result = 1;
            int index = mid;
            while (arr[index] == arr[index - 1]) {
                result++;
                index--;
            }

            index = mid;
            while (arr[index] == arr[index + 1]) {
                result++;
                index++;
            }
            return result;

        } else if (target < e) {
            binarySearch(arr, 0, mid - 1, target);
        } else {
            binarySearch(arr, mid + 1, end, target);
        }

        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, 0, arr.length - 1, x);

        System.out.println("result = " + result);

    }
}
