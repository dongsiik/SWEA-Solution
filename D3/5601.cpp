// 제목 : [Professional] 쥬스 나누기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGAylqcdYDFAUo
// 메모리 :  12,548 kb
// 실행시간 : 8 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //사람 수 입력받기
        int n;
        cin >> n;

        //출력, 다들 1/n씩 받게 되므로 n번 1/n 출력
        cout << '#' << test_case << ' ';
        for (int i = 0; i < n; i++) cout << 1 << '/' << n << ' ';
        cout << '\n';
    }

    return 0;
}