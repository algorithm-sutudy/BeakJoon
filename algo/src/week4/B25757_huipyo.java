import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B25757_huipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String type = scanner.next();

        System.out.println(IntStream.range(0, n).mapToObj(i -> scanner.next()).collect(Collectors.toSet()).size() / ((type.equals("Y")) ? 1 : type.equals("F") ? 2 : 3));
        scanner.close();
    }
}
