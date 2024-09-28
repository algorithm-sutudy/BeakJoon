package week2;

import java.util.*;

public class B2512_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 지방의 수 (3 <= n <= 10,000)
        List<Integer> nMoney = new ArrayList<>(); // 지방 별 요청 액수 저장
        int nMoneySum = 0; // 지방 별 요청의 총합

        // 입력받으면서 요청 총합도 함께 계산하기
        for (int i = 0; i < n; i++) {
            nMoney.add(i, s.nextInt());
            nMoneySum += nMoney.get(i);
        }

        int m = s.nextInt(); // 총 예산

        int nMaxMoney = nMoney.stream().max(Comparator.naturalOrder()).get(); // 요청 최댓값 (최종 출력 값)

        if (nMoneySum <= m) {
            // 그대로 배정해도 되는 경우 (요청 총합 <= 총 예산)
            nMaxMoney = nMoney.stream()
                    .max(Comparator.naturalOrder())
                    .get();
        } else {
            // 상한액 설정 후 배정해야 하는 경우
            int low = 0; // 상한액의 범위 중 최솟값
            int high = nMaxMoney; // 상한액의 범위 중 최댓값
            nMaxMoney = 0; // 요청 최댓값 (최종 출력 값) 초기화 => 여기에 상한액을 저장할 것임

            // 이분 탐색 시작 (상한액 찾는 과정임)
            while (low <= high) {
                int mid = (low + high) / 2; // 상한액 중간값
                int sum = 0; // (상한액을 활용해 조정된) 요청 총합을 저장해둘 변수

                for (int money : nMoney) {
                    if (money > mid)
                        sum += mid;
                    else sum += money;
                }

                if (sum <= m) {
                    nMaxMoney = mid;
                    low = mid + 1; // 상한액 더 높여보기
                } else {
                    high = mid - 1; // 상한액 줄이기
                }
            }
        }
        System.out.println(nMaxMoney);

        s.close();
    }
}
