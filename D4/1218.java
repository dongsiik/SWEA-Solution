// 제목 : [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
// 메모리 :  18,184 kb
// 실행시간 : 106 ms

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = 10;
        		//Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//문자열의 길이와 문자열 입력
        	int len = Integer.parseInt(br.readLine());
        	String s = br.readLine();
        	
        	//최근에 연 괄호를 저장할 스택 chk와, 짝이 맞는지를 저장할 answer
        	Stack<Character> chk = new Stack<>();
        	int answer=1;
        	
        	//문자열의 앞부터 문자 검색
        	for(int i=0;i<len && answer==1;i++) {
        		//현재 문자
        		char c1 = s.charAt(i);
        		//여는 괄호라면 스택에 추가
        		if(c1=='(' || c1=='[' || c1=='<' || c1=='{') chk.push(c1);
        		//아니라면(==닫는 괄호라면)
        		else {
        			//전에 열린 괄호가 없으면 짝이 안 맞음
        			if(chk.empty()) answer=0;
        			//전에 열린 괄호가 제 짝이 맞는지 검사
        			else {
        				char c2 = chk.pop();
        				switch(c1) {
        				case ')':
        					if(c2!='(') answer=0;
        					break;
        				case '}':
        					if(c2!='{') answer=0;
        					break;
        				case ']':
        					if(c2!='[') answer=0;
        					break;
        				case '>':
        					if(c2!='<') answer=0;
        					break;
        				}
        			}
        		}
        	}
        	//열린 괄호가 모두 닫혔는지 확인
        	if(!chk.empty()) answer=0;
        	
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	}
        //출력
        System.out.print(sb.toString());
    }
}