// 제목 : 창용 마을 무리의 개수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
// 메모리 :  23,696 kb
// 실행시간 : 124 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
	static int answer;	//무리의  수
	static int n;		//사람 수
	static boolean[][] graph;	//graph[i][j]=true 는 i번과 j번이 서로 아는 사이와 동치
	static int[] visited;		//몇 번 무리에 속해있는지를 나타냄
	
	public static void main(String args[]) throws IOException{
		
		//빠른 입출력을 위한 도구들
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//n, m 입력받기
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	//전역변수 초기화
        	answer=0;
        	graph = new boolean[n+1][n+1];
        	visited = new int[n+1];
        	
        	//사람들 사이에 아는 관계 입력받기
        	for(int i=0;i<m;i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	graph[a][b] = true;
            	graph[b][a] = true;
        	}
        	
        	//사람들마다 무리에 속하지 않은 사람이 있다면, 그 사람부터 무리를 만들어줌
        	for(int i=1;i<=n;i++) {
        		if(visited[i]==0) {
        			++answer;
        			dfs(i);
        		}
        	}
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	

        }
        //출력
        System.out.print(sb.toString());
    }
	
	//dfs
	static void dfs(int start) {
		//answer번 무리에 가입시키기
		visited[start] = answer;
		
		//이 사람과 알면서 무리에 속하지 않은 사람들을 무리에 가입시키고, 재귀로 반복함
		for(int i=1;i<=n;i++) {
			if(visited[i]==0 && graph[start][i])
				dfs(i);
		}
	}
}