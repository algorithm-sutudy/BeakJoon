import java.util.*;

public class B4485_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, count = 0;

        while ((n = scanner.nextInt()) != 0) {
            int[][] arrays = initArrays(n, scanner);
            PriorityQueue<Triple<Integer, Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.first)) {
                { offer(new Triple<>(arrays[0][0], 0, 0)); }
            };
            Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>();

            count++;
            while (!priorityQueue.isEmpty()) {
                Triple<Integer, Integer, Integer> current = priorityQueue.poll();

                if (current.second == n - 1 && current.third == n - 1) {
                    System.out.println("Problem " + count + ": " + current.first);
                    break;
                }
                visited.add(new AbstractMap.SimpleEntry<>(current.second, current.third));
                for (int[] next : new int[][] {
                        {current.second - 1, current.third},
                        {current.second, current.third + 1},
                        {current.second + 1, current.third},
                        {current.second, current.third - 1}
                }) {
                    if (visited.contains(new AbstractMap.SimpleEntry<>(next[0], next[1]))) continue;
                    if (next[0] > -1 && next[0] < n && next[1] > -1 && next[1] < n) {
                        priorityQueue.offer(new Triple<>(current.first + arrays[next[0]][next[1]], next[0], next[1]));
                    }
                }
            }
        }
        scanner.close();
    }

    private static int[][] initArrays(int n, Scanner scanner) {
        int[][] arrays = new int[n][n];

        Arrays.setAll(arrays, a -> {
            int[] array = new int[n];

            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            return array;
        });
        return arrays;
    }

    static class Triple<F, S, T> {
        F first;

        S second;

        T third;

        public Triple(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public String toString() {
            return "Triple{" +
                    "first=" + first +
                    ", second=" + second +
                    ", third=" + third +
                    '}';
        }
    }
}

