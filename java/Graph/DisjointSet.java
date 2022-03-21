package Graph;

import java.util.Scanner;

public class DisjointSet {

    // 노드의 개수 v와 간선의 개수 e
    static int v, e;

    // 간선의 개수는 최대 100,000개라고 가정
    static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

/*
INPUT
6 4
1 4
2 3
2 4
5 6

 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.println("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
