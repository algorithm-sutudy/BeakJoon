import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] request = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(request);

        // 국가 예산
        int budget = Integer.parseInt(bf.readLine());

        // 지방 요청 예산 총 합
        int requestSum = 0;
        for (int r : request) {
            requestSum += r;
        }

        // 모든 요청이 배정될 수 있는 경우
        if(requestSum <= budget) {
            System.out.println(request[N-1]);
            return;
        }

        // 모든 요청이 배정될 수 없는 경우
        int upperLimit = request[0];
        for(int i = 0; i < N; i++){

            // 배정되고 남은 국가 예산의 평균값 구하기 (배정되고 남은 국가 예산 / 배정되고 남은 지방의 수)
            int remainingBudgetAverage = budget / (N - i);

            // '아직 배정되지 않은 지방 요청 최소값' <= '남은 국가 예산의 평균값' 이면, 해당 요청 배정 확정
            // '아직 배정되지 않은 지방 요청 최소값'  > '남은 국가 예산의 평균값' 이면, 상한을 해당 평균값으로 지정
            if( request[i] <=  remainingBudgetAverage ) {
                budget -= request[i];
                upperLimit = request[i];
            }
            else{
                upperLimit = remainingBudgetAverage;
                break;
            }
        }
        System.out.println(upperLimit);

    }
}