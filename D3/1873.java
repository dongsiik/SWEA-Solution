// 제목 : 상호의 배틀필드
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
// 메모리 :  22,272 kb
// 실행시간 : 123 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	public static char[][] map;	//게임 맵
	public static int w,h;		//게임 맵의 높이와 너비
	public static int[] dx = {1,-1,0,0};	//델타 탐색을 위한 배열
	public static int[] dy = {0,0,-1,1};
	public static int x,y,direction;	//전역변수로 전차의 좌표와 바라보고 있는 방향을 저장함
	
	//char로 들어온 방향을 델타탐색을 위해 정수형으로 선언한 direction에 넣는 함수
	public static void setDirection(char d) {
		switch(d) {
		case 'D':
		case 'v':
			direction = 0;
			break;
		case 'U':
		case '^':
			direction = 1;
			break;
		case 'L':
		case '<':
			direction = 2;
			break;
		case 'R': 
		case '>':
			direction = 3;
			break;
		}
	}
	
	//마지막에 지도에 탱크를 표시할 때, 탱크의 방향을 나타내기 위한 함수
	public static char getDirection() {
		switch(direction) {
		case 0:
			return 'v';
		case 1:
			return '^';
		case 2:
			return '<';
		case 3:
			return '>';
		}
		return '.';
	}
	
	//방향을 입력받아 그 방향으로 틀고, 한 칸 갈 수 있다면 가는 함수
	public static void move(char cDirection) {
		setDirection(cDirection);
		int nx = x+dx[direction];
		int ny = y+dy[direction];
		if(nx<0 || nx>=w || ny<0 || ny>=h) return;
		if(map[nx][ny]=='.') {
			x = nx;
			y = ny;
		}

	}
	
	//포탄을 쏘는 함수
	public static void shot() {
		//날아가고 있는 포탄의 현재 위치
		int cx = x;
		int cy = y;
		
		while(true) {
			//포탄의 다음 위치
			int nx = cx+dx[direction];
			int ny = cy+dy[direction];
			//맵을 뚫거나 강철벽을 만나면 그만둠
			if(nx<0 || nx>=w || ny<0 || ny>=h) break;
			else if(map[nx][ny]=='#') break;
			//벽돌벽을 만나면 그곳을 평지로 만들고 그만둠
			else if(map[nx][ny]=='*') {
				map[nx][ny]='.';
				break;
			}
			//기타의 경우(평지, 물) 한칸 더 진행함
			else {
				cx = nx;
				cy = ny;
			}
		}
	}

	//문자를 받아와서 S라면 대포를 쏘고, 아니라면 이동함
	public static void action(char c) {
		if(c=='S') shot();
		else move(c);
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
        	//너비와 높이를 받아와서 맵을 만듦
        	st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
        	map = new char[w][h];
        	
        	//맵을 읽어오는데, 전차라면 평지로 표시하고 위치와 방향은 전역변수에 저장함
        	for(int i=0;i<w;i++) {
        		String s = br.readLine();
        		for(int j=0;j<h;j++) {
        			char c = s.charAt(j);
        			if(c=='v' || c=='^' || c=='<' || c=='>') {
        				map[i][j]='.';
        				setDirection(c);
        				x = i;
        				y = j;
        			}
        			else map[i][j]=c;
        		}
        	}
        	
        	//사용자가 넣을 입력의 수를 받아오고, 입력들을 처리함
        	int n = Integer.parseInt(br.readLine());
        	String actions = br.readLine();
        	for(int i=0;i<n;i++) {
        		action(actions.charAt(i));
        	}
        	//마지막에 전차 위치를 지도에 표시함
        	map[x][y] = getDirection();
        	
        	//결과문 저장
        	sb.append('#').append(test_case).append(' ');
        	for(int i=0;i<w;i++) {
        		for(int j=0;j<h;j++) {
        			sb.append(map[i][j]);
        		}
        		sb.append('\n');
        	}
        }
        //출력
        System.out.printf(sb.toString());
    }
}