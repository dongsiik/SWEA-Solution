// 제목 : 주혁이의 복권 당첨
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWh4FhG6Ei4DFAXp
// 메모리 :  26,764 kb
// 실행시간 : 134 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static int T;
    static String[] dang;	//복권 당첨 번호들
    static int[] money;		//당첨시 당첨금들
     
    //복권 번호를 매개변수로 받아 당첨되었으면 그 복권의 당첨금을 반환함
    public static int judge(String bok) {
    	//당첨 번호의 개수
        int n = dang.length;
        //당첨 번호들마다
        for(int i=0;i<n;i++) {
            boolean chk = true;
            for(int j=0;j<8;j++) {
            	//당첨번호 자리가 *이 아니면서 당첨번호와 다르면 꽝
                if(dang[i].charAt(j)!='*' && dang[i].charAt(j)!=bok.charAt(j)) {
                    chk=false;
                    break;
                }
 
            }
            if(chk) {    	//당첨이라면 당첨금을 반환하고 종료
                return money[i];
            }
        }
         
        return 0;
    }
     
    public static void main(String args[]) throws Exception
    {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수를 입력받음
        T=Integer.parseInt(br.readLine());
 
        //각각의 테스트 케이스마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//당첨번호와 복권번호 개수를 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
             
            dang = new String[n];
            money = new int[n];
             
            //당첨번호와 당첨금 저장
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                dang[i] = st.nextToken();
                money[i] = Integer.parseInt(st.nextToken());
            }
             
            //복권 번호를 입력받고, 당첨금 누적합을 구함
            int answer = 0;
            for(int i=0;i<m;i++) {
                String bok = br.readLine();
                answer += judge(bok);
            }
             
            //결과문 저장
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.println(sb);
    }
}