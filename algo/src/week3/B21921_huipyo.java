import java.util.*;

public class B21921_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), x = scanner.nextInt();
        int[] array = new int[n];
        int[] resultArray = new int[n - x + 1];

        Arrays.setAll(array, i -> (i > 0 ? array[i - 1] : 0) + scanner.nextInt());
        Arrays.setAll(resultArray, i -> array[i + x - 1] - (i > 0 ? array[i - 1] : 0));
        Arrays.sort(resultArray);
        if (resultArray[resultArray.length - 1] != 0) {
            int max = resultArray[resultArray.length - 1];
            int count = 0;

            for (int i = resultArray.length - 1; i >= 0; i--) {
                if (resultArray[i] == max) count++;
                else break;
            }
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
        scanner.close();
    }
}
