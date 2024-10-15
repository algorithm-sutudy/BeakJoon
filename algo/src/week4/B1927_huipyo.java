import java.util.*;

public class B1927_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();

            if (x > 0) priorityQueue.offer(x);
            else stringBuilder.append(!priorityQueue.isEmpty() ? priorityQueue.poll() : 0).append("\n");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }
}
