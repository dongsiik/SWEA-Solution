// 제목 : [S/W 문제해결 응용] 8일차 - 사람 네트워크2
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN
// 메모리 :  97,376 kb
// 실행시간 : 1,491 ms
// 플로이드 워셜 알고리즘 적용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {
	public static void main(String args[]) throws IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		// 다른 수를 더해도 오버플로가 나지 않으면서 문제 상황에서는 나올 수 없는 무한대값
		final int INF = 1_000_000_000;

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 사람 수
			int n = Integer.parseInt(st.nextToken());
			// 그래 프
			int[][] graph = new int[n][n];

			// 그래프 정보 입력받기
			// 자기 자신과의 경로가 아니면서 0이라면, 무한대로 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if(graph[i][j]==0 && (i!=j)) graph[i][j] = INF;
				}
			}

			// i단계 사람을 거쳤을 때
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						// 거친 경우와 안 거친 경우 중 최솟값으로 갱신
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}

			// 결과
			int answer = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				// 행별로 합을 구한 후, 결과와 값을 비교
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += graph[i][j];
				}
				answer = Math.min(answer, sum);
			}

			// 출력문 저장
			sb.append('#').append(tc).append(' ').append(answer).append('\n');

		}

		// 출력
		System.out.println(sb);
	}

}
