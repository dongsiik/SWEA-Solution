// 제목 : 유효기간
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXK6YRNaKq0DFAU3
// 메모리 :  26,492 kb
// 실행시간 : 128 ms

import java.util.Scanner;
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
        	//네 자리 문자열을 입력받아 두 글자씩 분리
            String s = br.readLine();
            int front = Integer.parseInt(s.substring(0,2));
            int end = Integer.parseInt(s.substring(2,4));
            
            //앞, 뒤가 각각 달이 될 수 있는지 확인
            boolean frontM = (front>0)&&(front<=12);
            boolean endM = (end>0)&&(end<=12);
              
            //경우를 나누어 결과문 저장
            sb.append('#').append(test_case).append(' ');
             
            if(frontM) {
                if(endM) sb.append("AMBIGUOUS");
                else sb.append("MMYY");
            }
            else {
                if(endM) sb.append("YYMM");
                else sb.append("NA");
            }
            sb.append('\n');
  
        }
        //출력
        System.out.println(sb);
    }
}