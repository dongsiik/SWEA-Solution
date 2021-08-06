// 제목 : 모음이 보이지 않는 사람
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcD_66pUEDFAV8
// 메모리 :  18,396 kb
// 실행시간 : 108 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
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
        	//문자열을 입력받아, 모음들을 다 지워줌
        	String s = br.readLine();
        	s = s.replaceAll("a", "");
        	s = s.replaceAll("e", "");
        	s = s.replaceAll("i", "");
        	s = s.replaceAll("o", "");
        	String answer = s.replaceAll("u", "");
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}