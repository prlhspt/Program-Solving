package Implement;

import java.util.*;

/**
5
R R R U D D
 */

public class UpDownLeftRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] directions = {'L', 'R', 'U', 'D'};

        int x = 1, y = 1;

        for (String plan : plans) {
            int nx = -1, ny = -1;
            for (int i = 0; i < 4; i++) {
                if (plan.charAt(0) == directions[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }

            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;

            x = nx;
            y = ny;

        }

        System.out.println(x + " " + y);

    }

}
