package DynamicProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 전투력이 높은 병사가 앞쪽에 오도록 내림차순으로 배치 진행
 * 병사를 열외시키는 방법만 있음
 *
 * 15 11 4 8 5 2 4
 * 15 11 8 5 4
 *
 * 4 2 5 8 4 11 15
 *
 * dp
 * 1 1 1 1 1 1 1
 * 1 1 2 3 2 4 5
 *
 * for (int a = 0; a < n; a++) {
 *     for (int b = 0; b < a; b++) {
 *         if (revS[b] < revS[a]) dp[a] = Math.max(dp[a], dp[b] + 1);
 *     }
 * }
 */
public class PlacingSoldiers {
    public static void main(String[] args) {
        int n = 7;

        int[] soldiers = {15, 11, 4, 8, 5, 2, 4};
        int[] revS = IntStream.range(0, soldiers.length)
                .map(i -> soldiers[soldiers.length - i - 1])
                .toArray();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < a; b++) {
                if (revS[b] < revS[a]) dp[a] = Math.max(dp[a], dp[b] + 1);
            }
        }

        int maxValue = Arrays.stream(dp).max().getAsInt();

        System.out.println(n - maxValue);

    }
}
