package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            int stepsBack = 0;
            Stack<Integer> line = new Stack<>();

            for (int j = 0; j < 20; j++) {
                int currentHeight = heights[j];
                Stack<Integer> tempStack = new Stack<>();

                while (!line.isEmpty() && line.peek() > currentHeight) {
                    tempStack.push(line.pop());
                    stepsBack++;
                }

                line.push(currentHeight);

                while (!tempStack.isEmpty()) {
                    line.push(tempStack.pop());
                }
            }

            System.out.println(T + " " + stepsBack);
        }
    }
}