// 제목 : [S/W 문제해결 기본] 1일차 - Flatten
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
// 메모리 :  17,424 kb
// 실행시간 : 110 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = 10;
  
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//높이에 따른 상자 개수를 저장할 배열
        	int[] box = new int[101];

        	//덤프 횟수
        	int num = Integer.parseInt(br.readLine());
        	
        	//박스 정보를 입력받아 저장
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	while(st.hasMoreTokens()) {
        		box[Integer.parseInt(st.nextToken())]++;
        	}
        	
        	//가장 높이가 낮은 박스, 높은 박스의 높이 찾기
        	int m=1;
        	int M=100;
        	for(int i=1;i<=100;i++) {
        		if(box[i]!=0) {
        			m = i;
        			break;
        		}
        	}
        	for(int i=100;i>0;i--) {
        		if(box[i]!=0) {
        			M = i;
        			break;
        		}
        	}
        	
        	//덤프 작업
        	for(int i=1;i<=num;i++) {
        		//높이차이가 1 이하라면 해봤자 뻘짓이므로 중단
        		if(M-m<=1) break;
        		//높은 박스에서 하나를 빼서 낮은 박스에 두고, 가장 높은 높이와 낮은 위치를 적절히 조절
        		box[M]--;
        		box[M-1]++;
        		if(box[M]==0) M = M-1;
        		box[m]--;
        		box[m+1]++;
        		if(box[m]==0) m = m+1;
        	}
        	
            //경우를 나누어 결과문 저장
            sb.append('#').append(test_case).append(' ').append(M-m).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}