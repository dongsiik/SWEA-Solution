// 제목 : 100만 이하의 모든 소수
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_6mRsasV8DFAWS
// 메모리 :  13,656 kb
// 실행시간 : 43 ms

#include<iostream>
#include<algorithm>
#define MAX 1000000 //100만 이하이므로 여러번 사용할 상한선을 매크로로 정해둠
using namespace std;

bool nonPrime[MAX+1];   //2 이상의 수 i가 소수라면 nonPrime[i]는 false, 합성수라면 true

int main(int argc, char** argv)
{
    //입출력 속도를 빠르게 하기 위해 동기화를 끊어줌
    cin.tie(0);
    ios::sync_with_stdio(0);

    //에라토스테네스의 체를 활용
    for (int i = 2; i <= MAX; i++) {
        //소수라면 출력
        if (!nonPrime[i]) {
            cout << i << ' ';
            int pos = 2 * i;
            //소수의 배수들에 합성수 표시
            while (pos <= MAX) {
                nonPrime[pos] = true;
                pos += i;
            }
        }
    }

    return 0;
}