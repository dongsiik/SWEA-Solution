// 제목 : 다양성 측정
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWq40NEKLyADFARG
// 메모리 :  18,612 kb
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
        	//확인할 숫자를 문자열로 입력받음
            char[] str = br.readLine().toCharArray();
            //0~9사이이 숫자가 나왔는지 저장할 배열
            boolean[] dup = new boolean[10];
            int answer=0;
             
            //배열 검사
            for(int i=0;i<str.length;i++) {
                dup[str[i]-'0']=true;
            }
             
            //나온 숫자만큼 정답값 증가
            for(int i=0;i<10;i++) {
                if(dup[i]) answer++;
            }
            //출력문 저장
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}