// 제목 : 다솔이의 월급 상자
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWdXofhKFkADFAWn
// 메모리 :  30,248 kb
// 실행시간 : 153 ms

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
        
        //각각의 경우마다
        for(int t=1;t<=T;t++) {
        	
        	//상자 수
        	int n = Integer.parseInt(br.readLine());
        	
        	//월급 총합
        	double answer = 0;
        	
        	for(int i=0;i<n;i++) {
        		//각각의 상자마다 기댓값을 구해 총합에 더함
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		double p = Double.parseDouble(st.nextToken());
        		int x = Integer.parseInt(st.nextToken());
        		
        		answer+= p*x;
        	}
        	//결과 저장
        	sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}