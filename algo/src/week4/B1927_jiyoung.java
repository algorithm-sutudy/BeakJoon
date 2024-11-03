package week4;

import java.util.*;

public class B1927_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 연산의 개수 N(1 ≤ N ≤ 100,000)
        PriorityQueue<Integer> array = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (x == 0) {
                // x가 0이면 배열의 최솟값 출력하고 제거
                if (!array.isEmpty()) {
                    System.out.println(array.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                // x가 자연수면 배열에 값을 추가
                array.add(x);
            }
        }

        s.close();
    }
}
