package DynamicProgramming;

import java.util.Arrays;

/**
 * 2원, 3원 단위의 화폐가 있을 때 15원을 만들기 위해서는 3원 5개
 * 3원, 5원, 7원 단위의 화폐가 있을 때 4원은 못 만듬
 * 3원, 4원, 5원 단위의 화폐가 있을 때 18원을 만들기 위해서는 4원 3개, 3원 2개
 *
 * d[3] = 1, d[6] = 2, d[9] = 3, d[12] = 4, d[15] = 5, d[18] = 6
 *
 * d[4] = 1, d[8] = 2, d[12] = 3, d[16] = 4
 * d[7] = d[3]+1=2, d[10] = d[6]+1=3, d[13] = d[9]+1=4, d[6] =
 */
public class EfficientMoneyStructure {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] monies = new int[n];
//        for (int i = 0; i < n; i++) {
//            monies[i] = sc.nextInt();

        int n = 3, m = 18;
        int[] monies = {3, 4, 5};

        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int a = 0; a < n; a++) {
            for (int b = monies[a]; b <= m; b++) {
                if (d[b - monies[a]] != 10001) {
                    d[b] = Math.min(d[b], d[b - monies[a]] + 1);
                }
            }
        }

        if (d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }
    }

}
