// 제목 : 동철이의 프로그래밍 대회
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWicMVWKTuMDFAUL
// 메모리 :  12,544 kb
// 실행시간 : 6 ms
// ***** 이 문제는 6958번(D3)과 동일합니다!


#define _CRT_SECURE_NO_WARNINGS 
#include <iostream>

using namespace std;

int main(void)
{
    int T;
    scanf("%d", &T);

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int n, m; //사람 수와 문제 수
        scanf("%d", &n);
        scanf("%d", &m);

        //사람 별로 점수를 저장할 배열을 만들고 초기화
        int* score = new int[n];
        fill(score, score + n, 0);

        //정보를 입력받으며 맞췄다면 그 사람의 점수 1점 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a;
                scanf("%d", &a);
                if (a == 1) score[i]++;
            }
        }

        //성적들을 보며 최고점인지를 보고, 최고점이라면 동점자 수를 하나 늘림
        int Max = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] > Max) {
                Max = score[i];
                count = 1;
            }
            else if (score[i] == Max) count++;
        }

        delete[] score;
        printf("#%d %d %d\n", test_case, count, Max);

    }
    return 0;
}