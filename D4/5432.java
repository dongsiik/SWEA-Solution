// 제목 : 쇠막대기 자르기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm
// 메모리 :  32,052 kb
// 실행시간 : 143 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
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
        	//쇠막대기 정보 입력받기
        	String s = br.readLine();
        	int len = s.length();

        	//아이디어 : 레이저가 나온다면, 지금까지 나온 막대 중 끝나지 않은(괄호가 닫히지 않은) 막대기가 하나씩 잘린다.
        	//레이저마다 끝나지 않은 막대 수를 더한다.
        	long answer=0;
        	int rodCount=0;
        	
        	for(int i=0;i<len;i++) {
        		//막대기 시작이라면, 막대기 갯수를 하나 늘림(레이저를 알리는 (여도 바로 닫을 예정이라 상관 없음)
        		if(s.charAt(i)=='(') rodCount++;
        		else {
        			//닫는 괄호라면 막대기 갯수를 하나 줄이고
        			rodCount--;
        			//만약 레이저였다면, 잘린 막대 수를 더함
        			if(s.charAt(i-1)=='(') answer+=rodCount;
        			//레이저가 아니라면, 그 막대는 일단 한 조각이니까 하나 더함
        			else answer++;
        		}
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}