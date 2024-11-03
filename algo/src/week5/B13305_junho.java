package week5;

import java.util.Scanner;

public class B13305_junho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시의 개수 입력
        int N = sc.nextInt();

        // 도로의 거리 배열 입력
        long[] distances = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sc.nextLong();
        }

        // 주유소 리터당 가격 배열 입력
        long[] prices = new long[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextLong();
        }

        // 최소 비용 계산
        long minCost = 0;
        long minPrice = prices[0]; // 첫 번째 도시의 주유 가격으로 초기화

        for (int i = 0; i < N - 1; i++) {
            // 현재 최소 가격으로 거리만큼의 기름을 사서 이동
            minCost += minPrice * distances[i];

            // 현재 도시의 주유 가격이 더 낮다면 갱신
            if (prices[i + 1] < minPrice) {
                minPrice = prices[i + 1];
            }
        }

        // 결과 출력
        System.out.println(minCost);
        sc.close();
    }
}

