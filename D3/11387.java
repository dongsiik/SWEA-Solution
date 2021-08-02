// 제목 : 몬스터 사냥
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXb6LR76vCcDFARR
// 메모리 :  32,328 kb
// 실행시간 : 151 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //입력문을 받아올 br, 출력문을 모아둘 sb
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T;	//테스트 케이스 수
        T=Integer.parseInt(br.readLine());
 
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //d l n을 받아둠
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            //등차수열의 합 공식을 이용하여 합을 구함. 오버플로 방지를 위해 나누기를 중간중간에 먼저 했음
            int sum=d*n + (d/100)*(n*(n-1)/2)*l;

            //결과를 sb에 저장
            sb.append('#').append(test_case).append(' ').append(sum).append('\n');
        }
        //결과 출력
        System.out.println(sb);
    }
}