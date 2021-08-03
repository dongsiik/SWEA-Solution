// 제목 : 석찬이의 받아쓰기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW-hOY5KeEIDFAVg
// 메모리 :  29,968 kb
// 실행시간 : 189 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;  //테스트 케이스 수
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //문자열 길이, 문자열 두 개를 입력받음
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
             
            //첫 글자부터 비교해서 같은 글자를 셈
            int correct =0;
            for(int i=0;i<n;i++) {
                if(s1.charAt(i)==s2.charAt(i)) correct++;
            }
             
            System.out.println("#"+test_case+" "+correct);
 
        }
         
         
         
        sc.close();
    }
}