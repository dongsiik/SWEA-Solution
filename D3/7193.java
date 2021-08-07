// 제목 : 승현이의 수학공부
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWksRkI6AR0DFAVE
// 메모리 :  136,416 kb
// 실행시간 : 523 ms

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
        	//문자열의 길이와 문자열을 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
             
            //자리수별로 값을 모두 더한 다음 n-1로 나누면 정답이 됨
            long answer=0;
             
            for(int i=0;i<s.length();i++) {
                answer += s.charAt(i)-'0';
            }
             
            answer %= (n-1);
             
            //출력문 저장
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}