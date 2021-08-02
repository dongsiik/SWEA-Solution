// 제목 : 11688. Calkin-Wilf tree 1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXgZSOn6ApIDFASW
// 메모리 :  60,308 kb
// 실행시간 : 253 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T; //테스트 케이스 수
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a =1;	//분자
            int b =1;	//분모
            String s = sc.next();	//입력받은 스트링

            //스트링이 끝날때까지 분자나 분모 값 변경
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='L') b +=a;
                else a +=b;
            }
             
            //기약분수를 만들기 위해 최대공약수를 구하고 나눠줌
            int gcd =a;
            int gcd2 = b;
             
            while(gcd2>0){
                int tmp = gcd;
                gcd = gcd2;
                gcd2 =tmp%gcd2;
            }
            a = a/gcd;
            b = b/gcd;
            
            //결과 출력 
            System.out.println("#"+test_case+" "+a+" "+b);
             
        }
    }
}