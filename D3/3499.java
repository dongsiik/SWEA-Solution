// 제목 : 퍼펙트 셔플
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
// 메모리 :  24,668 kb
// 실행시간 : 130 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//카드 개수와, 카드 정보를 입력받음
        	int n = Integer.parseInt(br.readLine());
        	ArrayList<String> cards = new ArrayList<>();
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) cards.add(st.nextToken());
        	
        	//앞에서부터 하나, 중간부터 하나씩 뽑아서 출력문에 저장
        	sb.append('#').append(test_case).append(' ');
        	int tab = (n+1)/2;
        	for(int i=0;i<tab;i++) {
        		sb.append(cards.get(i)).append(' ');
        		if(i+tab<n) sb.append(cards.get(i+tab)).append(' ');
        	}
        	sb.append('\n');
        	
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}