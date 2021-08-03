// 제목 : 새샘이와 세 소수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWaJ3q8qV-4DFAUQ
// 메모리 :  21,392 kb
// 실행시간 : 364 ms

import java.util.ArrayList;
import java.util.List;
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
        int T = Integer.parseInt(br.readLine());
        
        //테스트 케이스에서 두고두고 사용할 수수 목록 만들기
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        //어떤 수가 소수인지는, 그 수의 제곱근 이하의 소수들로 나누어떨어지는지를 보면 알 수 있음
        for(int i=4;i<=995;i++) {
        	boolean isPrime = true;
        	for(int j=0;j<primes.size();j++) {
        		int p = primes.get(j);
        		if(p*p>i) break;
        		if(i%p==0) {
        			isPrime=false;
        			break;
        		}
        	}
        	if(isPrime) primes.add(i);
        }
        int numOfPrime = primes.size();
        
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//숫자를 입력받음
        	int n = Integer.parseInt(br.readLine());
        	int answer=0;
        	
        	//소수 목록에 있는 소수 세 개를 불러와서 더해봄
        	for(int i=0;i<numOfPrime;i++) {
        		int pi = primes.get(i);
        		for(int j=i;j<numOfPrime;j++) {
        			int pj = primes.get(j);
        			if(pi+pj>n) break;
        			for(int k=j;k<numOfPrime;k++) {
        				int pk = primes.get(k);
        				if((pi+pj+pk)==n) answer++;
        				else if(pi+pj+pk>n) break;
        			}
        		}
        	}

        	//결과문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}