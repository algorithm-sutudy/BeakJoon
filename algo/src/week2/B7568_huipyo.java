package week2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arrays = new int[n][4];
        String[] result = new String[n];

        Arrays.setAll(arrays, i -> new int[] {i, scanner.nextInt(), scanner.nextInt(), 0});
        Arrays.sort(arrays, (o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[2] - o1[2]);

        // 등수 나열하기
        for (int i = 0; i < arrays.length; i++) {
            int count = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arrays[i][1] < arrays[j][1] && arrays[i][2] < arrays[j][2]) {
                    count++;
                }
            }
            arrays[i][3] = count + 1;
        }
        Arrays.sort(arrays, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < arrays.length; i++) {
            result[i] = String.valueOf(arrays[i][3]);
        }
        System.out.println(String.join(" ", result));
        scanner.close();
    }
}
