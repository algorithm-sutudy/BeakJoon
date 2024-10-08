import java.util.*;

public class B12919_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        System.out.println(bfs(s, t));
        scanner.close();
    }

    private static int bfs(String s, String t) {
        Queue<String> queue = new LinkedList<>(List.of(t));
        Set<String> visited = new HashSet<>(List.of(t));

        while (!queue.isEmpty()) {
            String outed = queue.poll();

            if (outed.equals(s)) {
                return 1;
            }
            for (String next : new String[] {
                    outed.endsWith("A") ? outed.substring(0, outed.length() - 1) : outed,
                    outed.startsWith("B") ? new StringBuilder(outed).reverse().substring(0, outed.length() - 1) : outed
            }) {
                if (visited.contains(next)) continue;
                queue.offer(next);
                visited.add(next);
            }
        }
        return 0;
    }
}
