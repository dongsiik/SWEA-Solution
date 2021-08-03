// 제목 : 새샘이의 7-3-5 게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWZ2IErKCwUDFAUQ
// 메모리 :  66,032 kb
// 실행시간 : 274 ms

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
        	//숫자 7개를 입력받음
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] nums = new int[7];
        	for(int i=0;i<7;i++) nums[i] = Integer.parseInt(st.nextToken());
        	
        	//숫자 3개를 더해보고, 전에 없던 값이면 추가
        	List<Integer> hab = new ArrayList<>();
        	for(int i=0;i<7;i++) {
        		for(int j=i+1;j<7;j++) {
        			for(int k=j+1;k<7;k++) {
        				int sum = nums[i]+nums[j]+nums[k];
        				if(!hab.contains(sum)) hab.add(sum);
        			}
        		}
        	}
        	
        	//숫자합들을 정렬해서 5번째로 큰 값을 답으로 함
        	hab.sort(null);
        	int answer = hab.get(hab.size()-5);

        	//결과문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}