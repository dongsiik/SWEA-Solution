// 제목 : [S/W 문제해결 응용] 3일차 - 최적 경로
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
// 메모리 :  25,000 kb
// 실행시간 : 1,233 ms
// next_permutation을 만들지 않고 재귀로 동선을 짜면서 백트래킹을 하면 실행시간이 더 짧아집니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
	public static int answer;	//정답
	public static int n;		//고객 수
	public static Node company;	//출발지인 회사
	public static Node home;	//도착지인 자신의 집
	public static Node[] customers;	//고객들의 집 주소 정보를 담은 배열
	
	public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//총 이동거리를 비교해가면서 줄일 예정이므로 int 최댓값으로 함
        	answer = Integer.MAX_VALUE;
        	//고객 수
        	n = Integer.parseInt(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	
        	//회사 좌표 입력
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	company = new Node(x,y);
        	
        	//집 주소 입력
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	home = new Node(x,y);
        	
        	//n명의 집 주소 입력
        	customers = new Node[n];
            for(int i=0;i<n;i++) {
            	x = Integer.parseInt(st.nextToken());
            	y = Integer.parseInt(st.nextToken());
            	customers[i] = new Node(x,y);
            }
            
            //next permutation에 넣고 돌릴 손님 번호 배열
            // visitingOrder[i]=j는 i+1번째로 방문할 고객은 j번 고객이라는 뜻
            int[] visitingOrder = new int[n];
            for(int i=0;i<n;i++) visitingOrder[i] = i;
            
            //모든 가능한 손님 방문 순서에 대하여
            do {
            	//회사와 첫 번째로 방문할 손님의 거리
        		int curDistance=getDistance(company, customers[visitingOrder[0]]);
        		//손님과 손님 사이의 거리
        		for(int i=0;i<n-1;i++)
        			curDistance += getDistance(customers[visitingOrder[i]], customers[visitingOrder[i+1]]);
        		//마지막 손님과 집까지의 거리
        		curDistance+=getDistance(customers[visitingOrder[n-1]],home);
        		
        		//구한 거리를 이전의 최솟값과 비교 후 갱신
        		answer = Math.min(answer, curDistance);
            }while(next_permutation(visitingOrder));
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
	
	//x,y 좌표를 저장하는 class
	public static class Node{
		public int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//두 노드 사이의 거리를 구해주는 함수
	public static int getDistance(Node a, Node b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	
	public static boolean next_permutation(int[] arr) {
		int n = arr.length;
		
		int i = n-1;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		if(i==0) return false;
		
		int j = n-1;
		while(arr[i-1]>=arr[j]) j--;
		swap(arr,i-1,j);
		
		int k = n-1;
		while(i<k) swap(arr,i++,k--);
		
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}