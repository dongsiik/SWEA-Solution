// 제목 : 원재의 메모리 복구하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
// 메모리 :  18,684 kb
// 실행시간 : 110 ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
    	//입력을 받아올 br와 모아서 출력해줄 sb
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        
    	//테스트 케이스의 개수를 입력받음
    	int T;
        T=Integer.parseInt(br.readLine());

        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//고칠 횟수
        	int answer=0;
        	
        	//메모리의 원래 상태를 받아와서 char array로 저장
        	char[] str = br.readLine().toCharArray();
        	int len = str.length;
        	
        	//뒤에서부터 비교해서 글자가 왼쪽글자와 다르다면 한번씩 뒤집어줘야함
        	for(int i=len-1;i>0;i--) {
        		if(str[i]!=str[i-1]) answer++;
        	}
        	//처음이 1이라면 한 번 뒤집어줘야함
        	if(str[0]=='1') answer++;

        	//출력할 결과를 sb에 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //결과 출력
        System.out.println(sb);
    }
}
