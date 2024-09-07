import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            LinkedList<Integer> stack = new LinkedList<>();
            Set<List<Integer>> listSet = new HashSet<>();
            Consumer<Integer> consumer = new Consumer<>() {
                @Override
                public void accept(Integer integer) {
                    for (int i = integer; i <= 3; i++) {
                        stack.push(i);
                        if (stack.stream().mapToInt(Integer::intValue).sum() == n) listSet.add(stack.stream().sorted().collect(Collectors.toList()));
                        if (stack.size() < n) accept(integer);
                        stack.pop();
                    }
                }
            };

            consumer.accept(1);
            System.out.println(listSet.size());
        }
        scanner.close();
    }
}
