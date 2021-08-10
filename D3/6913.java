// 제목 : 동철이의 프로그래밍 대회
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWjlFcGK3dMDFAVT
// 메모리 :  18,992 kb
// 실행시간 : 111 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스 마다
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			//사람 수
			int n = Integer.parseInt(st.nextToken());
			//문제 수
			int m = Integer.parseInt(st.nextToken());
			
			//사람 별로 맞힌 문제 수
			int[] scores = new int[n];
			
			//사람 별로 문제를 맞혔다면 맞힌 문제 수를 하나 늘려줌
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					int PassFail = Integer.parseInt(st.nextToken());
					if(PassFail==1) scores[i]++;
				}
			}
			
			//현재 최고점수
			int maxScore=-1;
			//현재 공동 1등 수
			int tie=0;
			
			//사람별로 점수를 보면서
			for(int i=0;i<n;i++) {
				///최고점보다 점수가 높다면, 최고점을 이 사람으로 하고 공동 1등 수를 1로 함
				if(scores[i]>maxScore) {
					maxScore = scores[i];
					tie=1;
				}
				//최고점과 동점이라면, 공동 1등 수를 하나 늘림
				else if(scores[i]==maxScore) tie++;
			}
			
			//출력문 저장
			sb.append('#').append(t).append(' ').append(tie).append(' ').append(maxScore).append('\n');
		}
		//출력
		System.out.printf(sb.toString());
	}
}
