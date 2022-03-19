package DynamicProgramming;

import java.util.Scanner;

/*
in
8
1 3 4 5 8 8 1 3

expected d[]
1 3 5 8 13 16 16 19

out
8
 */

/**
 * d[2] 는 max(d[1], d[0] + food[2])
 * d[3] 은 max(d[2], d[1] + food[3])
 * d[4] 는 max(d[3], d[2] + food[4])
 *
 */
public class AntWarrior {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] food = new int[n];
        for (int i = 0; i < n; i++) {
             food[i] = sc.nextInt();
        }

        int[] d = new int[n];

        d[0] = food[0];
        d[1] = Math.max(food[0], food[1]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i-1], d[i-2] + food[i]);
        }

        System.out.println(d[n - 1]);


    }

}
