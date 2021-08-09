// 제목 : 화섭이의 정수 나열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHz7xD6A20DFAVB
// 메모리 :  12,576 kb
// 실행시간 : 10 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;  //테스트 케이스 수

    scanf("%d", &T);

    // ***** long long으로 scanf, printf를 사용할 때는 int때 쓰던 %d가 아니라 %lld를 써야합니다!
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //정수의 개수 입력받기
        int n;
        scanf("%d", &n);

        //정수를 1000개 이하로 입력받으므로, 1000개 이하에서 표현하지 못하는 수가 반드시 나옴. 나온 수를 저장할 배열 크기를 1001로 잡아도 충분
        bool* visited = new bool[1001];
        for (int i = 0; i < 1001; i++) visited[i] = false;
        //숫자들로 만들어볼 일, 십, 백의 자리수
        int il = 0, sib = 0, baek = 0;

        for (int i = 0; i < n; i++) {
            //숫자 입력받기
            int a;
            scanf("%d", &a);

            //전의 수와 이어서 일,십,백의 자리 수 만들고, 만들 수 있다고 표현하기
            il = a;
            sib = (sib * 10) % 100 + a;
            baek = (baek * 10) % 1000 + a;
            visited[il] = true;
            visited[sib] = true;
            visited[baek] = true;
        }

        //만들 수 없는 가장 작은 수 찾기
        int answer = -1;
        for (int i = 0; i <= 1000; i++) {
            if (visited[i] == false) {
                answer = i;
                break;
            }
        }

        //출력
        printf("#%d %d\n", test_case, answer);
    }
    return 0;
}