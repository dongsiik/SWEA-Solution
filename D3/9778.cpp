// 제목 : 카드 게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXE0YJiK3QcDFAVX
// 메모리 :  12,548 kb
// 실행시간 : 7 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>

using namespace std;

int main(int argc, char** argv)
{
    int T;
    cin >> T;
    for (int test_case = 1; test_case <= T; ++test_case)
    {
        //가치에 따른 카드의 개수를 저장하는 배열
        int card[] = { 0,0,4,4,4,4,4,4,4,4,16,4 };
        int sum = 0;

        //카드의 개수를 입력받고, 그만큼 카드를 받아서 총합과 남은 카드 개수를 정리
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            card[a]--;
            sum += a;
        }

        //21점까지 남은 점수에 따라 한 장을 더 받을지 말지 결정하고 출력
        int boundary = 21 - sum;
        if (boundary <= 1) cout << "#" << test_case << " STOP\n";
        else {
            int u = 0;
            int o = 0;
            for (int i = 2; i <= boundary; i++) {
                u += card[i];
            }
            for (int i = 11; i > boundary; i--) {
                o += card[i];
            }
            if (o >= u)  cout << "#" << test_case << " STOP\n";
            else  cout << "#" << test_case << " GAZUA\n";
        }

    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}