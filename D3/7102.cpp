// 제목 : 준홍이의 카드놀이
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC
// 메모리 :  300 kb
// 실행시간 : 5 ms

#define _CRT_SECURE_NO_WARNINGS 
#include <iostream>
 
using namespace std;
 
int main(void)
{
    int T;	//테스트 케이스 수
    scanf("%d", &T);
     
    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int n, m;	//n과 m 값
        scanf("%d %d", &n,&m);
         
        int start = min(n, m) + 1;	//규칙 활용
        int end = max(n, m) + 1;
 
        printf("#%d ", test_case);
 
        for (int i = start; i <= end; i++) {
            printf("%d ", i);
        }
 
        printf("\n");
 
 
    }
    return 0;
}