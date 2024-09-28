package week2;

import java.util.*;

public class Main {
    static int[] mStart;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arrays = initArrays(scanner);
        Queue<int[]> queue = new ArrayDeque<>(List.of(mStart));
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            if (arrays[outed[0]][outed[1]] < 0) continue;
            for (int[] next : new int[][] {
                    {outed[0] - 1, outed[1]},
                    {outed[0], outed[1] + 1},
                    {outed[0] + 1, outed[1]},
                    {outed[0], outed[1] - 1}
            }) {
                if (next[0] > -1 && next[0] < arrays.length && next[1] > -1 && next[1] < arrays[0].length && arrays[next[0]][next[1]] == -1) {
                    int nextLevel = outed[2] + 1;
                    arrays[next[0]][next[1]] = nextLevel;

                    queue.offer(new int[] {next[0], next[1], nextLevel});
                }
            }
        }
        for (int[] array : arrays) {
            StringBuilder rowBuilder = new StringBuilder();

            for (int i : array) {
                rowBuilder.append(i).append(" ");
            }
            stringBuilder.append(rowBuilder.toString().trim()).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
        scanner.close();
    }

    private static int[][] initArrays(Scanner scanner) {
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] arrays = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (scanner.nextInt()) {
                    case 0:
                        arrays[i][j] = 0;
                        break;
                    case 1:
                        arrays[i][j] = -1;
                        break;
                    case 2:
                        arrays[i][j] = 0;
                        mStart = new int[] {i, j, 0};
                        break;
                }
            }
        }
        return arrays;
    }
}
