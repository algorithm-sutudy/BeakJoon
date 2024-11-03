package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B20922_junho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 두 번째 줄 수열 입력 처리
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 빈도 관리 배열과 포인터 초기화
        int[] freq = new int[100001];
        int left = 0;
        int maxLength = 0;

        // 투 포인터를 사용하여 조건을 만족하는 최장 길이 찾기
        for (int right = 0; right < N; right++) {
            freq[arr[right]]++;

            // 조건을 만족하지 않으면 왼쪽 포인터 이동
            while (freq[arr[right]] > K) {
                freq[arr[left]]--;
                left++;
            }

            // 현재 윈도우 길이로 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // 결과 출력
        System.out.println(maxLength);
    }
}
