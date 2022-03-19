package DynamicProgramming;

import java.util.Scanner;

/**
 * 2, 4, 6, 8, 10 에 1, 2, 3, 4, 5 대입
 * 3, 6, 9, 12 에 1, 2, 3, 4 대입
 * 5, 7, 9, 11 에 2, 3, 4, 5 대입
 */

public class MakeOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
        int x = 26;
        int[] d = new int[x + 1];

        d[1] = 0;
        d[2] = 1;

        for (int i = 3; i < x + 1; i++) {

            d[i] = d[i - 1] + 1;

            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }

            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }

            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }

        }

        System.out.println("d[x] = " + d[x]);

    }
}
