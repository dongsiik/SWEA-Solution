// 제목 : 영준이와 신비한 뿔의 숲
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_6xWk6sbADFAWS
// 메모리 :  288 kb
// 실행시간 : 5 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>
using namespace std;


int main(int argc, char** argv)
{
    //입출력 속도를 빠르게 하기 위해 동기화를 끊어줌
    cin.tie(0);
    ios::sync_with_stdio(0);

    //테스트 케이스 수
    int T;
    cin >> T;

    //테스트 케이스 마다
    for (int t = 1; t <= T; t++) {
        //뿔 수, 동물 수, 유니콘 수, 트윈혼 수
        int n, m, unicorn, twinhorn;
        cin >> n >> m;

        //동물의 마리수 계산
        twinhorn = n - m;
        unicorn = m - twinhorn;

        //출력
        cout << '#' << t << ' ' << unicorn << ' ' << twinhorn << '\n';
    }

    return 0;
}