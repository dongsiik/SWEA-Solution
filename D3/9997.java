// 제목 : 미니멀리즘 시계
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXIvNBzKapEDFAXR
// 메모리 :  25,524 kb
// 실행시간 : 167 ms

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
 
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//값을 입력받아 시간과 분으로 바꿔줌
            int n = sc.nextInt();
            int h = n/30;
            int m = (n%30)*2;
             
            System.out.println("#"+test_case+" "+h+" "+m);
        }
         
        sc.close();
    }
}