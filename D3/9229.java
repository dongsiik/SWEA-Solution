// 제목 : 한빈이와 Spot Mart
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
// 메모리 :  32,268 kb
// 실행시간 : 214 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	st = new StringTokenizer(br.readLine());
        	//과자 수, 무게 상한선
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = -1;
             
            //과자 무게 정보 입력
            int[] snacks = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
             
            //경우의 수를 줄여 구하기 위한 정렬
            Arrays.sort(snacks);
 
            //첫 번째 과자를 고르고, 두 번째 과자는 무거운 것부터 골라서 상한선 바로 아래 것을 들고 무게 비교
            for(int i=0;i<n;i++) {
                for(int j=n-1;j>i;j--) {
                    if((snacks[i]+snacks[j])<=m) {
                        answer = Math.max(answer, snacks[i]+snacks[j]);
                        break;
                    }
                }
            }
             
            //결과 출력
            System.out.println("#"+test_case+" "+answer);
 
        }
    }
}