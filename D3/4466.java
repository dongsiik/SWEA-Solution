// 제목 : 최대 성적표 만들기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWOUfCJ6qVMDFAWg
// 메모리 :  25,168 kb
// 실행시간 : 131 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
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
        	//과목의 개수와 성적표에 넣을 과목 개수
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	//과목을 넣을 자리로 Integer[]을 만들고 성적을 넣고, 내림차순 정렬
        	Integer[] scores = new Integer[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) scores[i] = Integer.parseInt(st.nextToken());
        	Arrays.sort(scores,Collections.reverseOrder());
        	
        	//앞에서부터 k개를 넣어 최고성적을 만듦
        	int answer=0;
        	for(int i=0;i<k;i++) answer +=scores[i];
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}