// 제목 : 영준이의 카드 카운팅
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN
// 메모리 :  18,408 kb
// 실행시간 : 104 ms

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
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//카드 정보 입력받기
        	String input = br.readLine();
        	
        	boolean[][] duplicated = new boolean[4][14];	//무늬와 숫자별로 중복확인할 배열
        	int[] required = {13,13,13,13};					//무늬별 필요한 카드 수
        	boolean possible = true;						//중복이 있었는지 없었는지
        	
        	//세 글자씩 카드 정보 읽어오기
        	for(int i=0;i<input.length();i+=3) {
        		//무늬 읽기
        		int type = 3;
        		switch(input.charAt(i)) {
        		case 'S': type=0; break;
        		case 'D': type=1; break;
        		case 'H': type=2; break;
        		}
        		//숫자 읽기
        		int num = Integer.parseInt(input.substring(i+1, i+3));
        		
        		//중복이라면, 중복이라고 표시하고 그만두기
        		if(duplicated[type][num]) {
        			possible = false;
        			break;
        		}
        		
        		//중복이 아니라면 카드가 있다고 표시하고, 남은 카드 숫자 줄이기
        		duplicated[type][num] = true;
        		required[type]--;
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	if(possible) {
        		sb.append(required[0]).append(' ').append(required[1]).append(' ').append(required[2]).append(' ').append(required[3]).append('\n');
        	}
        	else {
        		sb.append("ERROR\n");
        	}
        	

        }
        //출력
        System.out.printf(sb.toString());
    }
}