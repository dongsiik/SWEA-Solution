// 제목 : 세상의 모든 팰린드롬
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWO6Oao6N4QDFAWw
// 메모리 :  18,380 kb
// 실행시간 : 101 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        	//팰린드롬인지 검사할 문자열을 char[]에 저장함
        	char[] str = br.readLine().toCharArray();
        	int len = str.length;
        	String answer="Exist";
        	
        	//양 끝부터 안쪽으로 한 쌍씩 비교하면서
        	for(int i=0;i<len/2;i++) {
        		//서로 다르면서, 둘다 '?'가 아니면 회문이 아니므로 아니라고 기록하고 검사를 그만둠
        		if(str[i]!=str[len-1-i] && str[i]!='?' && str[len-1-i]!='?') {
        			answer="Not exist";
        			break;
        		}
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}