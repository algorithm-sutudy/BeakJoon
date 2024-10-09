package week3;

import java.util.*;

public class B12919_jiyoung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이
        String s = scanner.next();
        String t = scanner.next();

        if (changeWord(s, t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        scanner.close();
    }

    // 재귀 함수: t에서 s로 변환 가능한지 여부를 반환
    public static boolean changeWord(String s, String t) {
        if (s.length() == t.length()) { // 둘의 길이가 같은 경우
            return s.equals(t);
        }

        // t가 'A'로 끝나는 경우
        if (t.endsWith("A")) {
            if (changeWord(s, t.substring(0, t.length() - 1))) {
                return true; // 변환 성공하면 바로 true 반환
            }
        }

        // t가 'B'로 시작하는 경우
        if (t.startsWith("B")) {
            String newT = new StringBuilder(t.substring(1)).reverse().toString();
            return changeWord(s, newT); // 변환 성공하면 true 반환
        }

        return false;
    }
}
