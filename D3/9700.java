// 제목 : USB 꽂기의 미스터리
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXDNEA3aaU0DFAVX
// 메모리 :  25,048 kb
// 실행시간 : 140 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//p와 q를 입력받음
            double p = sc.nextDouble();
            double q = sc.nextDouble();
             
            //확률을 구해서 결과 출력
            if((1+p*q)<(2*p)) System.out.println("#"+test_case+" YES");
            else System.out.println("#"+test_case+" NO");
 
        }
         
         
         
        sc.close();
    }
}