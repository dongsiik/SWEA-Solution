// 제목 : N-Queen
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB
// 메모리 :  12,680 kb
// 실행시간 : 18 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int queens[10]; //queens[i]=j는 i번째 행에 있는 퀸은 j 번째 열에 있다는 뜻임(i,j<n)
int n;  //보드판의 크기
int answer; //가능한 경우의 수

//막 놓은 퀸이 다른 퀸과 열이나 대각선 방향에서 잡히지 않는지 확인해주는 함수
bool chk(int level) {
    for (int i = 0; i < level; i++) {
        if (queens[i] == queens[level] || abs(queens[i] - queens[level]) == (level - i))
            return false;
    }
    return true;
}

//재귀적으로 n번째 행에 퀸을 놓는 함수
void setQueen(int level) {
    //무사히 다 놓았다면 경우의 수 하나 증가
    if (level == n) answer++;
    else {
        //행에 놓아보고, 무사히 놓을 수 있다면 다음 행에 반복
        for (int i = 0; i < n; i++) {
            queens[level] = i;
            if (chk(level)) setQueen(level + 1);
        }
    }
}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //입력받아서 계산
        cin >> n;
        answer = 0;

        //퀸 놓기 시작
        setQueen(0);

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}