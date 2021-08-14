// 제목 : [S/W 문제해결 응용] 2일차 - 최대 상금
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD
// 메모리 :  12,684 kb
// 실행시간 : 49 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>
#include<string>

using namespace std;
//숫자판의 정보
string s;
//최대 상금, 교환 횟수, 숫자판의 길이
int answer, bound, len;

//재귀적으로 완전 탐색
void dfs(int pos, int count) {
    //다 교환했다면, 현재 상금과 최대 상금을 비교 후 갱신
    if (count == bound) {
        answer = max(answer, stoi(s));
        return;
    }
    //아니라면 pos번 문자와 그 이후 문자를 바꿔보고 재귀적으로 다시 바꿔봄
    for (int i = pos; i < len-1; i++) {
        for (int j = i + 1; j < len; j++) {
            swap(s[i], s[j]);
            dfs(i, count + 1);
            swap(s[i], s[j]);
        }
    }
}

int main(int argc, char** argv)
{
//    이유는 모르겠지만 이 두 줄을 주석처리해야 제출시 런타임 오류가 나지 않습니다.
//    cin.tie(0);
//    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //전역변수 초기화
        answer = -1;
        cin >> s >> bound;
        len = s.size();

        //숫자판이 두 개일 때
        if (len == 2) {
            //바꾸는 횟수가 짝수번이면 그대로이고, 홀수번이면 한 번 바꾼 셈
            if (bound % 2 == 0) answer = stoi(s);
            else {
                swap(s[0], s[1]);
                answer = stoi(s);
            }
        }
        //만약 교환 횟수가 문자열 길이 이상이라면, 최댓값은 내림차순으로 정렬한 것과 같음
        //교환횟수 == 문자열 길이일때는 자명하고, 교환횟수 == 문자열 길이 + 2k일때는 두 개만 계속 맞바꾸면 되니까 자명하고,
        //교환횟수 == 문자열 길이 +1 일때는 처음에 뻘짓을 한 번 하고 거품정렬을 하면 되니 이렇게 됨
        //하지만 정렬을 위해 string에서 다른 방식으로 바꾸기는 너무 귀찮으므로 문자열 길이만큼 반복하는 것으로 했음...
        else {
            bound = min(len, bound);
            dfs(0, 0);
        }

        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}