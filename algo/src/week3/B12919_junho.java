package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12919_junho {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        StringBuilder sbStart = new StringBuilder(input1);
        StringBuilder sbTarget = new StringBuilder(input2);

        System.out.println(dfs(sbStart,sbTarget));
    }

    private static int dfs(StringBuilder sbStart, StringBuilder sbTarget) {

        while (sbTarget.length() > sbStart.length()) {
            if (sbTarget.charAt(sbTarget.length()-1)=='A'){
                sbTarget.deleteCharAt(sbTarget.length()-1);

            } else if (sbTarget.charAt(sbTarget.length()-1)=='B') {
                sbTarget.deleteCharAt(sbTarget.length()-1);
                sbTarget.reverse();
            }
        }
        if (sbStart.toString().equals(sbTarget.toString())) {
            return 1;
        }else {
            return 0;
        }
    }
}
