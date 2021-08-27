// 제목 : 의석이의 세로로 말해요
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO
// 메모리 :  19,764 kb
// 실행시간 : 114 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
           String[] strs = new String[5];
            int MaxLen =-1;
            
            for(int i=0;i<n;i++) {
            	String s = br.readLine();
            	if(s.length()>MaxLen) MaxLen=s.length();
            	strs[i] = s;
            }
            
            sb.append('#').append(test_case).append(' ');
            for(int j=0;j<MaxLen;j++) {
            	for(int i=0;i<n;i++) {
            		if(strs[i].length()>j) sb.append(strs[i].charAt(j));
            	}
            }
            sb.append('\n');
            
        }
        System.out.printf(sb.toString());
    }
}
