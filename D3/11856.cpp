// 제목 : 반반
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXjS1GXqZ8gDFATi
// 메모리 :  12,676 kb
// 실행시간 : 6 ms

#include<iostream>
#include<string>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    //테스트 케이스 수를 입력받음
    int T;
    cin >> T;

    //각각의 테스트 케이스에 대하여 
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //문자열을 입력받음
        string s;
        cin >> s;
        bool check = false;
 
        //처음 두 글자가 같으면, 남은 두 글자가 같은지 비교
        if (s[0] == s[1]) {
            if (s[0] != s[2] && s[2] == s[3]) check = true;
        }
        //처음 두 글자가 다르면, 그 두 문자들이 이후에 한 번씩 등장하는지 확인
        else {
            int s0 = s.find(s[0], 1);
            int s1 = s.find(s[1], 2);
            if (s0 != -1 && s1 != -1) check = true;
        }

        //결과 출력
        if (check) cout << "#" << test_case << " Yes\n";
        else cout << "#" << test_case << " No\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}