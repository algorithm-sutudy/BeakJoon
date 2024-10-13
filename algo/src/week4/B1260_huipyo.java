import java.util.*;
import java.util.function.Consumer;

public class B1260_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), v = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int a = scanner.nextInt(), b = scanner.nextInt();

                    computeIfAbsent(a, huipyo -> new ArrayList<>()).add(b);
                    computeIfAbsent(b, huipyo -> new ArrayList<>()).add(a);
                }
                for (List<Integer> list : values()) {
                    Collections.sort(list);
                }
            }
        };
        List<String> dfsVisited = new ArrayList<>(List.of(String.valueOf(v)));
        List<String> bfsVisited = new ArrayList<>();
        Consumer<Integer> dfs = new Consumer<>() {
            @Override
            public void accept(Integer v) {
                for (int next : graph.getOrDefault(v, Collections.emptyList())) {
                    if (dfsVisited.contains(String.valueOf(next))) continue;
                    dfsVisited.add(String.valueOf(next));
                    accept(next);
                }
            }
        };
        Consumer<Integer> bfs = v1 -> {
            Queue<Integer> queue = new LinkedList<>(List.of(v1));

            while (!queue.isEmpty()) {
                int outed = queue.poll();

                bfsVisited.add(String.valueOf(outed));
                for (int next : graph.getOrDefault(outed, Collections.emptyList())) {
                    if (!bfsVisited.contains(String.valueOf(next)) && !queue.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
        };

        dfs.accept(v);
        bfs.accept(v);
        System.out.println(String.join(" ", dfsVisited));
        System.out.println(String.join(" ", bfsVisited));
        scanner.close();
    }
}
