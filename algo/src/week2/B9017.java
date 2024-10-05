package week2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B9017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t --> 0) {
            int n = scanner.nextInt();
            List<AbstractMap.SimpleEntry<Integer, Integer>> sorted = IntStream.range(0, n)
                    .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, scanner.nextInt()))
                    .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getValue))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue().size() == 6)
                    .flatMap(e -> e.getValue().stream())
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toList());
            int result = IntStream.rangeClosed(1, sorted.size())
                    .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, sorted.get(i - 1).getValue()))
                    .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getValue))
                    .entrySet()
                    .stream()
                    .map(e -> new int[]{e.getKey(), e.getValue().stream().limit(4).mapToInt(AbstractMap.SimpleEntry::getKey).sum(), e.getValue().get(4).getKey()})
                    .min((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[2] - o2[2])
                    .orElse(new int[3])[0];

            System.out.println(result);
        }
        scanner.close();
    }
}
