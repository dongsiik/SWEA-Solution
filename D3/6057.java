// 제목 : 그래프의 삼각형
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=
// 메모리 :  36,872 kb
// 실행시간 : 184 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//점의 개수 n과 선분의 개수 m을 입력받음
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	//점마다 다른 점과 연결되어있는지를 저장할 배열을 만들어둠
        	boolean[][] arr = new boolean[n+1][n+1];
        	
        	//선분을 입력받으며 배열에 점이 다른 점과 연결되어있는지 저장
        	for(int i=0;i<m;i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		arr[x][y] = true;
        	}
        	
        	int answer=0;
        	
        	//i가 j와 연결되어있고, j가 k와 연결되어있을 때, i와 k가 연결되어있는지 확인(i<j<k)
        	for(int i=1;i<=n;i++) {
        		for(int j=i+1;j<=n;j++) {
        			if(arr[i][j]) {
        				for(int k=j+1;k<=n;k++) {
        					if(arr[j][k] && arr[i][k]) answer++;
        				}
        			}
        		}
        	}
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	}
        //출력
        System.out.printf(sb.toString());
    }
}