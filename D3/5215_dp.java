// 제목 : 햄버거 다이어트
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
// 메모리 :  21,568 kb
// 실행시간 : 132 ms
// 이 코드는 JJW님의 코드를 베껴서 훔쳐온 것입니다.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution{
	static int maxScore;
	static int[][] ingredient;
	static int N, L;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=T;t++) {
			maxScore = 0;
			String[] strs = bf.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			L = Integer.parseInt(strs[1]);
			ingredient = new int[N][2];
			dp = new int[L+1];
			
			for(int i=0;i<N;i++)
			{
				String[] tmps = bf.readLine().split(" ");
				int score = Integer.parseInt(tmps[0]);
				int calorie = Integer.parseInt(tmps[1]);
				for(int j=0;j<2;j++)
					ingredient[i][j] = Integer.parseInt(tmps[j]);
				
			}
			
			for(int i=0;i<N;i++) {
				int score = ingredient[i][0];
				int calorie = ingredient[i][1];
				for(int j=L;j>=0;j--) {
					if(j-calorie >= 0 && dp[j] < dp[j-calorie] + score)
						dp[j] = dp[j-calorie] + score;
				}
			}
			
			for(int i=0;i<=L;i++)
				if(dp[i] > maxScore)
					maxScore = dp[i];
			
			sb.append('#').append(t).append(' ').append(maxScore).append('\n');
		}
		System.out.println(sb.toString());
	}

}
