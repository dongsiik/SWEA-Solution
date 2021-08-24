// 제목 : 서로소 집합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
// 메모리 :  100,484 kb
// 실행시간 : 394 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
	static int[] parent;
	static int n;
	
	public static void main(String args[]) throws IOException
    {
		//빠른 입출력을 위한 BufferedReader br과 StringBuilder answerSheet
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//원소 수, 연산 수 입력받기
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
       
        	//부모 테이블 만들기
        	makeParent();
        	
        	//m개의 연산 시행 및 출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<m;i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		//연산자와 원소 두 개
        		int operation = Integer.parseInt(st.nextToken());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        	
        		//연산자가 0이면 합함
        		if(operation==0) makeUnion(a,b);
        		else {
        			//아니라면 같은 집합에 있는지 판단 후 출력문에 저장
        			sb.append(isInSameUnion(a, b));
        		}
        	}
        	sb.append('\n');
        	
        	

        }
        //출력
        System.out.print(sb.toString());
    }
	
	//부모 테이블 만들고 초기화
	public static void makeParent() {
		parent = new int[n+1];
		
		for(int i=1;i<=n;i++)
			parent[i] = i;
	}
	
	//부모 찾기 (경로 압축)
	public static int findParent(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = findParent(parent[a]);
	}
	
	//합집합. 두 원소를 합할 때, 더 작은 수가 부모가 되도록 했음
	public static void makeUnion(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if(aParent==bParent) return;
		if(aParent<bParent) parent[bParent] = aParent;
		else parent[aParent] = bParent;
	}
	
	//같은 집합인지 확인하는 함수
	public static int isInSameUnion(int a, int b) {
		if(findParent(a)==findParent(b)) return 1;
		else return 0;
	}
}