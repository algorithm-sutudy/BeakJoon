package week4;

import java.util.*;

public class B25757_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 플레이하기를 신청한 횟수 N (1<=N<=100,000)
        char game = s.next().charAt(0);
        HashSet<String> players = new HashSet<>(); // 중복 값 허용하지 않는 HashSet 사용
        int result = 0;

        for (int i = 0; i < n; i++) {
            String player = s.next();
            players.add(player);
        }

        // Y => 2명 / F => 3명 / O => 4명
        switch (game) {
            case 'Y':
                result = players.size();
                break;
            case 'F':
                result = players.size() / 2;
                break;
            case 'O':
                result = players.size() / 3;
                break;
        }

        System.out.println(result);

        s.close();
    }
}
