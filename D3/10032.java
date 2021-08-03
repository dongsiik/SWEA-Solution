// 제목 : 과자 분배
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXJZ6_6KCLcDFAU3
// 메모리 :  28,956 kb
// 실행시간 : 133 ms

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
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
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
            //경우를 나누어 결과문 저장
            sb.append('#').append(test_case).append(' ');
            
            if(n%k==0) sb.append("0\n");
            else sb.append("1\n");
        }
        //출력
        System.out.printf(sb.toString());
    }
}