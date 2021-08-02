// 제목 : 다트 게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXZuaLsqz9wDFAST
// 메모리 :  93,824 kb
// 실행시간 : 399 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
    	//입력을 읽어올 br와 모아서 출력할 결과를 저장할 sb
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	//테스트 케이스 수 입력받기
    	int T;
        T=Integer.parseInt(br.readLine());
 
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//화살 개수 입력받기
            int n = Integer.parseInt(br.readLine());
            
            //총점을 저장할 변수
            int score = 0;
            
            //각각 화살에 대하여
            for(int i=0;i<n;i++) {
            	//st로 한 줄을 읽어온 후, x좌표와 y좌표로 나눔
            	StringTokenizer st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	
            	//화살이 원점에서부터 얼마나 떨어져있는지 계산
                int r2 = (x*x+y*y);
                
                //거리에 따라 점수 추가
                for(int j=1;j<=10;j++) {
                    if(r2<=((400*j)*j)) {
                        score += (11-j);
                        break;
                    }
                }
            }
             
            //sb에 출력할 문장 저장
            sb.append('#').append(test_case).append(' ').append(score).append('\n');
 
        }
        //출력
        System.out.println(sb);
    }
}