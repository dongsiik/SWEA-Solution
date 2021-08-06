// 제목 : 퍼펙트 셔플
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
// 메모리 :  24,744 kb
// 실행시간 : 159 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
        	//카드 개수와, 카드를 두 개의 큐로 나누어 저장할 링크드 리스트
        	int n = Integer.parseInt(br.readLine());
        	LinkedList<Queue<String>> shuffle = new LinkedList<>();
        	shuffle.add(new LinkedList<>());
        	shuffle.add(new LinkedList<>());
        	
        	//입력받은 카드를 앞부분과 뒷부분으로 나누어서 저장
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		String card = st.nextToken();
        		if(i<(n+1)/2) shuffle.get(0).add(card);
        		else shuffle.get(1).add(card);
        	}
        	
        	//앞부분에서 한 장, 뒷부분에서 한장씩 꺼내며 출력
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<(n+1)/2;i++) {
        		for(int j=0;j<=1;j++) {
        			if(!shuffle.get(j).isEmpty()) {
        				String card = shuffle.get(j).poll();
        				sb.append(card).append(' ');
        			}
        		}
        	}
        	sb.append('\n');
        	
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}