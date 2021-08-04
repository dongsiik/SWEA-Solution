// 제목 : 농작물 수확하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
// 메모리 :  20,996 kb
// 실행시간 : 118 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//농장의 크기를 입력받아 배열을 만들었음
        	int n = Integer.parseInt(br.readLine());
        	char[][] arr = new char[n][];
        	
        	//줄별로 정보를 입력받아 배열에 저장함
        	for(int i=0;i<n;i++) {
        		String s = br.readLine();
        		arr[i] = s.toCharArray();
        	}
        	
        	//모양에 맞추어서 농작물 수확
        	int answer=0;
        	for(int i=0;i<n;i++) {
        		int tab = Math.abs(n/2-i);
        		for(int j=tab;j<n-tab;j++) answer+=arr[i][j]-'0';
        	}
        	
        	
        	//결과문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}