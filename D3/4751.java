// 제목 : 다솔이의 다이아몬드 장식
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWSNw5jKzwMDFAUr
// 메모리 :  18,796 kb
// 실행시간 : 103 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
class Solution
{

	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
       
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        String s1 = "..#.";	//1,5번째 줄에 반복되는 패턴
        String s2 = ".#.#";	//2,4번째 줄에 반복되는 패턴
        String s3 = "#.";	//3번째 줄에 반복되는 패턴
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	String s = br.readLine();	//꾸밀 문자열 입력받기
        	
        	//규칙에 따라 문자열 꾸미기
        	
        	for(int i=0;i<s.length();i++) sb.append(s1);
        	sb.append('.').append('\n');
        	        	
        	for(int i=0;i<s.length();i++) sb.append(s2);
        	sb.append('.').append('\n');
        	
        	for(int i=0;i<s.length();i++) sb.append(s3).append(s.charAt(i)).append('.');
        	sb.append('#').append('\n');

        	for(int i=0;i<s.length();i++) sb.append(s2);
        	sb.append('.').append('\n');

        	for(int i=0;i<s.length();i++) sb.append(s1);
        	sb.append('.').append('\n');
        	
        }   

        //출력
        System.out.print(sb.toString());
    }
}