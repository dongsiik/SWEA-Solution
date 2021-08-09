// 제목 : Digit sum
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHPiSYKAD0DFAUn
// 메모리 :  12,548 kb
// 실행시간 : 103 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

long long digitSum(long long a) {
    long long sum = 0;
    //오른쪽 자리를 계속해서 더해나감
    while (a > 0) {
        sum += a % 10;
        a /= 10;
    }

    return sum;
}
int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    scanf("%d", &T);

    // ***** long long으로 scanf, printf를 사용할 때는 int때 쓰던 %d가 아니라 %lld를 써야합니다!
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //숫자 입력받기
        long long a;
        scanf("%lld", &a);
        //한자리수가 될때까지 자릿수 더하기
        while (a >= 10) a = digitSum(a);

        printf("#%d %lld\n", test_case, a);
    }
    return 0;
}