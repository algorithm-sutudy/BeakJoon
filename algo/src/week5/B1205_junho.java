package week5;

import java.util.*;

public class B1205_junho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();         // 현재 랭킹 리스트에 있는 점수의 개수
        int newScore = sc.nextInt();  // 태수의 새로운 점수
        int P = sc.nextInt();         // 랭킹 리스트에 올라갈 수 있는 최대 점수의 개수

        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt(); // 현재 랭킹 리스트의 점수들
        }

        int rank = 1; // 태수의 등수 초기화

        if (N == 0) {
            // 랭킹 리스트에 점수가 없을 경우, 태수의 등수는 1등
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (newScore < scores[i]) {
                rank++; // 새로운 점수가 기존 점수보다 작으면 등수를 하나 증가
            } else {
                break;  // 더 이상 비교할 필요 없으므로 반복문 종료
            }
        }

        if (N == P && newScore <= scores[N - 1]) {
            // 랭킹 리스트가 꽉 찼고, 새로운 점수가 리스트의 가장 낮은 점수보다 작거나 같을 때
            System.out.println(-1);
            return;
        }

        if (rank > P) {
            // 태수의 등수가 랭킹 리스트에 올라갈 수 있는 최대 등수보다 높을 때
            System.out.println(-1);
        } else {
            System.out.println(rank); // 태수의 최종 등수 출력
        }
    }
}
