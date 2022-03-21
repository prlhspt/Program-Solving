package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */

/**
 * a <= 0 이면 가운데랑 아래꺼만 더하기
 * a >= mine.length - 1 이면 가운데랑 위에꺼만 더하기
 *
 * mine[0][1] = mine[0][0] + mine[1][0]
 * mine[1][1] = mine[0][0] + mine[1][0] + mine [2][0]
 * mine[2][1] = mine[1][0] + mine[2][0] + mine [3][0]
 * mine[3][1] = mine[2][0] + mine[3][0]
 */

public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] mine = new int[20][20];
            int[][] d = new int[20][20];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    mine[a][b] = sc.nextInt();
                    d[a][b] = mine[a][b];
                }
            }

            for (int b = 1; b < m; b++) {
                for (int a = 0; a < n; a++) {
                    int leftUp, leftDown, left;

                    if (a == 0) leftUp = 0;
                    else leftUp = d[a - 1][b - 1];

                    if (a == n - 1) leftDown = 0;
                    else leftDown = d[a + 1][b - 1];

                    left = d[a][b - 1];
                    d[a][b] = d[a][b] + IntStream.of(leftUp, leftDown, left).max().getAsInt();
                }

            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, d[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
