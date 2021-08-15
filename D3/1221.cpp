// 제목 : [S/W 문제해결 기본] 5일차 - GNS
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
// 메모리 :  12,684 kb
// 실행시간 : 52 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<string>
#include<list>

using namespace std;

//외계 숫자를 우리 숫자로
int stringToInt(string s) {
    if (s == "ZRO") return 0;
    else if (s == "ONE") return 1;
    else if (s == "TWO") return 2;
    else if (s == "THR") return 3;
    else if (s == "FOR") return 4;
    else if (s == "FIV") return 5;
    else if (s == "SIX") return 6;
    else if (s == "SVN") return 7;
    else if (s == "EGT") return 8;
    else return 9;
}

//우리 숫자를 외계 숫자로
string intToString(int num) {
    switch (num) {
    case 0:
        return "ZRO";
    case 1:
        return "ONE";
    case 2:
        return "TWO";
    case 3:
        return "THR";
    case 4:
        return "FOR";
    case 5:
        return "FIV";
    case 6:
        return "SIX";
    case 7:
        return "SVN";
    case 8:
        return "EGT";
    case 9:
        return "NIN";
    }
    return "";
}
int main(int argc, char** argv)
{
//    cin.tie(0);
//    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //countig sort를 위해 사용할 배열, int[i]=j는 숫자 i가 j개 있다는 뜻
        int num[10];
        fill(num, num + 10, 0);

        //#test_case n 입력받기
        string s;
        int n;
        cin >> s >> n;
        //단어들 입력받아서 저장하기
        for (int i = 0; i < n; i++) {
            cin >> s;
            ++num[stringToInt(s)];
        }

        //출력
        cout << '#' << test_case << ' ';
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) {
                cout << intToString(i) << ' ';
            }
        }
        cout << '\n';
    }

    return 0;
}