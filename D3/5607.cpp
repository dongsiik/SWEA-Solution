// 제목 : [Professional] 조합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo
// 메모리 :  16,444 kb
// 실행시간 : 20 ms

//참고 링크 : https://5stralia.tistory.com/4

#define _CRT_SECURE_NO_WARNINGS 
//문제에서 나머지를 구할 때 나누라는 값. 이 값은 아무런 단서가 없었지만 아무튼 소수라서 페르마의 소정리를 쓸 수 있다.
#define mod 1234567891
#include<iostream>

using namespace std;

//테스트 케이스마다 공통적으로 쓸 팩토리얼 값을 저장한 배열
int factorial[1000001];

//두 값을 더하고, 문제에 주어진 값으로 나누는 곱하기 연산
long long myMultiplication(long long a, long long b) {
    return (a * b) % mod;
}

//페르마의 a^(p-1)=1 (mod p)임을 이용, a / b = a* (1/b) = a * b^(p-2) (mod p)로 나누기 연산
long long myDivision(long long bunja, long long bunmo) {
    
    //b^(p-2) 구하기
    int inverseOfbunmo = 1;
    int power = mod - 2;
    //a^9를 계산할 때, ((a^2)^2)^2*a로 구하면 횟수가 줄어든다. 같은 방식을 적용했다.
    while (power > 0) {
        if (power % 2 == 1) {
            inverseOfbunmo = myMultiplication(inverseOfbunmo, bunmo);
            power--;
        }
        bunmo = myMultiplication(bunmo, bunmo);
        power /= 2;
    }


    return myMultiplication(bunja,inverseOfbunmo);
}

//조합 구하기
long long combination(int n, int r) {
    long long bunja = factorial[n];

    long long bunmo = myMultiplication(factorial[r], factorial[n - r]);

    return myDivision(bunja,bunmo);
}

int main(int argc, char** argv)
{
    //테스트 케이스마다 쓸 팩토리얼 값 미리 구해두기
    factorial[0] = 1;
    factorial[1] = 1;
    for (int i = 2; i <= 1000000; i++)
        factorial[i] = myMultiplication(factorial[i - 1], i);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //n, r 입력받기
        int n, r;
        cin >> n >> r;

        //출력
        cout << '#' << test_case << ' ' << combination(n,r) << '\n';
    }

    return 0;
}