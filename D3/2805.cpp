// 제목 : 농작물 수확하기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
// 메모리 :  12,680 kb
// 실행시간 : 9 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    //테스트 케이스 수
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //농장 크기 입력받기
        int n;
        scanf("%d", &n);

        //농장을 2차원 배열로 만들고, 숫자 하나씩 끊어서 정보를 입력받음
        int** map = new int* [n];
        for (int i = 0; i < n; i++) {
            map[i] = new int[n];
            for (int j = 0; j < n; j++) {
                scanf("%1d", &map[i][j]);
            }
        }

        int sum = 0;
        int row = n / 2;

        //규칙에 따라 수확하기
        for (int i = 0; i < n; i++) {
            int Row = abs(row);
            for (int j = Row; j < n - Row; j++) {
                sum += map[i][j];
            }
            row--;
        }

        //결과 출력
        printf("#%d %d\n", test_case, sum);


        //배열 동적할당 해제
        for (int i = 0; i < n; i++) {
            delete[] map[i];
        }
        delete[] map;
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}