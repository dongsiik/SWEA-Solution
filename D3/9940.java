// 제목 : 순열1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXHx23oq0REDFAXR
// 메모리 :  92,404 kb
// 실행시간 : 275 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
  
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//숫자의 개수를 입력받고, 그 숫자들을 저장할 배열 선언
        	int n = Integer.parseInt(br.readLine());
        	int[] count = new int[n+1];
        	
        	//숫자들을 입력받아 기록하고, 중복되었는지 확인
        	boolean dup = false;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		int a = Integer.parseInt(st.nextToken());
        		count[a]++;
        		if(count[a]>1) dup=true;
        	}
        	
        	//결과 출력
        	if(dup) sb.append('#').append(test_case).append(' ').append("NO\n");
        	else sb.append('#').append(test_case).append(' ').append("YES\n");
        }
        //출력
        System.out.printf(sb.toString());
    }
}