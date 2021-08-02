// 제목 : 프리셀 통계
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXmwMidaSLIDFARX
// 메모리 :  40,496 kb 메모리 
// 실행시간 : 198 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수를 입력받음
        int T;
        T=sc.nextInt();

        //각각의 테스트 케이스에 대하여 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean possible = false;

            //n, Pd, Pg를 입력받음            
            long n = sc.nextLong();
            int Pd = sc.nextInt();
            int Pg = sc.nextInt();

	//W:승리, L:패배, d:오늘, g:전체  4가지 값을 두고 비교할 예정
            long Wd=0;
            long Ld=0;
            long Wg=0;
            long Lg=0;

            //d: 오늘 한 게임 수, g:넉넉하게 잡은 전체 게임 수(넉넉하게 잡아야 Wd<Wg, Ld<Lg를 판별하기 좋음)
            long d =0;
            long g = (Long.MAX_VALUE/100) * 100;
            
            //오늘 100판 이하를 했다면 정확히 Pd가 나올 수 있는 d가 있는지 확인하고, 그렇다면 Wd, Ld 계산
            if(n<100){
                for(d=2;d<=n;d++){
                    if(d%2==0 || d%5==0){
                        if((d*Pd)%100==0){
                            Wd = (d*Pd)/100;
                            Ld = (d*(100-Pd))/100;
                            break;
                        }
                    }
                }
            }
            //아니라면 오늘 100판을 했다고 치고, Wd, Ld를 계산
            else{
                Wd=Pd;
                Ld=100-Pd;
 
            }
            
            //넉넉하게 Wg, Lg를 구하고, 이 값들이 Wd, Ld와 각각 큰지 비교하여 가능한지 판별 
            Wg = g/100 * Pg;
            Lg = g/100 * (100-Pg);
            if(Wd<=Wg && Ld<=Lg){possible = true;}
            if(Wd==0 && Ld==0){possible = false;}
 
            //결과 출력
            if(possible == true){
                System.out.println("#"+test_case+" Possible");
            }
            else{
                System.out.println("#"+test_case+" Broken");
            }
 
        }
    }
}