// 제목 : 세가지 합 구하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWEbPukqySUDFAWs
// 메모리 :  12,548 kb
// 실행시간 : 23 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    scanf("%d", &T);

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //n 입력받기
        int n;
        scanf("%d", &n);

        //정답 계산
        long long answer1, answer2, answer3;
        answer1 = ((long long)n * (n + 1)) / 2;
        answer2 = (long long)n * n;
        answer3 = answer2 + n;

        //출력
        printf("#%d %lld %lld %lld\n", test_case, answer1, answer2, answer3);
    }
    return 0;
}