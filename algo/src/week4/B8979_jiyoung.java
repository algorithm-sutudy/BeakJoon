package week4;

import java.util.*;

public class B8979_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 국가의 수 N(1 ≤ N ≤ 1,000)
        int k = s.nextInt(); // 등수를 알고 싶은 국가 K(1 ≤ K ≤ N)
        int[][] countries = new int[n][4]; // 국가 번호, 등수 저장할 배열

        // 국가 번호, 등수 배열에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                // [][0] 국가 번호, [][1] 금, [][2] 은, [][3] 동
                countries[i][j] = s.nextInt();
            }
        }

        // 국가 간 비교해서 내림차순 정렬
        Arrays.sort(countries, (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; // 금메달
            if (a[2] != b[2]) return b[2] - a[2]; // 은메달
            return b[3] - a[3]; // 동메달
        });

        // 순위 계산하기
        int rank = 1;
        for (int i = 0; i < n; i++) {
            // 이전 국가와 금, 은, 동메달 수가 다르면 순위 증가
            if (i > 0 && (countries[i][1] != countries[i - 1][1] ||
                    countries[i][2] != countries[i - 1][2] ||
                    countries[i][3] != countries[i - 1][3])) {
                rank = i + 1;
            }

            // 만약 국가 번호가 k이면 순위 출력하고 break
            if (countries[i][0] == k) {
                System.out.println(rank);
                break;
            }
        }

        s.close();
    }
}
