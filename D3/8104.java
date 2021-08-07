// 제목 : 조 만들기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWwXCn2KQjEDFATu
// 메모리 :  20,416 kb
// 실행시간 : 113 ms

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
        	//조당 인원, 조의 수 입력받기
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            //n과 k값에 따른 출력문 저장
            int answer = (1+(n/2)*2*k)*(n/2);
            sb.append('#').append(t).append(' ');
            if(n%2==0) {
            	for(int i=0;i<k;i++) sb.append(answer).append(' ');
            	sb.append('\n');
            }
            else {
            	answer+=(n-1)*k+1;
            	for(int i=0;i<k;i++) sb.append(answer++).append(' ');
            	sb.append('\n');
            }

        }
         //출력
        System.out.print(sb.toString());
    }
}