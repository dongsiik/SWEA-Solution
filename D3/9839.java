// 제목 : 최고의 쌍
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXGBGehqPAADFAXR
// 메모리 :  49,104 kb
// 실행시간 : 529 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
	//두 수의 곱이 내림차순으로 연속인지 확인하고, 그렇다면 곱한 값을 아니면 1을 반환함
    public static int ssang(int x, int y) {
        int value = x*y;
        int a = x*y;
        
        //자리수를 구해서 한 자리수라면 그대로 반환
        int digit = (int)Math.log10(a);
        if(digit==0) value = a;
        //아니라면 자리수별로 비교함
        else {
            for(int i=0;i<digit;i++) {
                int right = a%10;
                a/=10;
                int left = a%10;
                if((left-right)!=-1) {
                    value = -1;
                    break;
                }
            }
        }
         
         
        return value;
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;	//테스트 케이스 수
        T=sc.nextInt();
         
 
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//정수의 개수와, 그만큼의 정수를 모두 입력받음
            int n = sc.nextInt();
            int answer = -1;
             
            int[] arr = new int[n];
             
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
             
            //반복문을 돌면서 완전 탐색
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    answer = Math.max(answer, ssang(arr[i],arr[j]));
                }
            }
             
            System.out.println("#"+test_case+" "+answer);
         
 
        }
         
         
         
        sc.close();
    }
}