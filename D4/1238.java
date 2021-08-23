// 제목 : [S/W 문제해결 기본] 10일차 - Contact
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
// 메모리 :  18,416 kb
// 실행시간 : 106 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
  
class Solution
{
	
	public static void main(String args[]) throws IOException
    {
		//빠른 입출력을 위한 BufferedReader br과 StringBuilder answerSheet
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = 10; // Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//문자열 길이와 시작점 입력받기
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int len = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	
        	//인접행렬로 그래프 표현. BFS에서 중복 방지를 위해 쓰일 visited 배열
        	int[][] graph = new int[101][101];
        	boolean[] visited = new boolean[101];
        	
        	//그래프 입력받아 표시하기
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<len/2;i++) {
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		graph[from][to] = 1;
        	}
        	
        	//BFS용 Queue
        	Queue<Integer> q = new LinkedList<Integer>();
        	
        	//Queue에 시작점 넣기
        	int answer=start;
        	visited[start] = true;
        	q.offer(start);
        	
        	while(!q.isEmpty()) {
        		//지난 단계에서 연락받은 사람 수
        		int size = q.size();
        		//지금 단계에서 연락받을 사람 중 번호가 가장 큰 사람
        		int lastAndBiggest = -1;
        		//연락 시작
        		for(int s=0;s<size;s++) {
        			//전화 거는 사람 번호
        			int from = q.poll();
        			for(int i=1;i<=100;i++) {
        				//연락가능하면서 전에 연락을 안 받은 사람이라면
        				if(graph[from][i]==1 && !visited[i]) {
        					//큐에 넣고, 번호가 얼마나  큰지 비교
        					visited[i] = true;
        					q.offer(i);
        					lastAndBiggest = Math.max(lastAndBiggest, i);
        				}
        			}
        		}
        		//지금 단계에서 연락받은 사람이 있었다면, 정답을 갱신
        		if(lastAndBiggest!=-1) answer = lastAndBiggest;
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');

        }
        //출력
        System.out.printf(sb.toString());
    }
}