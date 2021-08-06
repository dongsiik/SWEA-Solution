// 제목 : 늘어지는 소리 만들기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRKWITqfvIDFAV8
// 메모리 :  34,216 kb
// 실행시간 : 175 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
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
        	//늘어지는 소리를 집어넣을 문자열을 조작하기 편한 StringBuilder로 만듦
        	StringBuilder sb_t = new StringBuilder(br.readLine());
        	
        	//하이픈의 개수와, 하이픈의 위치들을 입력받음
        	int h = Integer.parseInt(br.readLine());
        	int[] hs = new int[h];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0;i<h;i++) hs[i] = Integer.parseInt(st.nextToken());
        	
        	//오름차순 정렬, 인덱스를 뒤에서 접근해서 내림차수능로 쓸 예정(Integer[] hs로 선언하면 내림차순으로 정렬할 수 있지만, 고치기 귀찮아서 이렇게 했음)
        	Arrays.sort(hs);
        	
        	//뒤에 있는 하이픈부터 집어넣음. 뒤에 있는 하이픈부터 넣어야 앞에서부터 밀려서 위치가 엉망이 되는 일이 없음.
        	for(int i=h-1;i>=0;i--) sb_t.insert(hs[i], '-');
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(sb_t).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}