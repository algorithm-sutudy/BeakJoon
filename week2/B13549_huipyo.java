import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(ints -> ints[1])) { { add(new int[] {n, 0}); } };
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            if (outed[0] == k) {
                System.out.println(outed[1]);
                break;
            }
            visited.add(outed[0]);
            for (int[] next : new int[][] {{outed[0] * 2, outed[1]}, {outed[0] - 1, outed[1] + 1}, {outed[0] + 1, outed[1] + 1}}) {
                if (!visited.contains(next[0]) && next[0] > -1 && next[0] < 100_001) {
                    queue.offer(next);
                }
            }
        }
        scanner.close();
    }
}
