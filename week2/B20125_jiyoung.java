import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 판의 한 변의 길이 (5 <= n <= 1,000)
        char[][] cookie = new char[n][n];

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

        // 입력 값 2차원 배열에 저장 (쿠키 정보 입력받기)
        for (int i = 0; i < n; i++) {
            char[] input = s.next().toCharArray();
            for (int j = 0; j < n; j++) {
                cookie[i][j] = input[j];
            }
        }

//        // [test] 쿠키 정보 잘 저장되었는지 확인
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(cookie[i][j]);
//            }
//            System.out.println();
//        }

        // '심장' 찾기
        int heartRow = 0, heartCol = 0;

        for (int i = 1; i < n; i++) { // 머리가 존재하는 열이 있을테니 i=1부터 시작해도 상관 없음 (위에서부터 두 번째 줄부터 시작)
            for (int j = 1; j < n - 1; j++) {
                // 한 열에 *가 3개 이상 연속된다면 => 심장이 위치하는 열임
                if (cookie[i][j - 1] == '*' && cookie[i][j] == '*' && cookie[i][j + 1] == '*') {
                    // cookie[i][j]에서 위로 한 줄 올라갔을 때 그 값이 '*'이라면 cookie[i][j]가 심장임
                    if (cookie[i - 1][j] == '*') {
                        heartRow = i + 1;
                        heartCol = j + 1;
                    }
                }
            }
        }

        // '왼쪽 팔' 길이 구하기 (심장 왼쪽으로 가면서 탐색) => 위에서 1-based로 심장 좌표 설정해놓은 것에 주의 필요
        for (int i = heartCol - 2; i >= 0; i--) {
            if (cookie[heartRow - 1][i] == '*')
                leftArm++;
            else break;
        }

        // '오른쪽 팔' 길이 구하기 (심장 오른쪽으로 가면서 탐색) => 위에서 1-based로 심장 좌표 설정해놓은 것에 주의 필요
        for (int i = heartCol; i < n; i++) {
            if (cookie[heartRow - 1][i] == '*')
                rightArm++;
            else break;
        }

        // '허리' 길이 구하기
        for (int i = heartRow; i < n; i++) {
            if (cookie[i][heartCol - 1] == '*')
                waist++;
            else break;
        }

        // '왼쪽 다리' 길이 구하기
        for (int i = heartRow; i < n; i++) {
            if (cookie[i][heartCol - 2] == '*')
                leftLeg++;
        }

        // '오른쪽 다리' 길이 구하기
        for (int i = heartRow; i < n; i++) {
            if (cookie[i][heartCol] == '*')
                rightLeg++;
        }

        // 결과 출력
        System.out.println(heartRow + " " + heartCol); // 심장 위치
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

        s.close();
    }
}
