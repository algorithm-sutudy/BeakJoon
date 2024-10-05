package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B9017_junho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] member = br.readLine().split(" ");

            Map<Integer, Integer> teamCounts = new HashMap<>();
            for (int j = 0; j < member.length; j++) {
                int team = Integer.valueOf(member[j]);
                teamCounts.put(team, teamCounts.getOrDefault(team, 0) + 1);
            }

            Set<Integer> qualifiedTeams = new HashSet<>();
            for (Integer team : teamCounts.keySet()) {
                if (teamCounts.get(team) >= 6) {
                    qualifiedTeams.add(team);
                }
            }
            Map<Integer, List<Integer>> teamPoints = new HashMap<>();
            int point = 1;
            for (int j = 0; j < member.length; j++) {
                int team = Integer.valueOf(member[j]);
                if (qualifiedTeams.contains(team)) {
                    List<Integer> points = teamPoints.getOrDefault(team, new ArrayList<>());
                    points.add(point);
                    teamPoints.put(team, points);
                    point++;
                }
                // 비자격 팀은 점수를 부여하지 않음
            }

            int winTeam = -1;
            int bestScore = Integer.MAX_VALUE; // 최소 점수를 찾기 위해 초기값 설정
            int bestFiveMemberScore = Integer.MAX_VALUE; // 다섯 번째 주자의 최소 순위 찾기 위해 초기값 설정

            for (Integer team : teamPoints.keySet()) {
                List<Integer> ranks = teamPoints.get(team);
                if(ranks.size() >=6 ){
                    //Collections.sort(ranks);

                    int score = ranks.get(0) + ranks.get(1) + ranks.get(2) + ranks.get(3);
                    int fiveMemberScore = ranks.get(4);

                    if (score < bestScore ||
                            (score == bestScore && (fiveMemberScore < bestFiveMemberScore ||
                                    (fiveMemberScore == bestFiveMemberScore && team < winTeam)))) {
                        bestScore = score;
                        bestFiveMemberScore = fiveMemberScore;
                        winTeam = team;
                    }

                }

            }
            System.out.println(winTeam);
        }
    }
}
