// 제목 : 세상의 모든 팰린드롬 2
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQAz7IqAH8DFAWh
// 메모리 :  18,640 kb
// 실행시간 : 100 ms

//9:12 시작, 9:28 통과

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	//팰린드롬인지 검사할 문자열과, 판단 결과를 저장할 문자열
	public static String s;
	public static String answer;
	
	//팰린드롬인지 확인해주는 함수
	public static void isPalindrome() {
		//왼쪽, 오른쪽에서 각각 제일 가까운 별 위치 확인
		int leftStar = s.indexOf('*');
		int rightStar = s.lastIndexOf('*');
		
		//별이 하나도 없다면, 왼쪽끝과 오른쪽 끝부터 비교해서 판단
		if(leftStar==-1) {
			for(int i=0;i<s.length()/2;i++) {
				if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
					answer="Not exist";
					return;
				}
			}
			answer="Exist";
			return;
		}
		//별이 있다면, 그 별 바깥은 대칭으로 못 만들어도 별 안쪽부터는 대칭으로 만들 수 있으므로, 가장 바깥 별을 찾아 그 바깥이 대칭인지 검사
		else {
			int outerStar = Math.min(leftStar, s.length()-1-rightStar);
			for(int i=0;i<outerStar;i++) {
				if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
					answer="Not exist";
					return;
				}
			}
			answer="Exist";
			return;
		}
	}
	
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//전역변수 초기화 후 검사
        	s = br.readLine();
        	answer="";
        	isPalindrome();
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.printf(sb.toString());
    }
}