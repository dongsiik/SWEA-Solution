// 제목 : 의석이의 우뚝 선 산
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2h6AKBCoDFAVT
// 메모리 :  99,240 kb
// 실행시간 : 705 ms

import java.util.Scanner;

//아이디어 : 계곡이 a에, 산봉우리가 b에, 다시 게곡이 c에 있을  때(a<b<c) 이 구간에서 만들 수 있는 우뚝 선 산의 구간 수는 (b-a)*(c-b)개 이다.

class Solution
{
	
	public static void main(String args[])
    {
		//이 문제에서는 BufferedReader와 StringTokenizer를 사용하면 오류가 생겨서 Scanner를 사용함
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = sc.nextInt();
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int answer=0;
        	int ascendingLength=0;	//연속된 오르막길 길이
        	int descendingLength=0;	//연속된 내리막길 길이
        	boolean isAsceding = true;	//현재 올라가고 있는 중인지
        	
        	//산의 개수
        	int n = sc.nextInt();
        	
        	//가장 왼쪽산의 높이부터 시작
        	int previous = sc.nextInt();
        	
        	for(int i=1;i<n;i++) {
        		//산의 높이를 읽어와서 이전 산과 비교
        		int current  = sc.nextInt();
        		//오르막길
        		if(current>previous) {
        			//전에도 오르막길이었으면 오르막길 길이 하나 증가
        			if(isAsceding) ascendingLength++;
        			//내리막길이었다면, 그 전 구간에 있었던 우뚝 선 산 구간의 경우의 수 추가
        			else {
        				answer += ascendingLength * descendingLength;
        				ascendingLength = 1;
        				isAsceding = true;
        			}
        		}
        		//내리막길
        		else {
        			//오르막길이었다면, 내리막길이었다고 표시
        			if(isAsceding) {
        				descendingLength = 1;
        				isAsceding = false;
        			}
        			//내리막길이었다면 내리막길 길이 하나 증가
        			else {
        				descendingLength++;
        			}
        			
        		}
        		
        		previous = current;
        	}
        	
        	//마지막에 내리막길이었다면, 마지막 구간의 우둑 선 산 길이 추가
        	if(!isAsceding) answer += ascendingLength * descendingLength;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');

        }
        //출력
        System.out.printf(sb.toString());
    }
}