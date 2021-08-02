// 제목 : 제곱 팰린드롬 수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXO72aaqPrcDFAXS
// 메모리 :  26,424 kb
// 실행시간 : 133 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
	//어떤 수가 팰린드롬 수인지 확인하는 함수
    public static boolean Palindrome(int num) {
    	//숫자를 문자열로, 다시 문자의 배열로 변환. 1111 -> "1111" -> '1' '1' '1' '1'
        char[] c = Integer.toString(num).toCharArray();
        boolean chk=true;
        int digit = c.length;
        //앞과 뒤가 같은지 비교
        for(int i=0;i<digit/2;i++) {
            if(c[i]!=c[digit-1-i]) {
                chk = false;
                break;
            }
        }
                  
        return chk;
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;	//테스트 케이스 수
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//a와 b를 입력받음
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int count =0;	//결과값
            
            //루트a보다 이상의 정수, 그 값과 제곱수가 팰린드롬 수인지 확인 
            int start = (int)Math.ceil(Math.sqrt(a));
            for(int i=start;i*i<=b;i++) {
                if(Palindrome(i) && Palindrome(i*i)) {
                    count++;
                }
            }
             
            //결과 출력
            System.out.println("#"+test_case+" "+count);
 
        }
    }
}