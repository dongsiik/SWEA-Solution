// 제목 : 극장 좌석
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWz5yIfq74QDFARQ
// 메모리 :  79,400 kb
// 실행시간 : 266 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{

    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
    	
        //테스트 케이스 수
        int T;
        T = Integer.parseInt(br.readLine());
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//아이디어 : 규칙을 찾아보면 Ai가 큰 순서부터 가운데부터 앉는 게 최소고, 다시 표현하면 인원수+Ai총합+가장 큰 Ai가 최솟값이다.
        	
        	//인원 수를 입력받음
        	int n = Integer.parseInt(br.readLine());
        	int M = -1;
        	
        	//정답, 일단 n을 더하고 시작
        	int sum=n;
        	
        	//사람들의 Ai를 입력받으며 총합에 더하고, 최댓값을 갱신해감
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		int a = Integer.parseInt(st.nextToken());
        		sum+=a;
        		M = Math.max(M, a);
        	}
        	//최댓값을 더함
        	sum +=M;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(sum).append('\n');
        }
        //출력
        System.out.print(sb.toString());
        
    }
}