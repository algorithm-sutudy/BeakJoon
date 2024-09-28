package week2;

import java.io.IOException;
import java.util.*;

public class B7568_eunjeong {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] weight = new int[N];
        int[] height = new int[N];
        int[] score = new int[N];

        for(int i = 0; i < N; i++){
            weight[i] = scanner.nextInt();
            height[i] = scanner.nextInt();
        }

        for(int i = 0; i < N; i++){
            score[i] = 1;
            for(int j = 0; j < N; j++){
                if (weight[i] < weight[j] && height[i] < height[j]){
                    score[i]++;
                }
            }
        }

        for (int s : score) {
            System.out.printf(s + " ");
        }

    }
}