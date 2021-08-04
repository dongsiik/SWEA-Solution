// 제목 : 시험
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW45RuSae2gDFAQ7
// 메모리 :  143,048 kb
// 실행시간 : 1,233 ms

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	//테스트 케이스 수
        int T;
        T=Integer.parseInt(br.readLine());
         
        //테스트 케이스 마다 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//인원수, 문제수, 지학이의 번호를 입력받음
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
             
            int[][] info = new int[n][t];	//인원별로 문제를 풀었나 못 풀었나
            int[] problem = new int[t];		//문제별 못 푼 사람의 수  = 문제별 점수
            int[] score = new int[n];		//사람별 총점수
            int[] number = new int[n];		//사람별 푼 문제 수
            int answer=1;
            
            for(int i=0;i<n;i++) {
            	//시험 정보를 입력받음. 만약에 못 푼 경우에는 그 문제의 점수를 하나 올림
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<t;j++) {
                	info[i][j] = Integer.parseInt(st.nextToken());
                	if(info[i][j]==0) problem[j]++;
                }
            }
             
            //사람별로 문제를 맞췃을 경우 총점과 푼 문제수를 늘려줌
            for(int i=0;i<n;i++) {
                for(int j=0;j<t;j++) {
                    if(info[i][j]==1) {
                        number[i]++;
                        score[i]+=problem[j];
                    }
                }
            }
             
            //다른 사람과 비교해서 총점이 높거나, 총점이 같은데 푼 문제수가 많거나, 총점과 푼 문제 수가 같은데 번호가 앞서면 등수의 숫자를 하나 올림
            for(int i=0;i<n;i++) {
                if(i==(p-1)) continue;
                if(score[i]>score[p-1]) answer++;
                else if(score[i]==score[p-1] && number[i]>number[p-1]) answer++;
                else if(score[i]==score[p-1] && number[i]==number[p-1] && i<p-1) answer++;
            }
             
            //결과 저장
            sb.append('#').append(test_case).append(' ').append(score[p-1]).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.print(sb.toString());
   }
}