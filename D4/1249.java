// 제목 : [S/W 문제해결 응용] 4일차 - 보급로
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
// 메모리 :  30,980 kb
// 실행시간 : 132 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	static BufferedReader br;

	public static void main(String args[]) throws IOException {
		// 입출력 도구
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			// 지도의 크기
			int n = Integer.parseInt(br.readLine());

			// 지도를 만들기
			int[][] map = new int[n][n];

			// 지도 정보 입력받기
			input(map);

			// 다익스트라
			int answer = dijkstra(map);

			// 출력문 저장
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}

		// 출력
		System.out.println(sb);
	}

	// 입력 받기
	private static void input(int[][] map) throws IOException {
		int n = map.length;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			// 한글자씩 읽으면서 char에서 int로 바꿔줌
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

	}

	// 다익스트라
	static int dijkstra(int[][] map) {
		// 9씩 100*100칸을 돌아도 나올 수 없는 큰 값을 무한대로 했음
		final int INF = 100_000;

		// 델타 탐색용 배열
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int n = map.length;

		// 거리 테이블을 만들고 무한으로 초기화
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], INF);
		}

		// 우선순위큐에 0,0을 넣고 시작
		PriorityQueue<Node> pq = new PriorityQueue<>();
		cost[0][0] = map[0][0];
		pq.add(new Node(0, 0, cost[0][0]));

		while (!pq.isEmpty()) {
			// 현재 지점
			Node current = pq.poll();
			int cx = current.x;
			int cy = current.y;
			int cCost = current.cost;

			// 이미 처리했으면 생략
			if (cCost > cost[cx][cy])
				continue;
			// 목적지라면 종료
			if (cx == n - 1 && cy == n - 1)
				break;

			// 4방향 탐색
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				// 지도 범위 안이면서
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 지금 지점을 거쳐가는 게 낫다면 거리를 갱신하고 큐에 넣음
					int nCost = cCost + map[nx][ny];
					if (cost[nx][ny] > nCost) {
						cost[nx][ny] = nCost;
						pq.add(new Node(nx, ny, nCost));
					}
				}
			}
		}

		return cost[n - 1][n - 1];
	}

	// x,y좌표와 0,0부터 이 점까지 오는 데 든 총 복구 시간
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}