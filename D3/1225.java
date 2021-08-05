// 제목 : [S/W 문제해결 기본] 7일차 - 암호생성기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
// 메모리 :  20,284 kb
// 실행시간 : 121 ms

import java.util.LinkedList;
import java.util.Queue;
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
        int T = 10;
        		//Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//테스트 케이스 번호 거르기
        	br.readLine();
        	
        	//8칸짜리 큐를 배열을 이용해 만들고 값을 입력받음
        	int[] q = new int[8];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<8;i++) q[i] = Integer.parseInt(st.nextToken());
        	
        	//subs는 암호화시키면서 뺄 값, head는 현재 queue의 시작부분 Index
        	int subs=0;
        	int head=0;
        	
        	//규칙대로 빼서 맨 뒤로 보냄(사실은 head를 움직인 칸 오른쪽으로 삼음)
        	while(true) {
        		q[head] = Math.max(0,q[head]-(++subs));
        		if(q[head++]==0) break;
        		subs %=5;
        		head %= 8;
        	}
        	head %= 8;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<8;i++) {
        		sb.append(q[head++]).append(' ');
        		head %= 8;
        	}
        	sb.setLength(sb.length()-1);
        	sb.append('\n');
        	
        	//API에서 제공되는 Queue 이용
/*        	//테스트 케이스 번호 거르기
  			br.readLine();

			//큐를 만들고 값을 입력받음
        	Queue<Integer> q = new LinkedList<Integer>();
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<8;i++) {
        		int num =Integer.parseInt(st.nextToken());
        		q.offer(num);
        	}
        	
        	//subs는 암호화 시키면서 뺄 수
        	int subs=0;
        	//규칙대로 숫자를 빼서 감소시키고 맨 뒤에 넣음
        	//0 이하면 0으로 두고 맨 뒤에 넣은 다음, 암호화 중단
        	while(true) {
        		int num = q.poll();
        		num = Math.max(0, num-(++subs));
        		q.offer(num);
        		if(num==0) break;
        		subs %= 5;
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<8;i++) sb.append(q.poll()).append(' ');
        	sb.setLength(sb.length()-1);
        	sb.append('\n');*/
        	
        	}
        //출력
        System.out.print(sb.toString());
    }
}