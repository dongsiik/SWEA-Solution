// 제목 : 힙
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Tj7ya3jYDFAXr
// 메모리 :  13,316 kb
// 실행시간 : 373 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        //STL에서 제공되는 우선순위 큐로 힙 구현
        priority_queue<int> pq;

        //명령의 개수
        int n;
        cin >> n;

        //출력문 머릿말, 명령어를 입력받으며 바로 결과를 출력할 예정
        cout << '#' << test_case << ' ';

        //명령어마다
        for (int i = 0; i < n; i++) {
            //명령어가 삽입인지 삭제인지 확인
            int op;
            cin >> op;
            if (op == 1) {
                //삽입이라면 값을 입력받아서 넣음
                int value;
                cin >> value;
                pq.push(value);
            }
            else {
                //삭제라면 힙이 비어있으면 -1, 아니라면 힙 상단의 값
                if (pq.empty()) cout << -1 << ' ';
                else {
                    cout << pq.top()<<' ';
                    pq.pop();
                }
            }
        }
        cout << '\n';
    }
    return 0;
}