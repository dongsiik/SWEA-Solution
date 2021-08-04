// 제목 : 재미있는 오셀로 게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQmA4uK8ygDFAXj
// 메모리 :  18,408 kb
// 실행시간 : 108 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	//전역변수, 지도 크기는 place 함수에서도 필요하기 때문에 static 멤버변수로 선언해둠
	public static int[][] board;
	public static int n;
	public static int[] dx = {-1,1,0,0,-1,-1,1,1};
	public static int[] dy = {0,0,-1,1,-1,1,-1,1};

	//매개변수로 위치와 돌 색깔을 입력받아 그 자리에 놓고, 조건을 만족하는 다른 돌들을 뒤집는 함수
	public static void place(int x, int y, int color) {
		//매개변수로 받은 위치에 돌 색깔을 바꿈
		board[x][y] = color;
		
		//예를 들어서 흑돌을 새로 놓는다면, 한 방향을 따라 백돌이 쭉 있다가 흑돌이 나오는지를 보고, 그런 경우에는 중간에 있는 백돌을 다 흑돌로 바꿈
		
		//8방향 탐색 진행
		for(int rot=0;rot<8;rot++) {
			int cx = x;
			int cy = y;
			
			while(true) {
				//다음 돌의 위치
				int nx = cx+dx[rot];
				int ny = cy+dy[rot];
				
				//경계를 벗어나거나, 빈칸이 나온다면 더 이상 탐색할 필요가 없음
				if(nx<1 || nx>n || ny<1 || ny>n) break;
				if(board[nx][ny]==0) break;
				
				//다른 색의 돌이 나온다면 그 다음 칸으로 넘어감
				else if(board[nx][ny]!=color) {
					cx = nx;
					cy = ny;
				}
				
				//같은 색의 돌이 나온다면
				else if(board[nx][ny]==color) {
					int ccx = x;
					int ccy = y;
					//x,y부터 그 방향으로 한칸씩 다시 진행해가면서 사이에 있는 돌의 색을 바꿈
					while(true) {
						int nnx = ccx+dx[rot];
						int nny = ccy+dy[rot];
						if(nnx==nx && nny==ny) break;
						board[nnx][nny] = color;
						ccx = nnx;
						ccy = nny;
					}
					break;
				}
			}
		}
	}
	
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
        	//보드판의 크기, 돌을 놓는 수를 입력받고, 보드 가운데에 둘을 두 개 씩 놓음
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	board = new int[n+1][n+1];
        	board[n/2][n/2] = 2;
        	board[n/2][n/2+1] = 1;
        	board[n/2+1][n/2] = 1;
        	board[n/2+1][n/2+1] = 2;
        	
        	//돌을 놓는 위치와 색깔을 입력받아 돌을 놓음
        	for(int i=0;i<m;i++) {
        		st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	int color = Integer.parseInt(st.nextToken());
            	place(x,y,color);
//            	for(int ti=1;ti<=n;ti++) {
//            		for(int tj=1;tj<=n;tj++) System.out.printf("%d ",board[ti][tj]);
//            		System.out.println();
//            	}
//            	System.out.println();
        	}

        	//보드판을 다 탐색하면서 흑돌과 백돌의 개수를 셈
        	int white =0;
        	int black =0;
        	for(int i=1;i<=n;i++) {
        		for(int j=1;j<=n;j++) {
        			if(board[i][j]==2) white++;
        			if(board[i][j]==1) black++;
        		}
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(black).append(' ').append(white).append('\n');
        	}
        //출력
        System.out.printf(sb.toString());
    }
}