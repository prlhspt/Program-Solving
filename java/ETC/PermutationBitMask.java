package ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationBitMask {

    static int[] temp;
    static boolean[] visited;

    static List<int[]> resultList = new ArrayList<>();

    public static void permutation(int[] arr, int r, int idx, int flag) {
        if (idx == r) {
            resultList.add(Arrays.copyOf(temp, temp.length));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if ((flag & 1 << i) != 0) continue;

            temp[idx] = arr[i];
            permutation(arr, r, idx+1, flag | 1<<i);

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9};

        visited = new boolean[arr.length];
        temp = new int[arr.length];

        permutation(arr, arr.length, 0, 0);

        for (int[] ints : resultList) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
    }
}
