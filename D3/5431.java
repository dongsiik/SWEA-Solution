// 제목 : 민석이의 과제 체크하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl3rWKDBYDFAXm
// 메모리 :  28,076 kb
// 실행시간 : 135 ms

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
        
        int T;	//테스트 케이스 수
        T = Integer.parseInt(br.readLine());
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//전체 학생 수와 과제 낸 학생 수 입력받음
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	//과제 냈는지를 기록할 배열을 만들고, 과제를 냈다면 true로 표시
        	boolean[] hw = new boolean[n+1];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<k;i++) {
        		int a = Integer.parseInt(st.nextToken());
        		hw[a] = true;
        	}
        	
            //기본 출력문과, 과제 안 낸 학생들의 번호를 출력문에 기록
            sb.append('#').append(test_case).append(' ');     	
        	for(int i=1;i<=n;i++) {
        		if(!hw[i]) sb.append(i).append(' ');
        	}
        	sb.setLength(sb.length()-1);
        	sb.append('\n');
        	            
        }
        //출력
        System.out.printf(sb.toString());
    }
}