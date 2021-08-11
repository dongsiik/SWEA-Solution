// 제목 : 정삼각형 분할 놀이
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe5G8afT0DFAUw
// 메모리 :  12,680 kb
// 실행시간 : 6 ms

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
        //a ,b값 입력받기. 상한선은 10^6이지만, 값을 위해 제곱하면 int 범위를 넘기므로 미리 long long으로 받았음
        long long a, b;
        cin >> a >> b;
        //결과 계산
        long long answer = (a / b) * (a / b);

        //출력
        cout << '#' << t << ' ' << answer << '\n';
    }

    return 0;
}