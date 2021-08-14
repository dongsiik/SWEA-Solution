// 제목 : [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15FZuqAL4CFAYD
// 메모리 :  12,684 kb
// 실행시간 : 7 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<string>

using namespace std;


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
        //바코드의 가로, 세로 정보
        int sero, garo;
        cin >> sero >> garo;

        //비어있지 않은 바코드에 암호문이 담겨있으므로, 그 줄을 옮겨적음
        string s;
        for (int i = 0; i < sero; i++) {
            string tmp;
            cin >> tmp;
            if (tmp.find('1') != -1) s = tmp;
        }

        //8자리 암호문을 저장할 배열을 만듦
        int* code = new int[8];
        fill(code, code + 8, 0);

        //줄에서 암호문이 있는 위치를 찾고, 7자리씩 읽으면서 숫자로 변환
        int idx = s.rfind('1');
        for (int i = 0; i < 8; i++) {
            string num = s.substr(idx-55+7*i, 7);
            if (num == "0001101") code[i] = 0;
            else if (num == "0011001") code[i] = 1;
            else if (num == "0010011") code[i] = 2;
            else if (num == "0111101") code[i] = 3;
            else if (num == "0100011") code[i] = 4;
            else if (num == "0110001") code[i] = 5;
            else if (num == "0101111") code[i] = 6;
            else if (num == "0111011") code[i] = 7;
            else if (num == "0110111") code[i] = 8;
            else if (num == "0001011") code[i] = 9;
        }

        //검증코드가 맞는지에 따라 경우를 나누어 출력
        int chk = 3 * (code[0] + code[2] + code[4] + code[6]) + code[1] + code[3] + code[5] + code[7];
        if (chk % 10 != 0) cout << '#' << test_case << ' ' << 0 << '\n';
        else {
            int sum = 0;
            for (int i = 0; i < 8; i++) sum += code[i];
            cout << '#' << test_case << ' '<<sum << '\n';
        }
    }

    return 0;
}