// 제목 : 제곱수 만들기
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXWXH_h695kDFAST
// 메모리 :  22,324 kb
// 실행시간 : 695 ms

#define _CRT_SECURE_NO_WARNINGS //Visual Studio에서 scanf, printf를 사용하기 위해 추가함
#include <iostream>
#include <cstdio>
#include <cmath>
#define MAX 10000001            //테스트 케이스에서 주어지는 자연수의 최댓값이 10^7임
using namespace std;

bool prime[MAX];                //루트 10^7 이하인 수가 소수인지 아닌지 저장해둘 배열
int list[3600];                 //루트 10^7 이하의 소수 목록

int main(void)
{                               //소수 목록은 여러 테스트 케이스에 공통적으로 쓸 수 있으므로, 프로그램 시작부터 구했음
    int sqMax = (int)sqrt(MAX);
    list[0] = 2;
    list[1] = 3;
    int pos = 2;
    prime[2] = true;
    prime[3] = true;

    for (int i = 4; i <= 10000; i++) {       //10000 이하의 수에 대해서, 제곱근보다 작은 값들로 나눠보면서 소수인지 아닌지 판단 후 결과를 전역변수에 저장
        bool isPrime = true;
        int sq = (int)sqrt(i);
        for (int j = 2; j <= sq; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            list[pos++] = i;
            prime[i] = true;
        }
    }

    //테스트 케이스의 수를 입력받음
    int T;
    scanf("%d", &T);

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        //각각의 테스트 케이스에 대해서 n을 입력받음
        int n;
        scanf("%d", &n);

        if (prime[n]) printf("#%d %d\n", test_case, n);     //n이 10000 이하의 소수라면, 답은 n임
        else {
            int index = 0;
            int answer = 1; //처음 n값에 answer을 곱하면 제곱수가 되어야함
            int count = 0;
            while (n > 1) {
                //n을 10000 이하의 소수인 list[index]로 나누어떨어지는지 보고, 나누어떨어진다면 나눔
                if (n % list[index] == 0) {
                    count++;
                    n /= list[index];

                }
                //n이 더 이상 list[index]로 나누어떨어지지 않는다면
                if (n % list[index] != 0) {
                    //처음 n에 list[index]가 홀수번 거듭제곱 되어있었다면, 한 번 더 곱해줘야 제곱수가 될 것이므로 answer에 list[index]를 곱함
                    if (count % 2 == 1) answer *= list[index];
                    //찌꺼기가 10000만 이하의 소수라면, answer에 그 소수를 곱하면 끝임
                    if (prime[n]) {
                        answer *= n;
                        break;
                    }

                    index++;
                    count = 0;  //다음 소수로 나눠보기 위해 index를 증가하고, 지수인 count를 0으로 초기화
                    if (index == pos) { //우리가 만들어둔 소수목록을 다 나눠봤는데도 n이 1이 아니라면, n은 10000 이상의 소수인 게 분명함.
                        answer *= n;

                        break;
                    }
                }
            }

            printf("#%d %d\n", test_case, answer);
        }

    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}