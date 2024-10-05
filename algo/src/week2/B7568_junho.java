package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B7568_junho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(input[0]);// 무게
            people[i][1] = Integer.parseInt(input[1]);// 키

        }

        int[] ranks = new int[N];
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < ranks.length; j++) {
                if (i != j && people[i][0]< people[j][0] && people[i][1]<people[j][1]){
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        for (int i = 0; i < ranks.length; i++) {
            System.out.printf(ranks[i]+" ");

        }
    }
}
