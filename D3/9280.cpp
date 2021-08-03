// 제목 : 진용이네 주차타워
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY
// 메모리 :  12,848 kb
// 실행시간 : 13 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<queue>
int lot[101];   //주차장 자리별 요금
bool lotfull[101];//주차장 자리가 찼는지
int weight[20001];//차별 무게
int lotNum[20001];//차별 주차장 자리 번호

//빈 자리 중 가장 앞 자리를 찾는 함수, 자리가 없으면 -1을 반환
int findMin(int n) {
    for (int i = 1; i <= n; i++) {
        if (lotfull[i] == false) {
            return i;
            break;
        }
    }
    return -1;
}

using namespace std;

int main(int argc, char** argv)
{
    int T;
    scanf("%d", &T);
    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int n, m;
        scanf("%d %d", &n, &m);

        //주차장과 차량 정보 입력받기
        for (int i = 1; i <= n; i++) {
            int r;
            scanf("%d", &r);
            lot[i] = r;
            lotfull[i] = false;
        }

        for (int i = 1; i <= m; i++) {
            int w;
            scanf("%d", &w);
            weight[i] = w;
        }

        int sum = 0;    //주차요금 총액
        queue<int> q;   //대기열

        //차별로 입장, 퇴장 실행
        for (int i = 1; i <= 2 * m; i++) {
            int x;
            scanf("%d", &x);
            //입장
            if (x > 0) {
                //빈자리를 찾아서, 빈자리에 넣거나, 대기열에 넣음
                int pos = findMin(n);
                if (pos == -1) {
                    q.push(x);
                }
                else {
                    lotfull[pos] = true;
                    lotNum[x] = pos;
                    sum += weight[x] * lot[pos];
                }
            }
            //퇴장
            else {
                //빈자리로 만들고, 대기열이 있다면 대기열 맨 앞 차를 집어넣음
                int pos = lotNum[-x];
                if (q.empty()) {
                    lotfull[pos] = false;
                }
                else {
                    int newX = q.front();
                    q.pop();
                    lotNum[newX] = pos;
                    sum += weight[newX] * lot[pos];
                }
            }
        }

        //결과 출력
        printf("#%d %d\n", test_case, sum);


    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}