// 제목 : 문자열의 거울상
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXTC0x16D8EDFASe
// 메모리 :  12,684 kb
// 실행시간 : 19 ms

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    //테스트 케이스 수 입력받기
    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //받아올 문자열 s1와 출력할 문자열 s2
        string s1;
        cin >> s1;
        string s2 = s1;
        int n = s1.length();

        //s1을 앞에서부터 읽으면서 뒤집어서 s2 뒤에 저장함
        for (int i = 0; i < n; i++) {
            if (s1[i] == 'b') s2[n - 1 - i] = 'd';
            if (s1[i] == 'd') s2[n - 1 - i] = 'b';
            if (s1[i] == 'q') s2[n - 1 - i] = 'p';
            if (s1[i] == 'p') s2[n - 1 - i] = 'q';
        }

        //결과 출력
        cout << "#" << test_case << " " << s2 << "\n";


    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}