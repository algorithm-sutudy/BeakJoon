package week3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B21921_eunjeong {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();
        scanner.nextLine(); // 남아있는 개행 문자 처리

        // 방문자수 입력 받기
        int[] visit = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 방문자수 누적 합 (범위 누적)
        int[] visitSum = new int[N];
        visitSum[0] = visit[0];
        for(int i = 1; i < N ; i++){
            if( i >= X){
                visitSum[i] = visitSum[i - 1] + visit[i] - visit[i - X];
            }else{
                visitSum[i] = visitSum[i - 1] + visit[i];
            }
        }

        // 최대값, 최대값 횟수 찾기
        int max = 0;
        int count = 0;
        for(int i = 0; i< visitSum.length ; i++){
            if (max < visitSum[i]) {
                max = visitSum[i]; // 최대값 갱신
                count = 1; // 최대값 갱신 되면 count = 1;
            }
            else if (max == visitSum[i]){
                count++; // 최대값이 또 나오면 count++;
            }
        }

        // 출력하기
        if (max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }

    }
}