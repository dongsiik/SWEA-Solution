// 제목 : 의석이의 세로로 말해요
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO
// 메모리 :  19,868 kb
// 실행시간 : 117 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
{
 
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T;	//테스트 케이스 수
        T = Integer.parseInt(br.readLine());
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = 5;
            //문자열 다섯개를 위한 ArrayList
            ArrayList<String> strs = new ArrayList<>();
            int MaxLen =-1;
            
            //문자열을 입력받으며, 가장 긴 길이를 기록
            for(int i=0;i<n;i++) {
            	String s = br.readLine();
            	if(s.length()>MaxLen) MaxLen=s.length();
            	strs.add(s);
            }
            
            //출력문 기본값
            sb.append('#').append(test_case).append(' ');
            //세로로 읽기 시작, 빈 칸이 있다면 건너뛰고 아니라면 출력문에 저장
            for(int j=0;j<MaxLen;j++) {
            	for(int i=0;i<n;i++) {
            		if(strs.get(i).length()>j) sb.append(strs.get(i).charAt(j));
            	}
            }
            sb.append('\n');
            
        }
        //출력
        System.out.printf(sb.toString());
    }
}