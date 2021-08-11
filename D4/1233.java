// 제목 : [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// 메모리 :  18,272 kb
// 실행시간 : 108 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
	public static int possible;		//주어진 트리가 연산이 가능한지
	public static int n;			//트리의 노드 수
	public static String[] nodes;	//트리, i번째 인덱스에는 i번째 노드가 저장됨
	
	//노드에 저장된 값이 연산자이면 true, 아니면 false
	public static boolean isOperation(int nodeNum) {
		String s = nodes[nodeNum];
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
		else return false;
	}
	
	//받은 node에서 자식들과 정상적으로 연산이 가능한지 따져보는 함수
	public static void validChk(int nodeNum) {
		//이미 다른 곳에서 연산이 안 된다면, 더 따질 필요가 없음
		if(possible==0) return;
		//자식이 한 명만 있으면, 트리가 연산이 안 된다고 바꿔주고 종료
		if(nodeNum*2==n) {
			possible=0;
			return;
		}
		//자식노드가 없으면서 자신이 연산자라면, 트리가 연산이 안 된다고 바꿔주고 종료
		if(nodeNum*2+1>n && isOperation(nodeNum)) {
			possible=0;
			return;
		}
		//자식노드가 있다면
		if(nodeNum*2+1<=n) {
			//각각의 자식들 노드에서 유효성 검사
			validChk(nodeNum*2);
			validChk(nodeNum*2+1);
			//자신이 연산자가 아니라면, 트리가 연산이 안 된다고 바꿔주고 종료
			if(!isOperation(nodeNum)) possible=0;
		}
	}
	
	public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = 10;
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//트리가 일단 연산이 가능하다가 치고, 노드 수를 입력받아 트리를 저장할 배열을 만듦
        	possible = 1;
        	n = Integer.parseInt(br.readLine());
        	nodes = new String[n+1];
        	
        	//배열에 노드의 값만 저장. 자식 노드는 현재 노드 번호*2, *2+1로 알 수 있으므로 저장 안 함
        	for(int i=1;i<=n;i++) {
        		st = new StringTokenizer(br.readLine());
        		int pos = Integer.parseInt(st.nextToken());
        		String value = st.nextToken();
        		nodes[pos] = value;
        	}
        	
        	//루트 노드부터 유효성 검사
        	validChk(1);
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(possible).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}