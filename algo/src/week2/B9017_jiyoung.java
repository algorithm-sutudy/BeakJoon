package week2;

import java.util.*;

public class B9017_jiyoung {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt(); // test case 갯수

        // 전체 test case 횟수만큼 돌기
        for (int i = 0; i < t; i++) {
            int n = s.nextInt(); // 참여 인원 수 (6 <= n <= 1,000)
            int score = 1;

            int[] team = new int[n]; // 입력된 팀 번호 그대로 저장
            int[] teamNumSum = new int[n]; // 입력된 팀 번호를 계산해 => 팀별 몇 명인지 계산

            // 팀 번호 별 인원 수 누적
            for (int j = 0; j < n; j++) {
                int input = s.nextInt();

                team[j] = input;
                teamNumSum[input - 1] += 1; // 해당 팀 번호에 인원 수 누적하면서 저장
            }

            // 6명인 팀만 추출해 validTeams 리스트에 저장
            List<Integer> validTeams = new ArrayList<>();
            for (int j = 0; j < teamNumSum.length; j++) {
                if (teamNumSum[j] == 6)
                    validTeams.add(j + 1); // 나중에 입력 값과 비교하기 편하도록 0-based에다가 1을 더해서 저장
            }

            // validTeams 리스트에 있는 팀 번호를 갖는 입력 값들만 추출해 점수 부여
            Map<Integer, List<Integer>> teamScores = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int teamNum = team[j];

                if (validTeams.contains(teamNum)) {
                    if (!teamScores.containsKey(teamNum))
                        teamScores.put(teamNum, new ArrayList<>());
                    teamScores.get(teamNum).add(score++);
                }
            }

//            // [test] 팀별 선수들 점수 잘 부여되었는지 확인
//            System.out.println(teamScores); // ex) {1=[1, 4, 6, 7, 9, 12], 3=[2, 3, 5, 8, 10, 11]} 이런 식으로 출력됨

            // 팀 별 점수 합 구하기
            Map<Integer, Integer> teamScoreSum = new HashMap<>(); // 4명일 때 팀, 점수총합 저장해두는 Map
            Map<Integer, Integer> fifthPlayerScore = new HashMap<>(); // 5번째 선수 팀, 점수 저장해두는 Map
            for (Integer validTeam : validTeams) {
                List<Integer> scores = teamScores.get(validTeam);

                int sum = 0;
                for (int x = 0; x < 4; x++) {
                    sum += scores.get(x);
                }
                teamScoreSum.put(validTeam, sum);

                fifthPlayerScore.put(validTeam, scores.get(4));
            }

            // 우승팀(최소 점수를 가진 팀) 찾기
            Optional<Map.Entry<Integer, Integer>> winningTeamEntry = teamScoreSum.entrySet()
                    .stream()
                    .min((o1, o2) -> {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return fifthPlayerScore.get(o1.getKey()).compareTo(fifthPlayerScore.get(o2.getKey()));
                        } else {
                            return o1.getValue().compareTo(o2.getValue());
                        }
                    });

            System.out.println(winningTeamEntry.get().getKey());
        }

        s.close();
    }
}

// Map => 스트림을 제공하지 않음. 따라서, '.entrySet()'을 통해 각 항목을 스트림으로 변환해줘야 함
// 처음부터 스트림 쓸 걸....
