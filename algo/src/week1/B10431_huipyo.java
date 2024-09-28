package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int COUNT = 20;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();

        for (int a = 0; a < p; a++) {
            int t = scanner.nextInt();
            List<Integer> list = new ArrayList<>() {
                {
                    for (int i = 0; i < COUNT; i++) {
                        add(scanner.nextInt());
                    }
                }
            };
            int[] positions = new int[COUNT];
            int totalMoves = 0;

            for (int i = 0; i < COUNT; i++) {
                int current = list.get(i);
                int j = i;

                // 자기보다 큰 학생을 찾는다.
                while (j > 0 && positions[j - 1] > current) {
                    positions[j] = positions[j - 1];
                    j--;
                    totalMoves++;
                }

                // 현재 학생을 자리에 넣는다.
                positions[j] = current;
            }
            System.out.println(t + " " + totalMoves);
        }
        scanner.close();
    }
}
