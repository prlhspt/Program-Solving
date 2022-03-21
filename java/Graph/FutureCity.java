package Graph;

import java.util.Arrays;
import java.util.Scanner;

/*
input

5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
*/

/**
 * 1번 회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 최소 시간
 */

public class FutureCity {

    static final int INF = (int) 1e9;

    static int graph[][];


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n + 1][n + 1];

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(distance);
        }
    }
}
