// 제목 : 사랑의 카운슬러
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWlQUD2qtysDFAVS
// 메모리 :  24,000 kb
// 실행시간 : 350 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
	//바로 다음으로 오름차순인 순열을 구해주는 함수
	public static boolean next_permutation(int[] arr) {
	    int n = arr.length;
	    int i=n-1;
	    while( i>0 && arr[i-1] >= arr[i] ) --i; 
	     
	    if(i==0) return false;
	     
	    int j = n-1;
	    while(arr[i-1]>=arr[j]) --j;
	     
	    int temp = arr[i-1];
	    arr[i-1] = arr[j];
	    arr[j] = temp;
	     
	    int k = n-1;
	    while(i<k) {
	        temp=arr[i];
	        arr[i]=arr[k];
	        arr[k]=temp;
	        ++i; --k;
	    }
	    return true;        
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        //테스트 케이스 마다
        for(int t=1;t<=T;t++) {
        	//지렁이 마릿수와, 지렁이들의 좌표
        	StringTokenizer st;
        	int n = Integer.parseInt(br.readLine());
        	int[][] pos = new int[n][2];
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		pos[i][0] = Integer.parseInt(st.nextToken());
        		pos[i][1] = Integer.parseInt(st.nextToken());
        	}

        	//지렁이 짝마다 거리를 비교하며 최솟값을 저장할 min_dis
        	long min_dis = Long.MAX_VALUE;
        	//지렁이들을 짝짓기 위한 배열
        	int[] permu = new int[n];
        	for(int i=0;i<n/2;i++) {
        		permu[i]=0;
        		permu[i+n/2]=1;
        	}
        	
        	//현재 지렁이 짝에 대해서
        	do {
        		long x_sum=0;
        		long y_sum=0;
        		//짝에 맞추어 x,y좌표 합을 구함
        		for(int i=0;i<n;i++) {
        			if(permu[i]==0) {
        				x_sum+= pos[i][0];
        				y_sum+= pos[i][1];
        			}
        			else {
        				x_sum-= pos[i][0];
        				y_sum-= pos[i][1];
        			}
        		}
        		//거리를 구하고, 최솟값과 비교
        		long cur_dis = x_sum*x_sum + y_sum*y_sum;
        		min_dis = Math.min(min_dis, cur_dis);
        	}while(next_permutation(permu));
        	//출력문 저장
        	sb.append('#').append(t).append(' ').append(min_dis).append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}