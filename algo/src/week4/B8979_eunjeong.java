import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();


        // medalList[4] 는 등수 의미
        int[][] medalList = new int[N][5];
        for(int i = 0; i < N ; i++){
            for (int j = 0; j < 4; j++){
                medalList[i][j] = scanner.nextInt();
            }
            medalList[i][4] = 1; // 일단 1로 초기화
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {

                    // 금메달 비교
                    if (medalList[i][1] < medalList[j][1]) {
                        medalList[i][4]++;
                    }

                    else if (medalList[i][1] == medalList[j][1]) {

                        // 금메달 같을 경우, 은메달 비교
                        if (medalList[i][2] < medalList[j][2]) {
                            medalList[i][4]++;
                        }

                        // 금메달과 은메달 모두 같을 경우, 동메달 비교
                        else if (medalList[i][2] == medalList[j][2]) {
                            if (medalList[i][3] < medalList[j][3]) {
                                medalList[i][4]++;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N ;i++){
            if (medalList[i][0] == K)
                System.out.println(medalList[i][4]);
        }

    }
    
}
