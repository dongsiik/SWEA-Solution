// 제목 : 장애물 경주 난이도
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWefy5x65PoDFAUh
// 메모리 :  20,728 kb
// 실행시간 : 115 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스마다
        for(int t=1;t<=T;t++) {

        	//블록의 수를 입력받고, 그만큼 배열을 만든 다음, 높이를 입력받음
        	int n = Integer.parseInt(br.readLine());
        	int[] block = new int[n];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) block[i] = Integer.parseInt(st.nextToken());

        	//올라갈때, 내려갈때 가장 심한 높이 변화를 기록할 변수들
        	int high = 0;
        	int low = 0;
        	
        	//전칸과 앞칸을 비교해서 높이변화를 비교 후 필요하다면 갱신
        	for(int i=0;i<n-1;i++) {
        		int diff = block[i]-block[i+1];
        		if(diff<0) high = Math.max(high, -diff);
        		else low = Math.max(low, diff);
        	}

        	//결과 저장
        	sb.append('#').append(t).append(' ').append(high).append(' ').append(low).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}