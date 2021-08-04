// 제목 : 적고 지우기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW37UDPKCgQDFATy
// 메모리 :  32,248 kb
// 실행시간 : 201 ms

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
        	//문자별로 개수를 저장할 배열
            int[] cnt = new int[10];
            
            //문자열 받아오기
            String s = sc.next();
            char[] c = s.toCharArray();
            
            //앞에서부터 문자열 읽으면서 있었다면 지우고, 없었다면 적음
            for(int i=0;i<s.length();i++) {
                cnt[c[i]-'0'] = (cnt[c[i]-'0']+1)%2;
            }
             
            //결과 출력
            int answer=0;
            for(int i=0;i<10;i++) {
                if(cnt[i]==1) answer++;
            }
             
            System.out.println("#"+test_case+" "+answer);
        }
          
          
          
        sc.close();
    }
}