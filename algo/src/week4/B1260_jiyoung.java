package week4;

import java.util.*;

public class B1260_jiyoung {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 정점의 개수 N(1 ≤ N ≤ 1,000)
        int m = s.nextInt(); // 간선의 개수 M(1 ≤ M ≤ 10,000)
        int v = s.nextInt(); // 탐색을 시작할 정점의 번호 V

        // 정점 갯수만큼 ArrayList 세팅하기
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력된 간선 분석해서 정점에다가 연결 정보 추가하기
        for (int i = 0; i < m; i++) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();

            // 양방향 연결이므로 양쪽에 다 정보 추가해주기
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        // 정점 오름차순으로 정렬하기
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);

        s.close();
    }

    public static void dfs(int start) {
        // 현재 정점 방문 처리 & 출력
        visited[start] = true;
        System.out.print(start + " ");

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 현재 정점 큐에 넣기
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) { // 큐가 완전히 빌 때까지 반복 실행됨
            int node = queue.poll();
            System.out.print(node + " ");

            // 큐에서 꺼낸 정점과 가까운 정점들을 확인
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
