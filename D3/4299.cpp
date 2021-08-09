// 제목 : 태혁이의 사랑은 타이밍
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWLv6mx6htoDFAVV
// 메모리 :  144 kb
// 실행시간 : 5 ms

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
        //날짜 시간 분
        int d, h, m;
        scanf("%d %d %d", &d, &h, &m);
        //약속 시간 이전에 차였을 때
        if (d==11 &&(h<11 || (h==11 && m<11))){
            printf("#%d %d\n", test_case, -1);
            continue;
        }
        //나중에 깨달았을 때
        int answer = 1440 * (d - 11) + 60 * (h - 11) + (m - 11);
        printf("#%d %d\n", test_case, answer);

    }
    return 0;
}