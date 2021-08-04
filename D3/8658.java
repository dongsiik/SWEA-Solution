// 제목 : Summation
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW1lwyh6WPwDFARC
// 메모리 :  21,308 kb
// 실행시간 : 129 ms

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
        	//앞으로 갱신할 최댓값, 최솟값
        	int M=-1;
            int m = Integer.MAX_VALUE;
             
            for(int i=0;i<10;i++) {
            	int cur=0;
                //자연수를 받아옴
            	int a = sc.nextInt();
            	//자릿수를 구하고 각 자리수의 값을 구함
                int digit = (int)Math.log10(a);
                for(int j=0;j<=digit;j++) {
                    cur += a%10;
                    a/=10;
                }
                //최대, 최소와 비교하여 갱신
                M= Math.max(M,cur);
                m= Math.min(m,cur);
            }
            //출력
            System.out.println("#"+test_case+" "+M+" "+m);
        }
          
        sc.close();
    }
}