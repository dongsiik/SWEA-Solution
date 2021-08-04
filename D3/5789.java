// 제목 : 현주의 상자 바꾸기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=
// 메모리 :  52,500 kb
// 실행시간 : 289 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
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
        	//상자 수, 작업 수를 입력받음
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int q = Integer.parseInt(st.nextToken());
        	
        	//상자들의 배열 생성, 인덱스를 1부터 n개 쓸 것이므로 n+1칸
        	int[] boxes = new int[n+1];
        	
        	for(int i=1;i<=q;i++) {
        		//l과 r을 입력받아 숫자 새기기
        		st = new StringTokenizer(br.readLine());
            	int l = Integer.parseInt(st.nextToken());
            	int r = Integer.parseInt(st.nextToken());
            	for(int j=l;j<=r;j++) boxes[j] = i;
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ');
        	
        	for(int i=1;i<=n;i++) sb.append(boxes[i]).append(' ');
        	sb.setLength(sb.length()-1);
        	sb.append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}