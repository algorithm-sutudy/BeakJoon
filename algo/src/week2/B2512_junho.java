package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2512_junho {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int totalBuget = Integer.parseInt(br.readLine());

        int minNumber = 0;
        int maxNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(maxNumber < numbers[i]){
                maxNumber=numbers[i];
            }
        }


        int answer = 0;
        while (minNumber<=maxNumber){
            int midNumber = (minNumber+maxNumber)/2;
            int sum=0;
            for (int number : numbers) {
                if(number>midNumber){
                    sum += midNumber; // 상한액보다 큰 경우 상한액만 배정
                }else{
                    sum += number; // 상한액 이하인 경우 요청한 금액 그대로 배정
                }
            }

            if (sum <= totalBuget){
                answer = midNumber;
                minNumber = midNumber + 1;
            }else {
                maxNumber = midNumber - 1;

            }
        }
        System.out.println(answer);
    }
}