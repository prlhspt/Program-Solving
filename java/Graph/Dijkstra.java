package Graph;

import java.util.*;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;

    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    static List<List<Node>> graph = new ArrayList<>();

    // 노드의 개수는 최대 100,000개라고 가정
    // 최단 거리 테이블 만들기
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

        // 거리가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                // 값을 안바꾸고 싶으면 -1, 자바는 기본이 오름차순임 1과 2생각
                return -1;
            }
            return 1;
        }
    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로 0으로 설정, 큐에 삽입
        pq.offer(new Node(start, 0));

        // 시작 노드에 대해서 초기화
        d[start] = 0;

        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }

            }
        }
    }

/*
input

6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
*/
    /**
     * n = 노드이 개수
     * m = 간선의 개수
     * a, b, c = a에서 b로 갈때 c의 가중치가 있다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }

    }

}
