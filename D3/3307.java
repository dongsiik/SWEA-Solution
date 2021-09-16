// 제목 : 최장 증가 부분 수열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
// 메모리 :  22,356 kb
// 실행시간 : 137 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {

		// 빠른 입출력을 위한 도구들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		// 각각의 테스트 케이스 마다
		for (int test_case = 1; test_case <= T; test_case++) {
			// n
			int n = Integer.parseInt(br.readLine());

			// n log n DP를 쓰기 위한 LIS 배열. LIS[length]= j는 leng길이인 LIS중 가장 작은 끝 값이 j라는 뜻
			int[] LIS = new int[n + 1];
			// 현재 가장 긴 부분 증가 수열 길이
			int count = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 값 입력받기
				int current = Integer.parseInt(st.nextToken());
				// LIS 배열에 값을 넣을 위치 찾기
				int pos = binarySearch(LIS, 0, count + 1, current);

				// 값을 넣기
				LIS[pos] = current;
				// LIS가 늘어난다면 갯수 하나 증가시키기
				if (pos > count)
					count++;

			}
			// 출력문 저장
			sb.append('#').append(test_case).append(' ').append(count).append('\n');

		}
		// 출력
		System.out.print(sb.toString());
	}

	// 이진 탐색
	static int binarySearch(int[] arr, int start, int end, int target) {
		// 비슷한 값이 여러 개 있으면 가장 오른쪽 값을 찾아야합니다.
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] <= target)
				start = mid + 1;
			else if (arr[mid] > target)
				end = mid;
		}

		return start;
	}
}