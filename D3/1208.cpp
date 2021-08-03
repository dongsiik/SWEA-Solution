// 제목 : [S/W 문제해결 기본] 1일차 - Flatten
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
// 메모리 :  144 kb
// 실행시간 : 5 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>
  
using namespace std;
  
#define _CRT_SECURE_NO_WARNINGS 
#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T = 10;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //덤프 횟수
        int dump;
        //높이에 따른 상자 분포를 저장할 배열 선언 및 초기화
        int* count = new int[101];
        fill(count, count + 101, 0);

        //가장 낮거나 높은 높이
        int m = 100;
        int M = 1;

        scanf("%d", &dump);

        //상자의 높이를 입력받아 저장
        for (int i = 0; i < 100; i++) {
            int tmp;
            scanf("%d", &tmp);
            count[tmp]++;
            if (tmp > M) M = tmp;
            if (tmp < m) m = tmp;
        }

        //평탄화 시작
        for (int i = 0; i < dump; i++) {
            //높이차가 1 이하라면 삽질이므로 그만둠
            if (m + 1 >= M) break;
            //가장 높은 곳에서 하나 가져와서 낮은 곳에 둠
            count[m]--;
            count[m + 1]++;
            if (count[m] == 0) m = m + 1;
            count[M]--;
            count[M - 1]++;
            if (count[M] == 0) M = M - 1;
        }

        //결과 출력
        printf("#%d %d\n", test_case, M - m);

        delete[] count;
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}