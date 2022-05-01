package Graph;

import java.util.*;

/**
 * 그래프는 사이클이 없는 방향그래프(DAG)여야 한다.
 */
public class TopologySort {

    // vertex(정점), edge(간선)
    static int v, e;
    static int[] inDegree = new int[100001];
    static List<List<Integer>> graph = new ArrayList<>();

    static List<Integer> result = new ArrayList<>();

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                inDegree[graph.get(now).get(i)] -= 1;
                if (inDegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }

    /*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            inDegree[b] += 1;
        }

        topologySort();

        for (Integer integer : result) {
            System.out.println(integer + " ");
        }

    }
}
