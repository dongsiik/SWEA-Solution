// 제목 : [Professional] 합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQm2SqdxkDFAUo
// 메모리 :  12,548 kb
// 실행시간 : 545 ms

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
        //수열의 길이
        int n;
        cin >> n;

        //연속된 부분합의 최댓값
        int Max = -100000000;
        //현재 고민하고 있는 연속된 부분합
        int partialSum = 0;

        for (int i = 1; i <= n; i++) {
            //숫자를 하나씩 입력받고
            int num;
            cin >> num;
            //부분합에 더해봄
            partialSum += num;
            //현재까지 부분합과 최댓값 비교
            Max = Max > partialSum ? Max : partialSum;
            //부부합이 0 이하면 연속된 합을 구하는 걸 그만두고, 다음부터 새로 부분합을 구함
            partialSum = partialSum < 0 ? 0 : partialSum;
        }

        //출력
        cout << '#' << test_case << ' ' << Max << '\n';
    }

    return 0;
}