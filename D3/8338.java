// 제목 : 계산기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWxpQia60FgDFAWL
// 메모리 :  97,188 kb
// 실행시간 : 286 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        //테스트 케이스 마다
        for(int t=1;t<=T;t++) {
        	//숫자 갯수 입력받기
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
             
            //왼쪽 항과 오른쪽 항이 1 이하라면 더하고, 아니라면 곱함
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                int a = Integer.parseInt(st.nextToken());
                if(a<=1 || sum<=1) sum+=a;
                else sum*=a;
            }
             
            //출력문 저장
            sb.append('#').append(t).append(' ').append(sum).append('\n');
        }
         //출력
        System.out.println(sb);
    }
}