// 제목 : 세제곱근을 찾아라
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXVyCaKugQDFAUo
// 메모리 :  18,432 kb
// 실행시간 : 103 ms

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
        	//세제곱근을 찾을 수
        	long n = Long.parseLong(br.readLine());
        	
        	//자바에서 지원하는 세제곱근을 정수로 내림한 후, 그 값이 진짜 세제곱근인지 확인
        	long answer=-1;
        	long i = (long)Math.cbrt(n);
        	if(i*i*i==n) answer=i;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}