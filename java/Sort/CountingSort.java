package Sort;

import java.util.Arrays;

public class CountingSort {

    private static int MAX_VALUE;

    public static void main(String[] args) {

        int[] arr = {1, 5, 4, 7, 1, 2};

        int n = arr.length;

        MAX_VALUE = Arrays.stream(arr).max().getAsInt();

        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1;
        }

        for (int i = 0; i < MAX_VALUE; i++) {
            for (int a = 0; a < cnt[i]; a++) {
                System.out.print(i + " ");
            }
        }
    }
}
