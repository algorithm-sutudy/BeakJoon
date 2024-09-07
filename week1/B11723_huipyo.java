import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> s = new HashSet<>();
        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String operator = scanner.next();

            switch (operator) {
                case "add":
                    s.add(scanner.nextInt());
                    break;
                case "remove":
                    s.remove(scanner.nextInt());
                    break;
                case "check":
                    stringBuilder.append(s.contains(scanner.nextInt()) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int n = scanner.nextInt();

                    if (s.contains(n)) s.remove(n);
                    else s.add(n);
                    break;
                case "all":
                    s = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 ,20));
                    break;
                case "empty":
                    s = new HashSet<>();
                    break;
            }
        }
        System.out.println(stringBuilder);
        scanner.close();
    }
}
