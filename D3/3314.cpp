// 제목 : 보충학습과 평균
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBnA2jaxDsDFAWr
// 메모리 :  12,572 kb
// 실행시간 : 16 ms

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
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            //성적 입력받고, 보충이 필요하면 보충시켜서 점수 합산하기
            int score;
            scanf("%d", &score);
            sum += (score >= 40 ? score : 40);
        }

        
        //출력
        printf("#%d %d\n", test_case, sum/5);
    }
    return 0;
}