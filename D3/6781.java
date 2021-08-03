// 제목 : 삼삼 트리플 게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqpQV6r8gDFAW0
// 메모리 :  19,648 kb
// 실행시간 : 110 ms

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
 
        //각각의 테스트 케이스마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//카드 정보를 저장할 배열과 남은 카드
            int[][] cards = new int[3][10];
            int resCards = 9;
            
            //카드 정보를 입력받고 저장
            String nums = br.readLine();
            String colors = br.readLine();
            for(int i=0;i<9;i++) {
            	if(colors.charAt(i)=='R') cards[0][nums.charAt(i)-'0']++;
            	if(colors.charAt(i)=='G') cards[1][nums.charAt(i)-'0']++;
            	if(colors.charAt(i)=='B') cards[2][nums.charAt(i)-'0']++;
            }
            
            //세트 3개를 만들 수 있는지 검사 : 같은 숫자가 4개 있다면 같은 숫자 세트를 만들고, 남은 카드로 연속 숫자 세트를 만들고, 다시 남은 카드로 같은 숫자 세트를 만듦
            outer : for(int i=0;i<=2;i++) {
            	for(int j=1;j<=9;j++) {
            		//어떤 카드가 4장 있다면, 연속된 숫자 세트를 만드는 데에 기껏해야 한 장만 쓰일 거임
            		if(cards[i][j]==4) {
            			cards[i][j]=1;
            			resCards -= 3;
            		}
            	}
            	//연속된 숫자 세트를 만들 수 있는지 검사
            	for(int j=1;j<=7;j++) {
            		int card = cards[i][j];
            		if(card!=0 && cards[i][j+1]>=card && cards[i][j+2]>=card) {
            			cards[i][j+1] -= card;
            			cards[i][j+2] -= card;
            			resCards -= 3*card;
            			if(resCards==0) break outer;
            		}
            	}
            	//남은 카드는 같은 숫자 3개 세트로 만들 수 있는지 확인
            	for(int j=1;j<=9;j++) {
            		if(cards[i][j]==3) {
            			cards[i][j]=0;
            			resCards -= 3;
            			if(resCards==0) break outer;
            		}
            	}
            	
            }
            
            //출력문 저장
            sb.append('#').append(test_case).append(' ');
            if(resCards==0) sb.append("Win\n");
            else sb.append("Continue\n");
        }
        //출력
        System.out.println(sb);
    }
}