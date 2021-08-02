// 제목 : 이진수 표현
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS
// 메모리 :  30,396 kb
// 실행시간 : 141 ms


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        //테스트 케이스 수 입력
        int T;
        T=Integer.parseInt(br.readLine());
  
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//m의 2진수 마지막 n비트가 모두 1이라면, m+1의 2진수 마지막 n비트는 0이고. 2^n으로 나누어떨어짐
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken())+1;
             
            int bigN = (int)Math.round(Math.pow(2, n));
              
            //결과값 저장
            if(m%bigN==0) sb.append('#').append(test_case).append(" ON\n");
            else sb.append('#').append(test_case).append(" OFF\n");
        }
        //결과값 출력
        System.out.println(sb);
    }
}