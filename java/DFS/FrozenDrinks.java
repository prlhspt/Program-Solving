package DFS;

import java.util.*;

public class FrozenDrinks {

    static int[][] graph = new int[1000][1000];

    static int N, M;

/**
input

4 5
00110
00011
11111
00000
*/

    static boolean dfs(int x, int y) {

        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        int answer = 0;

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    answer += 1;
                }
            }
        }

        System.out.println("answer = " + answer);

    }
}
