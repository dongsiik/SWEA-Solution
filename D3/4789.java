// 제목 : 성공적인 공연 기획
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2dSgKA8MDFAVT
// 메모리 :  20,892 kb
// 실행시간 : 117 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
class Solution
{

	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
       
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	String s = br.readLine();	//관객의 성향 정보 입력받기
        	int answer=0;				//고용해야할 사람 수
        	int len = s.length();		//성향 정보의 길이
        	int sum=0;					//i단계 이전에서 기립박수 치고 있을 사람 수
        	
        	for(int i=0;i<len;i++) {
        		int num = s.charAt(i)-'0';	//i-1명 이상 기립박수하고 있을 때 따라서 박수칠 사람 수
        		if(i>sum+answer) answer=(i-sum);	//사람이 부족하다면, 고용할 사람 수를 재조정
        		sum += num;		//기립박수를 치고 있는 사람들 수를 갱신
        	}
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }   

        //출력
        System.out.print(sb.toString());
    }
}