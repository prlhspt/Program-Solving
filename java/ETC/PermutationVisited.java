package ETC;

import java.util.Scanner;

public class PermutationVisited {

    // 인덱스 순서는 지키면서 n개중에 r개 뽑기됨 - 사전순으로 출력 됨
    static void permutation(int[] arr, int[] output,
                     boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];

                permutation(arr, output, visited, depth + 1, n, r);

                output[depth] = 0;
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 7};

        int n = arr.length;

        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        permutation(arr, output, visited, 0, n, 1);
    }
}
