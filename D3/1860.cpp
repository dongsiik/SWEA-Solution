// 제목 : 진기의 최고급 붕어빵
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc
// 메모리 :  12,816 kb
// 실행시간 : 15 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        bool possible = true;

        int n, m, k;    //손님수, 붕어빵 만드는 주기, 주기마다 나오는 붕어빵 수
        cin >> n >> m >> k;

        //손님이 오는 시간을 저장한 후, 오름차순으로 정렬
        int* customers = new int[n];
        for (int i = 0; i < n; i++) cin >> customers[i];
        sort(customers, customers + n);

        //손님이 온 시간까지 만들어진 붕어빵 수와, 지금까지 나간 붕어빵 수를 비교
        int demand = 0;
        for (int i = 0; i < n; i++) {
            ++demand;
            if (demand > (customers[i] / m) * k) {
                possible = false;
                break;
            }

        }

        //출력
        if (possible) cout << '#' << test_case << ' ' << "Possible\n";
        else cout << '#' << test_case << ' ' << "Impossible\n";
    }

    return 0;
}