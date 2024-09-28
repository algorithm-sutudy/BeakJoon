package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20125_eunjeong {

    static int head_x = 0;
    static int head_y = 0;
    static int heart_x = 0;
    static int heart_y = 0;
    static int waistLength = 0; // 허리
    static int leftArm_length = 0;
    static int rightArm_length = 0;
    static int leftLeg_length = 0;
    static int rightleg_length = 0;

    static int N = 0;

    public static void main(String[] args) throws IOException {

        // 2차원 배열로 저장 ( [1][1] 부터 시작 )
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        char[][] cookie = new char[N+1][N+1];
        for(int i = 1; i <= N ; i++ ) {
            String line = bf.readLine();
            for (int j = 1; j <= N; j++) {
                cookie[i][j] = line.charAt(j-1);
            }

        }

        // 위치 및 길이 계산
        findHeadPosition(cookie);
        findHeartPosition();
        findArmsLength(cookie);
        findWaistLength(cookie);
        findLegLength(cookie);

        // 출력
        System.out.println(heart_x + " " + heart_y);
        System.out.println(leftArm_length + " " + rightArm_length + " " + waistLength + " " + leftLeg_length + " " + rightleg_length);

    }
    public static void findHeadPosition(char[][] cookie) {
        int count = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                if(cookie[i][j] == '*'){
                    count++;
                    head_y = j;
                }
            }
            if(count == 1){
                head_x = i;
                break;
            }
        }
    }

    public static void findHeartPosition() {
        heart_x = head_x + 1;
        heart_y = head_y;
    }

    public static void findArmsLength(char[][] cookie) {
        for(int i = 1; i < heart_y; i++) {
            if (cookie[heart_x][i] == '*'){
                leftArm_length++;
            }
        }
        for(int i = heart_y + 1; i <= N ; i++) {
            if (cookie[heart_x][i] == '*'){
                rightArm_length++;
            }
        }
    }

    public static void findWaistLength(char[][] cookie) {
        for(int i = heart_x + 1; i <= N; i++){
            int count = 0;
            for(int j = 1; j <= N; j++) {
                if(cookie[i][j] == '*'){
                    count++;
                }
            }
            if(count == 1){
                waistLength++;
            }
            else{
                break;
            }
        }
    }

    public static void findLegLength(char[][] cookie) {
        int leftLeg_start_x = heart_x + waistLength + 1;
        int leftLeg_start_y = heart_y - 1;
        int rightLeg_start_x = heart_x + waistLength + 1;
        int rightLeg_start_y = heart_y + 1;

        for(int i =  leftLeg_start_x; i <= N; i++){
            if(cookie[i][leftLeg_start_y] == '*'){
                leftLeg_length++;
            }
        }
        for(int i =  rightLeg_start_x; i <= N; i++){
            if(cookie[i][rightLeg_start_y] == '*'){
                rightleg_length++;
            }
        }
    }
}