// 제목 : 구독자 전쟁
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXMCXV_qVgkDFAWv
// 메모리 :  20,128 kb
// 실행시간 : 103 ms

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
        int T;
        T=Integer.parseInt(br.readLine());
 
        //테스트 케이스별로 반복문
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//n, a, b를 입력받음
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n =Integer.parseInt(st.nextToken());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            
            //집합의 성질을 이용한 최솟값, 최댓값 계산
            int m = Math.min(a, b);
            int M = Math.max(0, a+b-n);
             
            //출력문 저장
            sb.append('#').append(test_case).append(' ').append(m).append(' ').append(M).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}