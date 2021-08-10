// 제목 : 파도반 수열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWD3Y27q3QIDFAUZ
// 메모리 :  280 kb
// 실행시간 : 5 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    scanf("%d", &T);

    //규칙에 따라 파도반 수열 미리 계산해두기
    long long p[101];
    p[0] = 0;
    p[1] = 1;
    p[2] = 1;
    p[3] = 1;
    p[4] = 2;
    for (int i = 5; i < 101; i++) p[i] = p[i - 1] + p[i - 5];

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //n 입력받기
        int n;
        scanf("%d", &n);

        
        //출력
        printf("#%d %lld\n", test_case, p[n]);
    }
    return 0;
}