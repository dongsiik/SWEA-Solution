// 제목 : 상원이의 연속 합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWoEzJFa2A4DFARq
// 메모리 :  20,172 kb
// 실행시간 : 772 ms

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
        	//n을 입력받음
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            //m부터 k+1개의 수의 합이 n이 될수 있는지 검사
            for(int m=1;m<=n;m++) {
                int k=0;
                while(true) {
                    int sum = ((2*m+k)*(k+1))/2;
                    if(sum==n) answer++;
                    if(sum>n) break;
                    k++;
                }
            }
             
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}