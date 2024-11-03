package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B21921_junho {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        String[] visitorsStr = br.readLine().split(" ");
        int[] visitors = new int[N];

        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(visitorsStr[i]);
        }


        int currentsum=0;
        int maxsum = 0;
        int maxcount = 1;
        for (int i = 0; i < T; i++) {
             currentsum += visitors[i];
            
        }

        maxsum = currentsum;

        for (int i = T; i < visitors.length; i++) {
            currentsum = currentsum - visitors[i-T] + visitors[i];

            if (maxsum<currentsum){
                maxsum = currentsum;
                maxcount = 1;
            }else if (maxsum == currentsum){
                maxcount++;
            }
            
        }

        if (maxsum==0){
            System.out.println("SAD");
        }else {
            System.out.println(maxsum);
            System.out.println(maxcount);
        }
    }

}