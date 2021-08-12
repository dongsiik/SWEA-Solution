// 제목 : 규영이와 인영이의 카드게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 메모리 :  20,392 kb
// 실행시간 : 2,763 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
	//규영이의 승, 패
	public static int win, lose;
	//규영이와 인영이가 가지고 있는 카드 목록
	public static int[] gyu;
	public static int[] inn;
	//인영이가 순서대로 낼 카드 배열
	public static int[] cur_inn;
	
	//비트마스킹을 이용해서 인영이가 카드 내는 순서를 구하기
	public static void permutation(int cnt, int flag) {
		//인영이가 낼 9개의 순서를 다 구했다면 승패 계산
		if(cnt==9) {
			int gyuSum=0;
			int innSum=0;
			for(int i=0;i<9;i++) {
				//이번에 낸 카드가 규영이가 더 크면 규영이가 카드들을 가져가고, 아니면 반대로
				if(gyu[i]>cur_inn[i]) gyuSum += gyu[i]+cur_inn[i];
				else innSum += gyu[i]+cur_inn[i];
				
				//빠른 계산을 위해 승부가 결정되었다면 결과를 정하고 중단
				if(gyuSum>171) {
					win++;
					return;
				}
				if(innSum>171) {
					lose++;
					return;
				}
			}
			if(gyuSum>innSum) win++;
			if(gyuSum<innSum) lose++;
			
			return;
		}
		//아직 인영이가 낼 카드 순서가 다 정해지지 않았다면
		for(int i=0;i<9;i++) {
			//지금 넣을까말까 하는 카드가 이미 순서에 포함되었다면 건너뜀
			if((flag & 1<<i)!=0) continue;
			//아니라면 카드를 넣고, 다음 순서를 고려함
			cur_inn[cnt] = inn[i];
			permutation(cnt+1,flag | 1<<i);
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
        	//전역변수 초기화
        	win=0;
        	lose=0;
        	gyu = new int[9];
        	inn = new int[9];
        	cur_inn = new int[9];
        	//i번째 인덱스가 참이라면, 그 번호 카드는 규영이에게 뽑혔음
        	boolean[] cards = new boolean[19];
        	
        	//규영이의 카드 정보 받기
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<9;i++) {
        		gyu[i] = Integer.parseInt(st.nextToken());
        		cards[gyu[i]] = true;
        	}
        	
        	//남은 카드 인영이가 가져가기
        	int idx=1;
        	for(int i=0;i<9;i++) {
        		while(cards[idx]) idx++;
        		inn[i] = idx++;
        	}
        	
        	//인영이가 카드 내는 순서를 고려하고, 승패 계산하기
        	permutation(0,0);
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(win).append(' ').append(lose).append('\n');
        	
        }
        //출력
        System.out.printf(sb.toString());
    }
}