// 제목 : [S/W 문제해결 기본] 8일차 - 암호문1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
// 메모리 :  18,340 kb
// 실행시간 : 111 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
  
class Solution
{
	
	public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = 10;
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//암호문을 저장할 링크드 리스트
        	LinkedList<String> message = new LinkedList<>();

        	//처음 암호문의 길이와 암호문 입력받기
        	int n = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) message.add(st.nextToken());
        	
        	//명령어의 개수
        	int k = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	//명령어마다
        	for(int i=0;i<k;i++) {
        		//I 거르기
        		st.nextToken();
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		//원하는 위치에 숫자를 덧붙임
        		for(int j=0;j<y;j++) message.add(x++, st.nextToken());
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<10;i++) sb.append(message.get(i)).append(' ');
        	sb.append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}