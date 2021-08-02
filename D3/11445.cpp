// 제목 : 무한 사전
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXdHwI1aCy0DFAS5
// 메모리 :  12,684 kb
// 실행시간 : 14 ms

#include<bits/stdc++.h>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;	//테스트 케이스 수
    cin>>T;

    //각각의 테스트 케이스에 대하여 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        string p,q;	//스트링 두 개를 입력받음
        cin>>p>>q;

        //p 다음이 바로 q라면, p+"a"와 q가 같아야므로 이 기준으로 비교 후 결과 출력
        if((p+"a")==q) cout<<"#"<<test_case<<" N\n";
        else cout<<"#"<<test_case<<" Y\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}