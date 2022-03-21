package Graph;

import java.util.*;

/**
 * C에서 출발해서 최대한 많이 퍼져나감
 *
 * C의 메시지를 받게 된 도시의 개수,
 * 메시지를 다 받는데 걸리는 시간
 *
 */


public class Telegram {

    static int INF = (int) 1e9;

    static int n, m, start;

    static List<List<Node>> graph = new ArrayList<>();

    static int[] d = new int[100001];

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

/*
4 4 1
1 2 4
1 3 2
1 4 12
3 4 7
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시의 개수
        n = sc.nextInt();
        // 통로의 개수
        m = sc.nextInt();
        // 메시지를 보내고자 하는 도시
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 통로의 정보
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int sum = 0;
        int totalTime = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                sum++;
                totalTime = Math.max(totalTime, d[i]);
            }
        }

        sum--;

        System.out.print(sum + " ");
        System.out.print(totalTime);


    }
}
