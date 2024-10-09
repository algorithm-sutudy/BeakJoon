package week3;

import java.util.Scanner;

public class B21921_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 블로그를 시작하고 지난 일수 N
        int x = s.nextInt(); // X일 (기간)

        int[] visitors = new int[n]; // 방문자 수 저장하는 배열

        int max = 0; // 최대 방문자 수 (X일 동안 가장 많이 들어온 방문자 수)
        int periodSum = 0; // 기간 합

        // 블로그 시작 1일차부터 N일차까지 하루 방문자 수 => 배열에 저장함
        for (int i = 0; i < n; i++) {
            visitors[i] = s.nextInt();
        }

        // 기간 별 방문자 수를 구함
        int current = 0;

        // 첫 번째 구간의 합을 계산함
        for (int i = 0; i < x; i++) {
            current += visitors[i];
            max = current;
            periodSum = 1;
        }
//        System.out.println("current = " + current); // [test] 첫 번째 구간의 합이 잘 저장되는지 확인

        // 첫 번째 구간 이후의 합을 계산하며 최댓값 설정
        for (int i = x; i < n; i++) {
            current = current - visitors[i - x] + visitors[i];

//            System.out.println("current = " + current); // [test] 첫 번째 구간 이후의 합이 잘 저장되는지 확인

            if (current >= max) {
                if (current != max) {
                    periodSum = 1;
                } else {
                    periodSum += 1;
                }
                max = current;
            }
        }

        // (출력) 기간이 몇 개 있는지 출력
        if (max != 0) {
            // (출력) X일 동안 가장 많이 들어온 방문자 수
            System.out.println(max);
            System.out.println(periodSum);
        } else {
            System.out.println("SAD");
        }

        s.close();
    }
}
