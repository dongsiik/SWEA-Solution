// 제목 : [S/W 문제해결 기본] 5일차 - Magnetic
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD
// 메모리 :  12,688 kb
// 실행시간 : 31 ms

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
        //테이블 크기 입력받아서 n*n 크기의 테이블 만들기
        int n;
        cin >> n;
        vector<vector<int>> v(n, vector <int>(n));

        //테이블 정보 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                cin >> v[i][j];
        }

        //교착 상태 수
        int answer = 0;

        //열 별로 교착 상태 수 세기
        for (int j = 0; j < n; j++) {
            int uIdx = 0, dIdx = n - 1;
            
            //위에서부터 장애물이 될 수도 있는 빨간 자성체 위치 구하기
            while (uIdx < n) {
                if (v[uIdx][j] == 1) break;
                uIdx++;
            }

            //아래에서 장애물이 될 수도 있는 파란 자성체 위치 구하기
            while (dIdx >= 0) {
                if (v[dIdx][j] == 2) break;
                dIdx--;
            }

            //교착 상태 발생
            if (uIdx < dIdx) {
                //교착상태 안에서 각기 다른 교착 상태가 몇 번 발생하는지 세기
                bool flag = false;
                for (int i = uIdx; i <= dIdx; i++) {
                    if (v[i][j] == 1) flag = true;
                    if (v[i][j] == 2) {
                        if (flag) answer++;
                        flag = false;
                    }
                }
            }
        }

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}