// 제목 : 2016년 요일 맞추기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWOwecaFrIDFAV4
// 메모리 :  18,604 kb
// 실행시간 : 102 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
        int T;	//테스트 케이스 수
        T=Integer.parseInt(br.readLine());
        //매달 1일의 요일 정보
        int[] firstDay = {0, 4, 0, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3};
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//요일을 알고 싶은 날짜를 입력받음
        	st = new StringTokenizer(br.readLine());
        	int m = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	//그 달 첫날과 비교해서 답을 구함
        	int answer = (d-1+firstDay[m])%7;
             
        	//결과문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.print(sb.toString());
    }
}
