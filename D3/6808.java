// 제목 : 규영이와 인영이의 카드게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 메모리 :  24,272 kb
// 실행시간 : 1,156 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
	
class Solution
{
	//C++에서 제공되는 것과 같은 기능인 next_permutation 함수
	public static boolean next_permutation(int[] arr) {
		
		int len = arr.length;
		int i= len-1;
		while(i>0 && arr[i-1]>arr[i]) i--;
		if(i==0) return false;
		
		int j = len-1;
		while(arr[i-1]>=arr[j]) j--;
		
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		int k = len-1;
		while(i<k) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++;
			k--;
		}
		
		return true;
	}
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스마다
        for(int t=1;t<=T;t++) {
        	
        	//전체 카드, 규영이의 카드, 인영이의 카드
        	int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        	int[] gyu = new int[9];
        	int[] inn = new int[9];
        	
        	//규영이의 카드를 입력받고, 남은 카드를 정리해서 인영이에게 몰아줌
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0;i<9;i++) {
        		gyu[i] = Integer.parseInt(st.nextToken());
        		cards[gyu[i]-1]=0;
        	}
        	Arrays.sort(cards);
        	inn = Arrays.copyOfRange(cards, 9, 18);
        	
        	int win = 0;
        	int lose = 0;
        	
			//인영이의 각각의 조합에 대해서        	
    		do {
    			int gyuSum = 0;
    			int innSum = 0;
    			for (int i = 0; i < 9; i++) {
    				//낸 카드로 승부를 가려서 총점에 더함
    				if (gyu[i] > inn[i]) gyuSum += (gyu[i] + inn[i]);
    				if (gyu[i] < inn[i]) innSum += (gyu[i] + inn[i]);
    				//시간 절약을 위해 점수 절반을 넘기면 반복을 중지함
    				if (gyuSum > 171 || innSum>171) break;
    			}
    			//총점으로 승패 비교
    			if (gyuSum > innSum) win++;
    			if (gyuSum < innSum) lose++;
    		} while (next_permutation(inn));

        	//결과 저장
        	sb.append('#').append(t).append(' ').append(win).append(' ').append(lose).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}