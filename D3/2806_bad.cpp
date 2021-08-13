// 제목 : N-Queen
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB
// 메모리 :  12,684 kb
// 실행시간 : 357 ms
// 이 코드는 열과 행만 다르게 퀸을 늘어놓는 모든 경우에 대해 대각선으로 잡히는지를 따집니다.
// n!의 경우의 수를 모두 따지므로 비효율적입니다.


#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>

using namespace std;

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
        int n;
        cin >> n;
        int answer = 0;

        //quuen[i]=j는 i번째 열에 있는 quuen은 j번째 행에 있다는 뜻입니다.
        int* queens = new int[n];
        for (int i = 0; i < n; i++) queens[i] = i;

        //퀸마다 행과 열을 다르게 놓는 모든 경우에 대하여
        do {
            bool chk = true;
            //서로 대각선으로 잡히는지 확인
            for (int i = 0; i < n && chk; i++) {
                for (int j = i + 1; j < n && chk; j++) {
                    if((j-i)==abs(queens[i]-queens[j])) chk=false;
                }
            }
            //안 잡힌다면 경우의 수 하나 증가
            if (chk) answer++;

        } while (next_permutation(queens, queens + n));

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}