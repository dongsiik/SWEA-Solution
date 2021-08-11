// 제목 : [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// 메모리 :  18,352 kb
// 실행시간 : 111 ms
// 이 코드는 KSH님의 코드를 베껴서 훔친 것이며, input의 특징을 이용하여 코드가 매우 짧습니다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	
	public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = 10;
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//트리가 제 기능을 다 하는지를 나타내는 변수
        	int possible=1;
        	
        	//노드의 수 입력받기
        	int n = Integer.parseInt(br.readLine());
        	
        	for(int i=0;i<n;i++) {
        		//노드 정보 입력받기
        		String[] s = br.readLine().split(" ");
        		//노드가 자식 노드 정보를 가지고 있다면
        		if(s.length>2) {
        			//노드의 값이 숫자라면 트리가 제 기능을 하지 못함
        			if(Character.isDigit(s[1].charAt(0))) possible=0;
        		}
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(possible).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}