import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] T = br.readLine().split(" ");
        int N = Integer.parseInt(T[0]);
        int M = Integer.parseInt(T[1]);

        String [][] miro = new String[N][M];
        for (int i = 0; i < N; i++) {
            miro[i] = br.readLine().split(" ");
        }
        int startY = 0;
        int startX = 0;


        outerloop:
        for (int i = 0; i < miro.length; i++) {
            for (int j = 0; j < miro[0].length; j++) {
                if(miro[i][j].equals("2")){
                    startY = i;
                    startX = j;
                    break outerloop;
                }
            }
        }
        ArrayList<Integer> position = new ArrayList<>();
        position.add(startY);
        position.add(startX);

        Queue<List<Integer>> que = new LinkedList<>();
        que.add(Arrays.asList(startY, startX));
        while (!que.isEmpty()){
            List<Integer> currentPosition = que.poll();


        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if ()
//            }
//
//        }

    }
}
