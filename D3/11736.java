// 제목 : 평범한 숫자
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXhh-H-KwUcDFARQ
// 메모리 :  31,200 kb
// 실행시간 : 130 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수를 입력받음
        int T;
        T=sc.nextInt();
 
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //숫자의 개수를 입력받고, 그만큼 배열을 만듦
            int n = sc.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
             
            숫자를 입력받음
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            
            비교해서 조건을 만족하면 값 증가 
            for(int i=1;i<n-1;i++){
                if(!((arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) || (arr[i]<=arr[i-1] && arr[i]<=arr[i+1])))cnt++;
            }
 
            //결과 출력
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}