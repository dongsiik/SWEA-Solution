// 제목 : 세영이의 SEM력 연도
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWooplJ60l8DFARx
// 메모리 :  25,940 kb
// 실행시간 : 132 ms

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
        	//S,E.M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
             
            int year=s;
             //반복문을 돌면서 나머지로 이게 가능한 연도 계산
            while(true) {
                if(year%24==e%24 && year%29==m%29) break;
                year += 365;
            }
             //출력문 저장
            sb.append('#').append(t).append(' ').append(year).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}