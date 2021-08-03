// 제목 : 기차 사이의 파리
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWajaTmaZw4DFAWM
// 메모리 :  34,208 kb
// 실행시간 : 185 ms

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
        	//기차 사이의 거리, 기차 A B의 속도, 파리의 속도를 입력받음
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int d = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int f = Integer.parseInt(st.nextToken());
        	
        	//정답은 거리를 A와 B의 상대속도로 나눠 시간을 구하고, 그 시간만큼 파리의 속도를 곱하면 됨
        	double answer = (double)d / (double)(a+b) * (double)f;

        	//결과문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}