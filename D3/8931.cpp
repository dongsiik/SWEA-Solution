// 제목 : 제로
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW5jBWLq7jwDFATQ
// 메모리 :  13,088 kb
// 실행시간 : 138 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<stack>

using namespace std;

int main(int argc, char** argv)
{
    int T;
    cin >> T;
    for (int test_case = 1; test_case <= T; ++test_case)
    {
        //불러주는 수를 스택에 저장할 계획
        stack<int> s;

        //숫자의 개수를 입력받음
        int n;
        cin >> n;

        //숫자를 들으면서 0이라면 스택에서 빼서 지우고, 아니라면 스택에 넣음
        for (int i = 0; i < n; i++) {
            int input;
            cin >> input;
            if (input == 0) { s.pop(); }
            else { s.push(input); }
        }

        //스택에서 빼면서 총합을 구함
        int sum = 0;
        while (!s.empty()) {
            int a = s.top();
            sum += a;
            s.pop();
        }

        //출력
        cout << "#" << test_case << " " << sum << "\n";



    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}