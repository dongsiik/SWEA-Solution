// 제목 : 두 수의 덧셈
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBC1lOad9IDFAWr
// 메모리 :  12,684 kb
// 실행시간 : 5 ms

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

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //문자열로 숫자 두 개 받고, 길이 저장
        string s1, s2;
        cin >> s1 >> s2;
        int len1 = s1.length();
        int len2 = s2.length();

        //긴 문자열에 저장하는 식으로 진행할 예정이라, s1의 길이가 더 크거나 같도록 조정
        if (len1 < len2) {
            swap(s1, s2);
            swap(len1, len2);
        }

        int dummy = 0; //덧셈을 하며 10이 넘었을 때 앞자리 올림 여부를 나타낼 변수
        for (int i = 1; i <=len1; i++) {
            //앞자리 올림, s1의 같은 자리수를 비교해서 s1의 자릿수를 끝부터 계산
            int t = s1[len1 - i]-'0' + dummy;
            if (i <= len2) t += s2[len2 - i] - '0';

            //자릿수가 10을 넘어가면, 앞자리를 올린다고 표시하고 일의 자리 수만 반영
            if (t >= 10) {
                dummy = 1;
                s1[len1 - i] = t - 10 + '0';
            }
            //자릿수가 10을 안 넘어가면, 앞자리를 안 올린다고 표시하고 반영
            else {
                dummy = 0;
                s1[len1 - i] = t + '0';
            }
        }
        //마지막에 자릿수를 올려야한다면, 맨 앞에 1을 붙이면 됨
        if (dummy == 1) {
            s1 = '1' + s1;
        }

        //출력
        cout << '#' << test_case << ' ' << s1 << '\n';

    }
    return 0;
}