// 제목 : 문제 제목 붙이기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIdD46A5EDFAXC
// 메모리 :  19,436 kb
// 실행시간 : 104 ms

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
        	//문제 제목 수
            int n = Integer.parseInt(br.readLine());
            //어떤 알파벳으로 시작하는 문제가 나왔는지를 저장할 배열
            boolean[] chk = new boolean[26];
             
            //제목 첫 글자를 보고, 그 알파벳 제목이 나왔다고 기록
            for(int i=0;i<n;i++) {
                char c = br.readLine().charAt(0);
                chk[c-'A'] = true;
            }
            int idx = 26;
            //알파벳을 처음부터 보면서 안 나온 문자열 제목이 있으면 그만둠
            for(int i=0;i<26;i++) {
                if(chk[i]==false) {
                    idx = i;
                    break;
                }
            }
            //출력문 저장
            sb.append('#').append(t).append(' ').append(idx).append("\n");
        }
         //출력
        System.out.print(sb.toString());
    }
}