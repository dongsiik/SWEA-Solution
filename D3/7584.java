// 제목 : 자가 복제 문자열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWpMsQfaCPMDFAQi
// 메모리 :  17,692 kb
// 실행시간 : 106 ms

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
        	//k번째 위치를 나타내는 k. 상한선이 10^18이므로 long으로 받음
            Long k = Long.parseLong(br.readLine())-1;
            int answer = 0;
            //규칙에 따라 k 계산
            while(k>0) {
                if(k%2==1) {
                    k = (k-1)/2;
                }
                if(k%4==0) {
                    answer = 0;
                    break;
                }
                if(k%2==0) {
                    answer=1;
                    break;
                }
            }
             //출력문 저장
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}