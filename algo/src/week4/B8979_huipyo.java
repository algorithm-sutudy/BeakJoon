import java.util.Arrays;
import java.util.Scanner;

public class B8979_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[][] arrays = new int[n][5];

        for (int i = 0; i < arrays.length; i++) {
            int[] array = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 0};
            arrays[i] = array;
        }
        Arrays.sort(arrays, (o1, o2) -> o1[1] == o2[1] ? o1[2] == o2[2] ? o2[3] - o1[3] : o2[2] - o1[2] : o2[1] - o1[1]);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i][4] = i > 0 && arrays[i][1] == arrays[i - 1][1] && arrays[i][2] == arrays[i - 1][2] && arrays[i][3] == arrays[i - 1][3] ? arrays[i - 1][4] : i + 1;

            if (arrays[i][0] == k) {
                System.out.println(arrays[i][4]);
                break;
            }
        }
        scanner.close();
    }
}
