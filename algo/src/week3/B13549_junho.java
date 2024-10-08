package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B13549_junho {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int subin = Integer.parseInt(input[0]);
        int brother = Integer.parseInt(input[1]);

        bfs(subin, brother);
    }

    static void bfs(int subin, int brother) {
        int max = 100000;
        int[] dist = new int[max + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(subin);

        for (int i = 0; i <= max; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[subin] = 0;

        int[] dx = {-1, 1};

        while (!deque.isEmpty()) {
            int currentX = deque.poll();

            if (currentX == brother) {
                System.out.println(dist[currentX]);
                return;
            }


            // 순간이동 (가중치 0)
            int teleport = currentX * 2;
            if (teleport <= max && dist[teleport] > dist[currentX]) {
                dist[teleport] = dist[currentX]; // 가중치 0
                deque.addFirst(teleport);
            }
            // 걷기 이동 (가중치 1)
            for (int i = 0; i < dx.length; i++) {
                int next = currentX + dx[i];

                if (next >= 0 && next <= max && dist[next] > dist[currentX] + 1) {
                    dist[next] = dist[currentX] + 1; // 가중치 1
                    deque.addLast(next);
                }
            }
        }
    }
}
