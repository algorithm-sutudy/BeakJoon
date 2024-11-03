import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2607_junho {
    // 문자 빈도 계산 함수
    private static Map<Character, Integer> getCharCount(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    // 두 단어가 비슷한지 확인하는 함수
    private static boolean areSimilar(String baseWord, String compareWord) {
        Map<Character, Integer> baseCount = getCharCount(baseWord);
        Map<Character, Integer> compareCount = getCharCount(compareWord);

        int diffCount = 0;
        int positiveDifference = 0; // 첫 번째 단어에만 있는 문자 개수
        int negativeDifference = 0; // 두 번째 단어에만 있는 문자 개수

        // 첫 번째 단어의 문자 빈도를 기준으로 차이 계산
        for (char c : baseCount.keySet()) {
            int baseFreq = baseCount.getOrDefault(c, 0);
            int compareFreq = compareCount.getOrDefault(c, 0);
            diffCount += Math.abs(baseFreq - compareFreq);

            if (baseFreq > compareFreq) {
                positiveDifference += baseFreq - compareFreq;
            } else {
                negativeDifference += compareFreq - baseFreq;
            }
        }

        // 비교 단어에만 있는 문자도 차이에 추가
        for (char c : compareCount.keySet()) {
            if (!baseCount.containsKey(c)) {
                int count = compareCount.get(c);
                diffCount += count;
                negativeDifference += count;
            }
        }

        // 비슷한 단어 조건: 차이가 0이거나, 1이거나, 또는 교체 가능한 차이 2인 경우
        return diffCount == 0 || diffCount == 1 || (diffCount == 2 && positiveDifference == 1 && negativeDifference == 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어 개수 입력
        int n = sc.nextInt();
        sc.nextLine(); // 개행 처리

        // 첫 번째 단어와 비교할 단어들 입력
        String firstWord = sc.nextLine();

        int similarCount = 0;

        for (int i = 1; i < n; i++) {
            String word = sc.nextLine();
            // 두 단어가 비슷한지 확인
            if (areSimilar(firstWord, word)) {
                similarCount++;
            }
        }

        // 결과 출력
        System.out.println(similarCount);
        sc.close();
    }
}
