// 제목 : 정사각형 방
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
// 메모리 :  33,532 kb
// 실행시간 : 174 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
  
class Solution
{
	//델타 탐색을 위한 배열
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//개수를 입력받아 숫자를 기록할 배열 rooms를 만듦
        	int n = Integer.parseInt(br.readLine());
        	int[][] rooms = new int[n][n];
        	//방 별로 이동할 수 있는 방의 개수
        	int[][] counts = new int[n][n];
        	//번호가 큰 방부터 보도록 방을 내림차순 정렬하기 위한 ArrayList
        	ArrayList<Room> aRoom = new ArrayList<>(n*n);
        	//방 별로 이동할 수 있는 방 수를 따질 때 비교할 현재까지 최댓값, 최댓값의 좌표
        	int maxC = -1;
        	int maxI=0;
        	int maxJ=0;
        	
        	//방 정보를 입력받아 rooms에 적고, aRoom에도 넣어줌
        	for(int i=0;i<n;i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0;j<n;j++) {
        			rooms[i][j] = Integer.parseInt(st.nextToken());
        			aRoom.add(new Room(rooms[i][j],i,j));
        		}
        	}
        	//내림차순 정렬
        	aRoom.sort(null);
        	
        	//번호가 큰 방부터
        	for(int i=0;i<aRoom.size();i++) {
        		Room cur_room = aRoom.get(i);
        		int cx = cur_room.x;
        		int cy = cur_room.y;
        		//4방향을 보며 자신보다 번호가 큰 방이 있는지를 보고, 그렇다면 그 방의 이동횟수+1과 비교
        		for(int j=0;j<4;j++) {
        			int nx = cx+dx[j];
        			int ny = cy+dy[j];
        			if(nx>=0 && nx<n && ny>=0 && ny<n && (rooms[nx][ny]==rooms[cx][cy]+1)){
        				counts[cx][cy] = Math.max(counts[nx][ny]+1, counts[cx][cy]);
        			}
        		}
        		//최댓값을 넘었다면, 갱신
        		if(counts[cx][cy]>=maxC) {
        			maxC = counts[cx][cy];
        			maxI = cx;
        			maxJ = cy;
        		}
        	}
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(rooms[maxI][maxJ]).append(' ').append(maxC+1).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
	
	//방을 번호별로 내림차순 비교하기 위해 만든 클래스
	static class Room implements Comparable<Room>{
		int num;
		int x;
		int y;
		
		//생성자
		public Room(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Room o) {
			return this.num<=o.num? 1:-1;
		}
		
	}
}