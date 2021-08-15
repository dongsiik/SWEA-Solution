// 제목 : [S/W 문제해결 기본] 3일차 - String
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi
// 메모리 :  12,680 kb
// 실행시간 : 7 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<vector>
#include<string>

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

        //찾을 문자열과, 전체 문자열 입력받기
        string wanted, sentence;
        cin >> wanted >> sentence;

        //정답과 찾기 시작하는 위치
        int answer = 0, pos = 0;
        while (true) {
            //find 함수로 지정한 위치부터 문자열 검색하기
            int idx = sentence.find(wanted, pos);
            //더 이상 문자열이 없다면 그만둠
            if (idx == string::npos) break;
            //아니라면 검색할 위치를 그 다음으로 지정하고, 문자열의 개수를 하나 늘림
            else {
                pos = idx + 1;
                ++answer;
            }
        }

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}