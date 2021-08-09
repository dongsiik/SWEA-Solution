// 제목 : 항구에 들어오는 배
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWMedCxalW8DFAXd
// 메모리 :  12,680 kb
// 실행시간 : 122 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    scanf("%d", &T);

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int n;  //즐거운 날의 갯수
        scanf("%d", &n);
        int day;    //즐거운 날의 날짜
        scanf("%d", &day);
        int* primes = new int[n - 1]; //새로운 주기의 배만 저장할 배열
        for (int i = 0; i < n - 1; i++) primes[i] = 0;
        int size = 0;   //새로운 주기의 배의 갯수

        for (int i = 0; i < n - 1; i++) {
            //배가 들어온 날짜 입력받기, 주기를 구하기 위해 첫날인 1일 뺌
            scanf("%d", &day);
            day--;

            //지난 배들을 보며 기존 배들의 주기에 겹치는 배는 아닌지 확인
            bool chk = true;
            for (int j = 0; j < size; j++) {
                if (day % primes[j] == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                primes[size++] = day;
            }
        }

        //출력
        printf("#%d %d\n", test_case, size);

    }
    return 0;
}