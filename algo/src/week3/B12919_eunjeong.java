package week3;

import java.io.IOException;
import java.util.Scanner;

public class B12919_eunjeong {

    static String S;
    static String T;

    static int answer;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        S = scanner.nextLine();
        T = scanner.nextLine();

        answer = 0;

        DFS(T);

        System.out.println(answer);
    }

    public static void DFS(String str){
        if (answer == 1) {
            return;
        }

        if (str.equals(S)){
            answer = 1;
            return;
        }

        if (str.length() < S.length()) {
            return;
        }

        if (str.charAt(str.length()-1)=='A'){
            DFS(removeA(str));
        }

        if (str.charAt(0)=='B'){
            DFS(removeB(str));
        }

    }

    public static String removeA(String origin) {
        return origin.substring(0, origin.length()-1);
    }
    public static String removeB(String origin) {
        StringBuilder reversed = new StringBuilder(origin.substring(1));
        return reversed.reverse().toString();
    }

}
