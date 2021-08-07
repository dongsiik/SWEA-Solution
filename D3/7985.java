// 제목 : Rooted Binary Tree 재구성
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWu1JmN6Js4DFASy
// 메모리 :  18,316 kb
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
        	//트리의 높이 입력받기
            int k = Integer.parseInt(br.readLine());
            int len = (int)Math.round(Math.pow(2, k));

            //노드별로 숫자를 입력받을 배열을 만들어서 입력받음
            int[] arr = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<len;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            //출력문 앞부분
            sb.append('#').append(t).append(' ');
            
            //레벨별로 숫자 위치에 규칙이 있으므로, 그것을 활용하여 출력문 저장
            int start = len/2;
            int step = len;
             
            for(int i=0;i<k;i++) {
                int pos = start;
                while(pos<len) {
                     
                    sb.append(arr[pos]).append(' ');
                    pos +=step;
                }
                sb.append('\n');
                start /=2;
                step /=2;
            }
        }
         //출력
        System.out.print(sb.toString());
    }
}