// 제목 : 테네스의 특별한 소수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRuoqCKkE0DFAXt
// 메모리 :  25,540 kb
// 실행시간 : 260 ms

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
class Solution
{
	//어떤 수가 d를 가지고 있는지 판별해주는 함수
	//오른쪽부터 자릿수를 확인해서 d와 같으면 true, 아니면 false를 반환함
	public static boolean containD(int prime, int d) {
		while(prime>0) {
			int il = prime%10;
			if(il==d) return true;
			prime /=10;
		}
		
		return false;
	}
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        // **** 에라토스테네스의 체를 이용하여, 소수를 하나 찾았을 때 그 배수들을 지워나가는 게 미세하지만 더 빠릅니다.(약 9ms 소요, 현재 코드는 약 30ms) 
        //소수 목록은 테스트 케이스마다 필요하기 때문에 미리 만들어둠
        //목록을 넉넉한 공간에 잡아두고, 2와 3을 넣고, 소수가 두 개 있다고 표기
        int[] primes = new int[1000000];
        int primeCount=2;
        primes[0]=2;
        primes[1]=3;
        //4부터 1000000까지 수가 소수인지 검사
        for(int i=4;i<=1000000;i++) {
            boolean isPrimeI = true;
            for(int j=0;j<primeCount;j++) {
            	//제곱근보다 작은 소수들로 나누어떨어지는지 확인
                if(i<primes[j]*primes[j]) break;
                if(i%primes[j]==0) {
                    isPrimeI = false;
                    break;
                }
            }
            //소수라면 목록에 기록하고, 소수의 개수릃 하나 늘려줌
            if(isPrimeI) primes[primeCount++]=i; 
        }
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
         
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//d, a, b 입력받기
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            //b 이하인 소수들을 하나하나 보면서 a보다 크고 d를 포함하는지 확인
            int answer=0;
            for(int i=0;i<primeCount;i++) {
                if(primes[i]>b) break;
                if(primes[i]>=a && containD(primes[i],d)) answer++;
            }
             
            //출력문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            }
        //출력
        System.out.print(sb.toString());
    }
}