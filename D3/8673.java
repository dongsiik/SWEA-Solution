// 제목 : 코딩 토너먼트1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW2Jldrqlo4DFASu
// 메모리 :  37,964 kb
// 실행시간 : 184 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        T=Integer.parseInt(br.readLine());
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//한 사람이 치르는 경기의 수와, 총 참가 인원
        	int n = Integer.parseInt(br.readLine());
        	int num = (int)Math.pow(2, n);
        	
        	//참가자별 코딩실력을 입력받아 큐에 집어넣음
        	Queue<Integer> q = new LinkedList<>();
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<num;i++) {
        		int a = Integer.parseInt(st.nextToken());
        		q.add(a);
        	}
        	
        	int answer=0;
        	//큐에서 두 사람을 꺼내서, 두 사람의 코딩 실력 차이를 지루함 총합에 더하고, 승자를 다음 대기열에 집어넣음
        	while(q.size()>1) {
        		int a = q.poll();
        		int b = q.poll();
        		answer += Math.abs(a-b);
                q.add(Math.max(a,b));
        	}
        	
        	//결과 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.print(sb.toString());  
        
    }
}