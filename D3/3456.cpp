// 제목 : 직사각형 길이 찾기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWFPmsqqALwDFAV0
// 메모리 :  12,576 kb
// 실행시간 : 7 ms

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
        int a, b, c, answer;
        //세 변의 길이 입력받기
        scanf("%d %d %d", &a, &b, &c);

        //다른 변 하나 찾기
        if (a == b) answer = c;
        else if (a == c) answer = b;
        else answer = a;

        //출력
        printf("#%d %d\n", test_case, answer);
    }
    return 0;
}