// 제목 : 구구단 1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXkcWgFa8sADFAS8
// 메모리 :  26,872 kb
// 실행시간 : 131 ms

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
 
        //각각의 테스트 케이스엗 ㅐ하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //수를 입력받음
            int n = sc.nextInt();
            boolean check=false;

            //입력받은 수가 1~9로 나누어떨어지는지 확인
            for(int i=1;i<=9;i++){
                if(n%i==0 && n/i<=9){
                    check = true;
                    break;
                }
            }
             
            //결과 출력
            if(check) System.out.println("#"+test_case+" Yes");
            else System.out.println("#"+test_case+" No");
        }
    }
}