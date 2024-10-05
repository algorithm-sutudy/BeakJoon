package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20125_junho {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] grid = new char[N][N];

        // 판의 상태 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        int heartX=0;
        int heartY=0;

        outerLoop:
        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*' && grid[i+1][j] == '*'){
                    heartX = i + 1;
                    heartY = j;
                    break outerLoop;
                }

            }

        }

        int leftArm = calculateLength(grid, heartX, heartY, 0, -1, N); // 왼쪽
        int rightArm = calculateLength(grid, heartX, heartY, 0, 1, N); // 오른쪽
        int waist = calculateLength(grid, heartX, heartY, 1, 0, N); // 허리
        int leftLeg = calculateLength(grid, heartX + waist, heartY - 1, 1, 0, N); // 왼쪽 다리
        int rightLeg = calculateLength(grid, heartX + waist, heartY + 1, 1, 0, N); // 오른쪽 다리

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

    }
    private static int calculateLength(char[][] grid, int startX, int startY, int dirX, int dirY, int N) {
        int length = 0;
        int x = startX + dirX;
        int y = startY + dirY;

        while (x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == '*') {
            length++;
            x += dirX;
            y += dirY;
        }
        return length;
    }
}