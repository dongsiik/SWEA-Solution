// 제목 : 수의 새로운 연산
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b-QGqADMBBASw
// 메모리 :  13,032 kb
// 실행시간 : 7 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>

using namespace std;

//xy평면의 값을 미리 계산해두고, 테스트케이스에서는 활용만 할 예정
int plane[301][301];

//문제에서 제시된 ★ 연산
int myOperation(int a, int b) {
    //a의 좌표인 a1, a2 구하기, &a
    int i = 300;
    while (i > 0 && plane[1][i] > a) --i;
    int gap = a - plane[1][i];
    int a1 = 1 + gap;
    int a2 = i - gap;

    //b의 좌표인 b1, b2 구하기 &b
    int j = 300;
    while (j > 0 && plane[1][j] > b) --j;
    gap = b - plane[1][j];
    int b1 = 1 + gap;
    int b2 = j - gap;

    //&a + &b
    int c1 = a1 + b1;
    int c2 = a2 + b2;

    //#(&a+&b)를 리턴
    return plane[c1][c2];
}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);


    //x,y평면에서 x좌표가 1일 때 y값들을 규칙을 찾아서 계산
    for (int i = 1; i <= 300; i++) plane[1][i] = 1 + (i * (i - 1)) / 2;
    //위에서 구한 값들부터 오른쪽 아래로 한 칸씩 값을 늘려가며 적음
    for (int x = 2; x <= 300; x++) {
        for (int y = 1; y <= 301 - x; y++) plane[x][y] = plane[x - 1][y + 1] + 1;
    }

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //입력받아서 계산
        int a, b, answer;
        cin >> a >> b;
        answer = myOperation(a, b);

        //출력
        cout << '#' << test_case << ' ' << answer<<'\n';
    }

    return 0;
}