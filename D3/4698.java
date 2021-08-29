// 제목 : 테네스의 특별한 소수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRuoqCKkE0DFAXt
// 메모리 :  26,288 kb
// 실행시간 : 186 ms
 
import java.util.Arrays;
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
        
        // **** 에라토스테네스의 체를 이용하여, 소수를 하나 찾았을 때 그 배수들을 지워나갔습니다.
        // **** i마다 sqrt(i)이하의 소수로 나눠보는 것보다 미세하지만 좀 더 빠릅니다.
        //소수 목록은 테스트 케이스마다 필요하기 때문에 넉넉하게 미리 만들어둠
        int[] primes = new int[1000000];
        boolean[] isNotPrime = new boolean[1000001];
        int primeCount=0;
        for(int i=2;i<=1000000;i++) {
            if(!isNotPrime[i]) {
                primes[primeCount++] = i;
                int num = 2*i;
                while(num<=1000000) {
                    isNotPrime[num]  = true;
                    num += i;
                }
            }
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
              
            int answer=0;
            
            //반복문을 돌릴 경곗값 구하기
            int lower_bound = Arrays.binarySearch(primes, 0, primeCount, a);
            if(lower_bound<0) lower_bound = -(lower_bound+1);
             
            int upper_bound = Arrays.binarySearch(primes, lower_bound, primeCount, b);
            if(upper_bound<0) upper_bound = -(upper_bound)-2;
            //이 경우는 upper_bound = -insertion point -1이므로, insertion-point -1을 가리키도록 바꿈
             
            //a이상 b이하 소수들에 대해 d를 포함하는지 확인 
            for(int i=lower_bound;i<=upper_bound;i++) {
                if(containD(primes[i],d)) answer++;
            }
              
            //출력문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
            }
        //출력
        System.out.print(sb.toString());
    }
}
