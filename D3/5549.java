// 제목 : 홀수일까 짝수일까
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWxpEDaAVoDFAW4
// 메모리 :  21,096 kb
// 실행시간 : 136 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//스트링으로 숫자를 받은 후, 마지막 자리만 int형으로 받아옴
        	String s = br.readLine();
        	int last = s.charAt(s.length()-1)-'0';
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	if(last%2==0) sb.append("Even").append('\n');
        	else sb.append("Odd").append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}