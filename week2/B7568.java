import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        String[] result = new String[n];

        Arrays.setAll(array, i -> new int[] {i, scanner.nextInt(), scanner.nextInt(), 0});
        Arrays.sort(array, (o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[2] - o1[2]);
        for (int i = 0; i < array.length; i++) {
            array[i][3] = i + 1;
            if (i == 0) continue;
            if (array[i - 1][2] <= array[i][2]) array[i][3] = array[i - 1][3];
        }
        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < array.length; i++) {
            result[i] = String.valueOf(array[i][3]);
        }
        System.out.println(String.join(" ", result));
        scanner.close();
    }
}
