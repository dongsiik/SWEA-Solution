// 제목 : 준환이의 운동관리
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWE_ZXcqAAMDFAV2
// 메모리 :  12,540 kb
// 실행시간 : 6 ms

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
        int l, u, x, answer;
        //하한선, 상한선, 운동시간 입력받기
        scanf("%d %d %d", &l, &u, &x);

        //조건을 따져서 정답 계산
        if (x > u) answer = -1;
        else if (x >= l) answer = 0;
        else answer = l - x;

        //출력
        printf("#%d %d\n", test_case, answer);
    }
    return 0;
}