package ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationVisited {

    // 인덱스 순서는 지키면서 n개중에 r개 뽑기됨 - 사전순으로 출력 됨
    static int[] temp;
    static boolean[] visited;

    static List<int[]> resultList = new ArrayList<>();

    public static void permutation(int[] arr, int r, int idx) {
        if (idx == r) {
            resultList.add(Arrays.copyOf(temp, temp.length));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            temp[idx] = arr[i];
            visited[i] = true;
            permutation(arr, r, idx+1);
            visited[i] = false;

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9};

        visited = new boolean[arr.length];
        temp = new int[arr.length];

        permutation(arr, arr.length, 0);

        for (int[] ints : resultList) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
    }
}
