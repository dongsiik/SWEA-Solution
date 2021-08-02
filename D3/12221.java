// 제목 : 구구단 2
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXpz3dravpQDFATi
// 메모리 : 20,348 kb
// 실행시간 : 137 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스의 수를 입력받음
        int T;
        T=sc.nextInt();
        
        //각각의 테스트 케이스에 대하여 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = -1;
            //두 수를 입력받음
            int a = sc.nextInt();
            int b = sc.nextInt();

            두 수가 모두 조건을 만족하면 출력할 값을 a*b로 변경
            if(a<10 && b<10) answer = a*b;
            System.out.println("#"+test_case+" "+answer);
        }
         
        sc.close();
    }
}