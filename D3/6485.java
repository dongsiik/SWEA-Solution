// 제목 : 삼성시의 버스 노선
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn
// 메모리 :  21,484 kb
// 실행시간 : 122 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
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
        	//버스정류장 별 지나가는 노선 수
        	int[] busstop = new int[5001];

        	//노선 수를 입력받아, 그 사이에 있는 정류장에 지나가는 노선 수를 추가함
        	int n = Integer.parseInt(br.readLine());
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		for(int j=start;j<=end;j++) busstop[j]++;
        	}

        	//출력문 앞부분 저장
        	sb.append('#').append(test_case).append(' ');
        	
        	//출력할 버스정류장 수와 번호를 지정받아 출력문 저장
        	int p = Integer.parseInt(br.readLine());
        	for(int i=0;i<p;i++) {
        		int c = Integer.parseInt(br.readLine());
        		sb.append(busstop[c]).append(' ');
        	}
        	sb.setLength(sb.length()-1);
        	sb.append('\n');
        	}
        //출력
        System.out.printf(sb.toString());
    }
}