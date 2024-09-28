import java.util.*;

// 가로, 세로로만 움직일 수 있음

public class Main {
    static int n, m; // 세로, 가로의 크기 (2 <= n, m <= 1000)
    static int[][] map;
    static int[][] result; // 최종 결과(최단 거리) 저장할 배열
    static int startX = 0, startY = 0; // 목표 지점의 좌표 (2가 있는 위치)

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();

        map = new int[n][m];
        result = new int[n][m];

        initMap(n, m, s);
        bfs(startX, startY);
        printResult();

        s.close();
    }

    // map 배열에 값 저장하고 목표 지점 좌표 저장하는 함수
    static void initMap(int n, int m, Scanner s) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();

                switch (map[i][j]) {
                    case 0: // 갈 수 없는 땅인 경우
                        result[i][j] = 0;
                        break;
                    case 1: // 갈 수 있는 땅인 경우(일단 도달할 수 없다는 의미의 -1로 초기화)
                        result[i][j] = -1;
                        break;
                    case 2: // 목표지점인 경우
                        startX = i;
                        startY = j;
                        result[i][j] = 0;
                        break;
                }
            }
        }
    }

    // BFS로 목표 지점(2)에서 각 지점까지의 최단 거리를 구하는 함수
    static void bfs(int startX, int startY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY}); // startX, startY를 큐에 넣음 (목표 좌표에서 시작하므로)

        while (!queue.isEmpty()) { // 탐색 지점이 없을 때까지(큐가 빌 때까지) 반복
            int[] current = queue.poll(); // 큐의 맨 앞 값(현재 좌표)
            int currentX = current[0];
            int currentY = current[1];

            // 상하좌우 네 방향으로 모두 이동해보면서 탐색
            for (int i = 0; i < 4; i++) {
                // 이동할 새로운 좌표의 x, y값 계산 (dx, dy를 사용하면 상하좌우의 좌표가 다 나오므로)
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                // 새로운 좌표가 이차원 배열의 범위 안에 있고, 아직 방문하지 않은(-1) 갈 수 있는(1) 땅인 경우
                if ((newX >= 0 && newX < n) && (newY >= 0 && newY < m) && map[newX][newY] == 1 && result[newX][newY] == -1) {
                    result[newX][newY] = result[currentX][currentY] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    // 결과 배열 출력하는 함수
    static void printResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
