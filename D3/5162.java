// 제목 : 두가지 빵의 딜레마
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTaTDua3OoDFAVT
// 메모리 :  18,320 kb
// 실행시간 : 107 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
class Solution
{

	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//a,b,c 입력받기
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	//많이 사려면, 싼 것만 잔뜩 사면 됨
        	int c = Integer.parseInt(st.nextToken());
        	int m = Math.min(a, b);
        	int answer = c/m;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }   

        //출력
        System.out.print(sb.toString());
    }
}