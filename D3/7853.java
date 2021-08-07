// 제목 : 오타
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWttUKkq5hQDFASy
// 메모리 :  18,956 kb
// 실행시간 : 109 ms

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
        int MAX = 1000000007;	//오타 수를 나눌 때 쓰라고 주어진 상수
         
        //테스트 케이스 마다
        for(int t=1;t<=T;t++) {
        	//문자열을 입력받아 char[]에 저장함
        	char[] arr = br.readLine().toCharArray();
            int len = arr.length;
            long answer = 1;
             
            //문자열이 둘 이상일 때,
            if(len>=2) {
            	//양끝 문자에서 오타낼 경우의 수
                if(arr[0]!=arr[1]) answer *= 2;
                if(arr[len-1]!=arr[len-2]) answer*=2;
                //가운데에 문자에서 오타낼 경우의 수
                for(int i=1;i<len-1;i++) {
                    if(arr[i]==arr[i-1] && arr[i]!=arr[i+1]) answer*=2;
                    if(arr[i]==arr[i+1] && arr[i]!=arr[i-1]) answer*=2;
                    if(arr[i-1]==arr[i+1] && arr[i-1]!=arr[i]) answer*=2;
                    if(arr[i-1]!=arr[i] && arr[i]!=arr[i+1] && arr[i-1]!=arr[i+1]) answer*=3;
                    answer %= MAX;
                }
            }
            //출력문 저장
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}