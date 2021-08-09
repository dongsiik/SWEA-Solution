// 제목 : 영준이의 카드 카운팅
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN
// 메모리 :  12,684 kb
// 실행시간 : 6 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //카드를 저장할 배열
        int** cards = new int* [4];
        for (int i = 0; i < 4; i++) {
            cards[i] = new int[14];
            fill(cards[i], cards[i] + 14, 0);
        }

        //카드 정보 입력받기
        string s;
        cin >> s;
        int pos = 0;
        bool chk = true;
        //3글자씩 끊어서 카드 정보 해석
        while (pos < s.length()) {
            //첫 글자로 카드 무늬 읽어서
            if (s[pos] == 'S') {
                //그 무늬 카드 갯수를 하나 늘리고
                cards[0][0]++;
                //그 무늬 그 숫자 카드 갯수를 하나 늘리고
                cards[0][stoi(s.substr(pos + 1, 2))]++;
                //같은 무늬 같은 숫자 카드가 둘 이상이라면 그만 읽기
                if (cards[0][stoi(s.substr(pos + 1, 2))] > 1) {
                    chk = false;
                    break;
                }
            }
            else if (s[pos] == 'D') {
                cards[1][0]++;
                cards[1][stoi(s.substr(pos + 1, 2))]++;
                if (cards[1][stoi(s.substr(pos + 1, 2))] > 1) {
                    chk = false;
                    break;
                }
            }
            else if (s[pos] == 'H') {
                cards[2][0]++;
                cards[2][stoi(s.substr(pos + 1, 2))]++;
                if (cards[2][stoi(s.substr(pos + 1, 2))] > 1) {
                    chk = false;
                    break;
                }
            }
            else if (s[pos] == 'C') {
                cards[3][0]++;
                cards[3][stoi(s.substr(pos + 1, 2))]++;
                if (cards[3][stoi(s.substr(pos + 1, 2))] > 1) {
                    chk = false;
                    break;
                }
            }
            pos += 3;
        }
        //중복카드가 없다면 남은 카드 갯수 출력, 있다면 오류메시지 출력
        if (chk) cout << '#' << test_case << ' ' << 13 - cards[0][0] << ' ' << 13 - cards[1][0] << ' ' << 13 - cards[2][0] << ' ' << 13 - cards[3][0] << '\n';
        else cout << '#' << test_case << ' ' << "ERROR" << '\n';

        for (int i = 0; i < 4; i++) delete[] cards[i];
        delete[] cards;
    }
    return 0;
}