// 제목 : [S/W 문제해결 기본] 2일차 - Ladder1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
// 메모리 :  29,908 kb
// 실행시간 : 146 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
//    	System.setIn(new FileInputStream("input-1.txt"));	//예제 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = 10;
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int[][] arr = new int[100][100];	//그림
        	int direction = 0;	//진행방향
        	int cx = 99;	//현재 x,y좌표
        	int cy=0;
        	br.readLine();	//테스트 케이스 번호를 거르기 위한 readLine
        	
        	//그림 정보 입력받으며 시작점 찾기
        	for(int i=0;i<100;i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0;j<100;j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			if(arr[i][j]==2) cy = j;
        		}
        	}
        	
        	//아랫줄부터 맨 윗줄에 도착할 때까지 반복
        	while(cx!=0) {
        		//방향에 따라 위로 갈때는 좌우, 좌우로 갈때는 위 살펴보며 진행
        		switch(direction) {
        		case 0:
        			cx--;
        			if(cy>0 && arr[cx][cy-1]==1) direction=1;
        			if(cy<99 && arr[cx][cy+1]==1) direction=2;
        			break;
        		case 1:
        			cy--;
        			if(cx>0 && arr[cx-1][cy]==1) direction=0;
        			break;
        		case 2:
        			cy++;
        			if(cx>0 && arr[cx-1][cy]==1) direction=0;
        			break;
        		}
        	}
            //경우를 나누어 결과문 저장
            sb.append('#').append(test_case).append(' ').append(cy).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}
