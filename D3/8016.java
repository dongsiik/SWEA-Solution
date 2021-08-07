// 제목 : 홀수 피라미드
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWvzGUKKPVwDFASy
// 메모리 :  18,532 kb
// 실행시간 : 101 ms

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
        	//n값 입력받기
            long n = Integer.parseInt(br.readLine());
            //계차수열로 계산한 결과
            long left = 2*n*n-4*n+3;
            long right = 2*n*n-1;
             
            sb.append('#').append(t).append(' ').append(left).append(' ').append(right).append('\n');

        }
         //출력
        System.out.print(sb.toString());
    }
}