// 제목 : [S/W 문제해결 기본] 2일차 - Sum
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh
// 메모리 :  12,688 kb
// 실행시간 : 32 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<vector>

using namespace std;

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

        //2차원 배열을 저장할 벡터를 만들고, 값을 입력받음
        vector<vector<int>> v(100, vector<int>(100));

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                cin >> v[i][j];

        //현재까지 최댓값
        int maxSum = 0;

        //행별로 합을 구해서 최댓값과 비교 후 갱신
        for (int i = 0; i < 100; i++) {
            int curSum = 0;
            for (int j = 0; j < 100; j++)
                curSum += v[i][j];
            if (maxSum < curSum) maxSum = curSum;
        }

        //열별로 합을 구해서 최댓값과 비교 후 갱신
        for (int j = 0; j < 100; j++) {
            int curSum = 0;
            for (int i = 0; i < 100; i++)
                curSum += v[i][j];
            if (maxSum < curSum) maxSum = curSum;
        }

        //대각선도 비슷하게 수행
        {
            int curSum = 0;
            for (int i = 0; i < 100; i++)
                curSum += v[i][i];
            if (maxSum < curSum) maxSum = curSum;
        }

        {
            int curSum = 0;
            for (int i = 0; i < 100; i++)
                curSum += v[i][99-i];
            if (maxSum < curSum) maxSum = curSum;
        }

        //출력
        cout << '#' << test_case << ' ' << maxSum << '\n';
    }

    return 0;
}