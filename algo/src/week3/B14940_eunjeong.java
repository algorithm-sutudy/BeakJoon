package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940_eunjeong {
    static int N;
    static int M;
    static int[][] map;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int goalRow = 0;
        int goalCol = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    goalRow = i;
                    goalCol = j;
                }
            }
        }

        // 목표 지점에서 모든 좌표까지의 최단 거리를 계산
        result = new int[N][M];
        bfs(goalRow, goalCol);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 갈 수 없는 곳은 -1로 표시
                if (map[i][j] == 1 && result[i][j] == 0 && (i != goalRow || j != goalCol)) {
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int sRow, int sCol) {
        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Point(sRow, sCol, 0));
        visited[sRow][sCol] = true;
        result[sRow][sCol] = 0;

        while (!queue.isEmpty()) {
            Point curr = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = curr.row + r[i];
                int nCol = curr.col + c[i];

                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                if (visited[nRow][nCol]) continue;
                if (map[nRow][nCol] == 0) continue;

                visited[nRow][nCol] = true;
                result[nRow][nCol] = curr.dist + 1;
                queue.add(new Point(nRow, nCol, curr.dist + 1));
            }
        }
    }

    static class Point {
        int row, col, dist;

        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }
}
