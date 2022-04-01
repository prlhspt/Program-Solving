package ETC;

public class Combination2Dimensional {

    static int n = 3;
    static int m = 3;

    static void combination(int[][] map, int start, int depth) {
        if (depth == 3) {
            print(map);
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                combination(map, i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] map = new int[n][m];

        print(map);
        combination(map, 0, 0);
    }
}