package week2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(scanner.nextInt());
                }
            }
        };
        int m = scanner.nextInt();

        while (true) {
            list.sort(Comparator.reverseOrder());
            if (list.stream().mapToInt(Integer::intValue).sum() < m) break;
            list.set(0, list.get(0) - 1);
        }
        System.out.println(list.get(0));
        scanner.close();
    }
}
