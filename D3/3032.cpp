// 제목 : 홍준이의 숫자 놀이
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-0U8FKZLQDFAXT
// 메모리 :  12,680 kb
// 실행시간 : 18 ms

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
        //a, b 입력받기
        int a, b;
        cin >> a >> b;


        //확장된 유클리드 알고리즘 사용
        //출처 : https://brilliant.org/wiki/extended-euclidean-algorithm/
        int x = 0, y = 1, u = 1, v = 0;
        while (a != 0) {
            int q = b / a;
            int r = b % a;
            int m = x - u * q;
            int n = y - v * q;
            
            b = a;
            a = r;
            x = u;
            y = v;
            u = m;
            v = n;
        }

        //출력
        cout << '#' << test_case << ' ' << x << y << '\n';
    }
    return 0;
}