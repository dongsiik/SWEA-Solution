// 제목 : 부분 수열의 합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7IzvG6EksDFAXB
// 메모리 :  12,680 kb
// 실행시간 : 24 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int n, k;   //자연수의 갯수, 목표로 하는 합
int nums[20];   //자연수들
int answer;     //합이 되는 경우의 수

//pos번째 이전의 자연수들로 부분집합을 구성해서 현재 합이 sum이 된 상태
void subset(int pos, int sum) {
    //sum이 k보다 크면 그만두고, k라면 경우의 수를 하나 늘리고 그만둠
    if (sum > k) return;
    if (sum == k) {
        answer++;
        return;
    }

    //i번째 원소를 포함하는 경우를 재귀적으로 따짐
    for (int i = pos; i < n; i++) subset(i + 1, sum + nums[i]);
}

int main(int argc, char** argv)
{
    //   cin.tie(0);
    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        answer = 0;
        
        //문제의 조건 입력받기
        cin >> n >> k;
        for (int i = 0; i < n; i++) cin >> nums[i];

        //재귀적 탐색
        subset(0, 0);

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';

    }
    return 0;
}