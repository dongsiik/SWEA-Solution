// 제목 : 원재의 벽 꾸미기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b9AkKACkBBASw
// 메모리 :  12,548 kb
// 실행시간 : 181 ms

#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    //테스트 케이스 수
    int T;
    cin>>T;
    
    //테스트 케이스 마다
    for(int t=1;t<=T;t++){
        //조건 입력받기
        int n, a, b;
        cin>>n>>a>>b;
        //비교하면서 줄여나갈 정답
        long long answer = 1e18;
        
        //c>=r로 가정하고, 가능한 모든 경우 비교
        for(long long r=1;r<=sqrt(n);r++){
            for(long long c = r; c<=n;c++){
                if(r*c>n) break;
                long long cur  = a*(c-r) + b*(n-r*c);
                if(answer>cur) answer=cur;
            }
        }
        
        //출력
        cout<<'#'<<t<<' '<<answer<<'\n';
    }

    return 0;
}