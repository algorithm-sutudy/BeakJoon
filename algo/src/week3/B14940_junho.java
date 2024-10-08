package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B14940_junho {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int y = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[][] miro = new int[y][x];

//        System.out.println(Arrays.deepToString(miro));

        int startY = 0;
        int startX = 0;

        for (int i = 0; i < y; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                int temp = Integer.parseInt(line[j]);
                if (temp==2) {
                    startY = i;
                    startX = j;
                    miro[i][j] = 0; // 시작 지점의 거리를 "0"으로 설정
                } else if (temp==1) {
                    miro[i][j] = -1; // 방문하지 않은 이동 가능한 위치를 "-1"로 초기화
                } else if (temp==0) {
                    miro[i][j] = 0;
                }
            }
        }

        bfs(miro, startY, startX, y, x);

        for (int i = 0; i < y; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x; j++) {
                sb.append(miro[i][j]);
                if (j < x - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static void bfs(int[][] miro, int startY, int startX, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!queue.isEmpty()){
            int[] currentPosition = queue.poll();
            int currentY = currentPosition[0];
            int currentX = currentPosition[1];

            for (int i = 0; i < 4; i++) {
                int ddy = currentY + dy[i];
                int ddx = currentX + dx[i];

                if (ddy >=0 && ddx>=0 && ddy<y && ddx<x){
                    if (miro[ddy][ddx] == -1){
                        queue.add(new int[]{ddy,ddx});
                        miro[ddy][ddx] = miro[currentY][currentX] +1;
                    }
                }
            }
        }

    }
}
