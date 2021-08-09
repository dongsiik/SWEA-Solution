// 제목 : 승률 비교하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIX_iFqjg4DFAVH
// 메모리 :  12,548 kb
// 실행시간 : 85 ms

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
        //전적 입력받기
        int a, b, c, d;
        scanf("%d %d %d %d", &a, &b, &c, &d);

        //전적에 따른 결과 출력
        if (d * a > b * c) printf("#%d ALICE\n",test_case);
        else if(d * a == b * c) printf("#%d DRAW\n",test_case);
        else if(d * a < b * c)printf("#%d BOB\n",test_case);
    }
    return 0;
}