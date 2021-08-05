// 제목 : 햄버거 다이어트
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
// 메모리 :  20,436 kb
// 실행시간 : 222 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
class Solution
{
	//전역변수들
	static int n;	//재료 수
	static int l;	//칼로리 제한
	static int[] cal;	//버거 재료별 칼로리
	static int[] point;	//버거 재료별 점수
	static int cur_cal;	//현재 고려중인 버거의 칼로리
	static int cur_point;//현재 고려중인 버거의 점수
	static int max;	//지금까지 본 버거 중 최고 점수
	
	//재귀적으로 pos번째 번호 재료를 넣어보고 빼서 견적을 내보는 함수
	public static void subset(int pos) {
		//기존의 버거가 칼로리 한도 이하라면 최고점수 비교 후갱신
		if(cur_cal<l) max = Math.max(max, cur_point);
		//버거 재료를 다 고민하지 않았다면
		if(pos <n) {
			//이 재료를 넣어서 칼로리와 점수를 계산하고 다음 번호 재료 고려
			cur_cal +=cal[pos];
			cur_point +=point[pos];
			subset(pos+1);
			//이 재료를안 넣고 다음 번호 재료 고려
			cur_cal -=cal[pos];
			cur_point -=point[pos];
			subset(pos+1);
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
        	//재료 수, 칼로리 한도
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	l = Integer.parseInt(st.nextToken());
        	
        	//재료별 칼로리, 점수
        	cal = new int[n];
        	point = new int[n];
        	
        	//전역변수 초기화
        	max = -1;
        	cur_cal=0;
        	cur_point=0;
        	
        	//재료별 정보 입력
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		point[i] = Integer.parseInt(st.nextToken());
        		cal[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	//0번째 재료부터 고려 시작
        	subset(0);
        	
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(max).append('\n');
        	
        }   

        //출력
        System.out.print(sb.toString());
    }
}