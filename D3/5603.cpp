// 제목 : [Professional] 건초더미
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGEbd6cjMDFAUo
// 메모리 :  12,680 kb
// 실행시간 : 14 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //건초더미 수
        int n;
        cin >> n;

        //더미 수만큼 배열을 만들어서 저장하고, 총합도 구하기
        int* dummy = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cin >> dummy[i];
            sum += dummy[i];
        }

        //더미마다 건초가 몇 덩이 있어야하는지 계산하기
        int avg = sum / n;

        //건초더미들을 보면서 목표보다 많이 있는 더미에서 목표치가 되도록 옮김
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (dummy[i] > avg) answer += (dummy[i] - avg);
        }

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';


        delete[] dummy;
    }

    return 0;
}