// 제목 : [Professional] 키 순서
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// 메모리 :  103,512 kb
// 실행시간 : 1,297 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static final int INF = 1000;
	
	public static void main(String args[]) throws IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[n+1][n+1];
			for(int i=0;i<=n;i++) 
				for(int j=0;j<=n;j++)
					graph[i][j] = INF;
			
			for(int i=0;i<=n;i++)
				graph[i][i] = 0;
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 0;
			}
			
			for(int j=1;j<=n;j++) 
				for(int i=1;i<=n;i++) 
					for(int k=1;k<=n;k++) 
						graph[i][k] = Math.min(graph[i][k], graph[i][j]+graph[j][k]);
					
				
			
			int notClear = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(graph[i][j]!=0 && graph[j][i]!=0) {
						notClear++;
						break;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(n-notClear).append('\n');
		}

		// 출력
		System.out.println(sb);
	}
}