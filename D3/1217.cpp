// 제목 : [S/W 문제해결 기본] 4일차 - 거듭 제곱
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD
// 메모리 :  12,548 kb
// 실행시간 : 6 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>


using namespace std;

int myPow(int n, int m) {
    //n의 1제곱인 경우 n을 리턴
    if (m == 1) return n;

    //아닐 경우 n* n^(m-1)을 리턴
    return n * myPow(n, m - 1);
}

int main(int argc, char** argv)
{

    int test_case;
    int T=10;  //테스트 케이스 수, 10으로 주어짐

    //cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //테스트 케이스 번호 거르기
        cin >> test_case;

        //n,m 입력받기
        int n, m;
        cin >> n >> m;
        
  
        //출력
        cout << '#' << test_case << ' ' << myPow(n,m) << '\n';
    }

    return 0;
}