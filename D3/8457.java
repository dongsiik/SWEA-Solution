// 제목 : 알 덴테 스파게티
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzal4EKksEDFAVU
// 메모리 :  37,072 kb
// 실행시간 : 191 ms

import java.util.Scanner;
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수
        int T;
        T=sc.nextInt();
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//시계 수, 삶을 시간, 오차
            int n = sc.nextInt();
            int b = sc.nextInt();
            int e = sc.nextInt();
            int answer=0;
            
            //시계마다 주기를 입력받아 허용가능한지 결정
            for(int i=0;i<n;i++) {
                int x = sc.nextInt();
                if((b%x)<=e || (b%x-x)>=-e) answer++;
            }
             
            //출력
            System.out.println("#"+test_case+" "+answer);
        }
        sc.close();
    }
}