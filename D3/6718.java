// 제목 : 희성이의 원근법
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWd7qcdatpEDFAUh
// 메모리 :  37,604 kb
// 실행시간 : 193 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 경우마다
        for(int t=1;t<=T;t++) {
        	
        	//거리(m)를 입력받은 후, 로그를 이용해서 답을 구함
        	int d = Integer.parseInt(br.readLine());
        	int answer = (int)Math.log10(d)-1;
        	if(answer<0) answer=0;
        	if(answer>5) answer=5;

        	//결과 저장
        	sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}