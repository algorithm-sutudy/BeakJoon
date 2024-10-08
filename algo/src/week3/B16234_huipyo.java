import java.util.*;
import java.util.function.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.AbstractMap.SimpleEntry;

public class B16234_huipyo {
    private static Map<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>, List<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>>> mGraph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
        int[][] arrays = initArrays(n, scanner);
        int answer = 0;

        while (!(mGraph = initGraph(arrays, l, r)).isEmpty()) {
            boolean[][] visited = new boolean[n][n];
            AtomicInteger sum = new AtomicInteger(0), count = new AtomicInteger(0);
            Consumer<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>> dfs = new Consumer<>() {
                @Override
                public void accept(SimpleEntry<Integer, SimpleEntry<Integer, Integer>> current) {
                    sum.addAndGet(current.getKey());
                    count.incrementAndGet();
                    for (SimpleEntry<Integer, SimpleEntry<Integer, Integer>> next : mGraph.getOrDefault(current, new ArrayList<>())) {
                        if (!visited[next.getValue().getKey()][next.getValue().getValue()]) {
                            visited[next.getValue().getKey()][next.getValue().getValue()] = true;

                            accept(next);
                        }
                    }
                }
            };

            //System.out.println(mGraph); 디버깅을 위한 주석으로 처리한 출력 코드
            answer++;
            for (SimpleEntry<Integer, SimpleEntry<Integer, Integer>> key : mGraph.keySet()) {
                if (!visited[key.getValue().getKey()][key.getValue().getValue()]) {
                    visited[key.getValue().getKey()][key.getValue().getValue()] = true;

                    sum.set(0);
                    count.set(0);
                    dfs.accept(key);
                    setArrays(arrays, visited, sum.get() / count.get());
                    Arrays.setAll(visited, b -> new boolean[n]);
                    /*for (int[] arr : arrays) { 디버깅을 위한 주석으로 처리한 출력 코드
                        System.out.println(Arrays.toString(arr));
                    }
                    System.out.println("sum: " + sum + ", count: " + count);*/
                }
                /*for (int[] arr : arrays) { 디버깅을 위한 주석으로 처리한 출력 코드
                    System.out.println(Arrays.toString(arr));
                }*/
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static void setArrays(int[][] arrays, boolean[][] visited, int value) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j]) {
                    arrays[i][j] = value;
                }
            }
        }
    }

    private static int[][] initArrays(int n, Scanner scanner) {
        int[][] arrays = new int[n][n];

        Arrays.setAll(arrays, a -> {
            int[] row = new int[n];

            for (int i = 0; i < row.length; i++) {
                row[i] = scanner.nextInt();
            }
            return row;
        });
        return arrays;
    }

    private static Map<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>, List<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>>> initGraph(int[][] array, int l, int r) {
        return new HashMap<>() {
            {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        putNode(array, new SimpleEntry<>(i, j), new SimpleEntry<>(i + 1, j), l, r, (a, b) -> {
                            computeIfAbsent(a, hhp227 -> new ArrayList<>()).add(b);
                            computeIfAbsent(b, hhp227 -> new ArrayList<>()).add(a);
                        });
                        putNode(array, new SimpleEntry<>(i, j), new SimpleEntry<>(i, j + 1), l, r, (a, c) -> {
                            computeIfAbsent(a, hong227 -> new ArrayList<>()).add(c);
                            computeIfAbsent(c, hong227 -> new ArrayList<>()).add(a);
                        });
                    }
                }
            }
        };
    }

    private static void putNode(
            int[][] array,
            SimpleEntry<Integer, Integer> currentPos,
            SimpleEntry<Integer, Integer> nextPos,
            int l,
            int r,
            BiConsumer<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>, SimpleEntry<Integer, SimpleEntry<Integer, Integer>>> biConsumer
    ) {
        int cx = currentPos.getKey(), cy = currentPos.getValue();
        int nx = nextPos.getKey(), ny = nextPos.getValue();

        if (nx != array.length && ny != array[0].length) {
            int a = array[cx][cy];
            int b = array[nx][ny];

            if (Math.abs(a - b) >= l && Math.abs(a - b) <= r) {
                biConsumer.accept(new SimpleEntry<>(a, currentPos), new SimpleEntry<>(b, nextPos));
            }
        }
    }
}

/*
9 1 2
1 2 3 4 5 6 7 8 9
4 5 6 7 8 9 1 2 3
3 4 5 6 7 8 9 1 2
2 3 4 1 2 3 4 5 6
3 4 5 8 9 1 2 3 4
5 5 5 5 5 1 2 4 4
1 1 1 1 2 3 4 5 6
9 8 7 6 5 4 3 3 3
2 3 4 1 2 3 4 5 6

ans: 13
 */

/*
2 2 3
4 5
2 5

ans: 2
 */
