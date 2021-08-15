// 제목 : [S/W 문제해결 기본] 1일차 - View
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
// 메모리 :  12,680 kb
// 실행시간 : 9 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{

    int test_case;
    int T=10;  //테스트 케이스 수, 10으로 주어짐

    //cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //강변 길이를 입력받고, 주소에 따른 건물 높이 입력받기
        int n;
        cin >> n;
        cout << n;
        int* buildings = new int[n];
        for (int i = 0; i < n; i++) cin >> buildings[i];

        //자신을 제외한 좌우 2칸의 최고 높이를 구하고, 조망이 확보되는 세대 수 구해서 더하기
        int answer = 0;
        for (int i = 2; i < n - 2; i++) {
            int localMax = max(max(max(buildings[i - 2], buildings[i - 1]), buildings[i + 1]), buildings[i + 2]);
            if (buildings[i] > localMax) answer += (buildings[i] - localMax);
        }

        delete[] buildings;

        //출력
        cout << '#' <<test_case<< ' ' << answer << '\n';
    }

    return 0;
}