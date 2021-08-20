// 제목 : [S/W 문제해결 기본] 6일차 - 계산기2
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD
// 메모리 :  18,640 kb
// 실행시간 : 104 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
  
class Solution
{
	
	public static void main(String args[]) throws IOException
    {
		//빠른 입출력을 위한 BufferedReader br과 StringBuilder answerSheet
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerSheet = new StringBuilder();
        
        //테스트 케이스 수
        int T = 10; //Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//테스트 케이스의 길이
        	int length = Integer.parseInt(br.readLine());
        	//원본 계산식
        	String source = br.readLine();
        	
        	//후위 문자열로 바꾸는 과정을 도와줄 StringBuilder translater
        	StringBuilder translater = new StringBuilder();
        	//더하기는 연산자 우선순위가 낮으므로, 등장하면 가지고만 있다가 최대한 미뤄서 넣을 예정
        	boolean existenceOfPlus = false;
        	
        	for(int i=0;i<length;i++) {
        		//원본 문자열 i번째에 있는 문자 읽기
        		char c = source.charAt(i);
        		
        		//숫자라면 그대로 집어넣음
        		if(Character.isDigit(c)) translater.append(c);
        		//곱하기라면, 그 다음에 있는 숫자와 자리를 바꾸어서 집어넣음
        		else if(c=='*') {
        			translater.append(source.charAt(i+1)).append(c);
        			i++;
        		}
        		//더하기라면
        		else {
        			//전에 더하기가 나왔다면, 그 더하기를 지금 하면 됨
        			if(existenceOfPlus) translater.append(c);
        			//아니라면 더하기가 있다고 표시
        			else existenceOfPlus = true;
        		}
        	}
        	//더하기가 있었다면 마지막으로 하면 됨
        	if(existenceOfPlus) translater.append('+');
        	
        	
        	//후위 표기식으로 바꾼 문자열
        	String destination = translater.toString();
        	
        	//후위문자열로 계산하기 위한 스택
        	Stack<Integer> calculator = new Stack<>();
        	
        	for(int i=0;i<length;i++) {
        		//후위 표기식의 i번째에 있는 문자 읽기
        		char c = destination.charAt(i);
        		
        		//숫자라면 숫자로 바꿔서 집어넣기
        		if(Character.isDigit(c)) calculator.push(c-'0');
        		//연산자라면 전에 있던 두 개를 빼서 연산하고 다시 집어넣기
        		else if(c=='*') {
        			int left = calculator.pop();
        			int right = calculator.pop();
        			calculator.push(left*right);
        		}
        		else {
        			int left = calculator.pop();
        			int right = calculator.pop();
        			calculator.push(left+right);
        		}
        	}
        	
        	//스택에 남은 하나가 최종 결과임
        	int answer = calculator.pop();
        	
        	//출력문 저장
        	answerSheet.append('#').append(test_case).append(' ').append(answer).append('\n');
        	
        }
        //출력
        System.out.printf(answerSheet.toString());
    }
}