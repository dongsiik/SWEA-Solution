// 제목 : 전봇대
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXO8QBw6Qu4DFAXS
// 메모리 :  32,312 kb
// 실행시간 : 245 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb =  new StringBuilder();
        int T;	//테스트 케이스 수
        T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//전선의 개수를 입력받고, 정보를 저장할 배열 선언
            int n =Integer.parseInt(br.readLine());
            int[][] lines = new int[n][2];
            int sum=0;
             
            //전선 정보 저장
            for(int i=0;i<n;i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                lines[i][0] = Integer.parseInt(st.nextToken());
                lines[i][1] = Integer.parseInt(st.nextToken());
            }
             
            //지금 전선보다 다음 전선이 x좌표가 크고 y좌표가 작거나, x좌표가 작고 y좌표가 크면 겹침
            for(int i=0;i<n;i++) {
                for(int j=i;j<n;j++) {
                    if(lines[i][0]>lines[j][0] && lines[i][1]<lines[j][1]) sum++;
                    if(lines[i][0]<lines[j][0] && lines[i][1]>lines[j][1]) sum++;
                }
            }
             
            //결과 저장
            sb.append('#').append(test_case).append(' ').append(sum).append('\n');
        }
        
        //결과 출력
        System.out.println(sb);
    }
}