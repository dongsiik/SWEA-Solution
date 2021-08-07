// 제목 : 시간 개념
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDLM0aRA8DFARG
// 메모리 :  18,264 kb
// 실행시간 : 102 ms

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
        	//현재 시각의 시,분,초
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
             
            //약속 시간의 시,분,초
            st = new StringTokenizer(br.readLine(), ":");
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
             
            //현재 시각이 더 크다면, 약속시간은 다음날이므로 약속시간 시에 24를 더함
            if(h1>h2 || (h1==h2)&&(m1>m2) || (h1==h2)&&(m1>m2)&&(s1>s2)) h2 += 24;
             
            //차이를 구함
            int h3 = h2-h1;
            int m3 = m2-m1;
            int s3 = s2-s1;
             
            if(s3<0) {
                s3+=60;
                m3--;
            }
            if(m3<0) {
                m3+=60;
                h3--;
            }
             
            //일의 자리 수일때, 두 자리로 출력하기 위한 변환
            String H3="";
            if(h3<10) H3=H3.concat("0").concat(Integer.toString(h3));
            else H3=H3.concat(Integer.toString(h3));
             
            String M3="";
            if(m3<10) M3=M3.concat("0").concat(Integer.toString(m3));
            else M3=M3.concat(Integer.toString(m3));
             
            String S3="";
            if(s3<10) S3=S3.concat("0").concat(Integer.toString(s3));
            else S3=S3.concat(Integer.toString(s3));
             
             //출력문 저장
            sb.append('#').append(t).append(' ').append(H3).append(':').append(M3).append(':').append(S3).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}