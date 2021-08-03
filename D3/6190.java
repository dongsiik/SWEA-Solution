// 제목 : 정곤이의 단조 증가하는 수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWcPjEuKAFgDFAU4
// 메모리 :  36,732 kb
// 실행시간 : 345 ms

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Solution
{
	//두 수의 곱이 단조증가하는 수인지 확인하는 함수
	public static boolean mono(int x, int y) {
		//두 수를 곱하고, 그 수의 자리수를 구함
		int a = x*y;
		int digit = (int)Math.log10(a);
		
		//한자리 수라면 단조증가임(문제에 명확히 주어지진 않았지만, 그렇다고 하였음)
		if(digit==0) return true;
		//아니라면 오른쪽부터 두 자리씩 비교
		else {
			for(int i=0;i<digit;i++) {
				int right = a%10;
				a /= 10;
				int left = a%10;
				if(left>right) return false;
			}
		}
		
		return true;
	}
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//숫자 n개를 입력받아 정렬
        	int n = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	int[] arr = new int[n];
        	for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        	Arrays.sort(arr);
        	
        	int answer=-1;
        	
        	//뒤에서부터 단조증가 하는 수 인지 확인
        	for(int i=n-2;i>=0;i--) {
        		//중요한 건 최댓값이므로, 단조증가더라도 현재 최댓값보다 작으면 더 이상 찾지 않음
        		if(arr[i]*arr[n-1]<answer) break;
        		for(int j=n-1;j>i;j--) {
        			if(arr[i]*arr[j]<answer) break;
        			if(mono(arr[i],arr[j])) answer = Math.max(answer, arr[i]*arr[j]);
        		}
        	}
        	//출력문 저장
        	sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        	}
        //출력
        System.out.printf(sb.toString());
    }
}