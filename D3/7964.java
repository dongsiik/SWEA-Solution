// 제목 : 부먹왕국의 차원 관문
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy
// 메모리 :  86,788 kb
// 실행시간 : 239 ms

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
        	StringTokenizer st = new StringTokenizer(br.readLine());
            //도시 수, 이동제한 거리
        	int n = Integer.parseInt(st.nextToken())+2;
            int d = Integer.parseInt(st.nextToken());
             
            //맨 앞과 맨 끝에는 차원관문이 있다고 쳐서 앞뒤에 1을 더한 스트링으로 차원관문 정보를 저장
            String str = "1".concat(br.readLine()).concat("1");
            str = str.replaceAll(" ","");
            int answer=0;
            int start=0;
            //관문 사이의 거리를 구하고 d로 나누어서 새로 지을 관문 수를 갱신
            while(true) {
                int end = str.indexOf('1',start+1);
                if(end==-1) break;
                answer += (end-start-1)/d;
                start = end;
            }
            //출력문 저장
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}