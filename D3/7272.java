// 제목 : 안경이 없어!
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz
// 메모리 :  53,168 kb
// 실행시간 : 280 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        //문자열별 구멍의 개수를 저장해두고, 이 값이 같은지로 비교할 예정
        int[] alpha = {1, 2,  0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean answer = true;
             
            //문자열 두 개를 입력받음 
            String s1 = sc.next();
            String s2 = sc.next();
            int len = s1.length();
             
            //문자열 길이가 다르면 다른 문자열 
            if(len!=s2.length()) {
                answer = false;
            }
            길이가 같으면 앞문자부터 보면서 구멍 갯수가 같은지 확인
            else {
                for(int i=0;i<len;i++) {
                    if(alpha[s1.charAt(i)-'A']!=alpha[s2.charAt(i)-'A']) {
                        answer = false;
                        break;
                    }
                }
            }
 
            if(answer) System.out.println("#"+test_case+" SAME");
            else System.out.println("#"+test_case+" DIFF");
             
 
        }
         
         
         
        sc.close();
    }
}