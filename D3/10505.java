// 제목 : 소득 불균형
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNP4CvauaMDFAXS
// 메모리 :  26,396 kb
// 실행시간 : 139 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb =  new StringBuilder();
    	
        int T;	//테스트 케이스 수
        T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//사람 수를 입력받고, 소득 순위를 저장할 그만한 크기의 배열을 만듦
            int n =Integer.parseInt(br.readLine());
            int[] income = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum=0;

            //각각 소득정보를 입력받고, 평균소득을 구하기 위해 총소득을 구함
            for(int i=0;i<n;i++) {
                int a = Integer.parseInt(st.nextToken());
                sum += a;
                income[i] =a;
            }
            
            //평균소득을 구하고, 소득을 오름차순으로 정렬
            double avg = (double)sum/n;
            Arrays.sort(income);
             
            //이진탐색 mid로 평균보다 큰 바로 다른 사람
            int start=0;
            int end=n-1;
            int mid = (start+end)/2;
            while(start<=end) {
                mid = (start+end)/2;
                if((income[mid]>avg && income[mid-1]<=avg)) break;
                else if(income[mid]>avg) end = mid-1;
                else if(income[mid]<=avg) start = mid+1;
            }
            if(income[0]==income[n-1]) mid = n;	//모든 사람이 소득이 같다면 위의 이진탐색에서 mid=n-1로 나오므로 예외적으로 n으로 해야함
             
            sb.append('#').append(test_case).append(' ').append(mid).append('\n'); 
        }
        System.out.println(sb);
    }
}