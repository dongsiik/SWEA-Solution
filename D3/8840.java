// 제목 : 아바바바
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW4Z8x2KAL8DFAQ7
// 메모리 :  60,692 kb
// 실행시간 : 219 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	//테스트 케이스 수
        int T;
        T=Integer.parseInt(br.readLine());
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//값을 입력받고 규칙성에 따라 답을 저장
            int l = Integer.parseInt(br.readLine());
            int n = (l-1)/2;
            long answer = (long)n*n;
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.print(sb.toString());
    }
}