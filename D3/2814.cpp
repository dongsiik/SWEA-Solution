// 제목 : 최장 경로
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB
// 메모리 :  12,680 kb
// 실행시간 : 5 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>

using namespace std;

//지도의 크기, 간선의 개수, 출력할 최장 경로의 길이
int n, m, answer;
//지금 DFS에서 i번째 정점을 지나갔는지 나타냄
bool visited[11];
//지도, 최대크기인 10*10으로 잡음
int map[11][11];

//지금 node를 방문했고, 지금까지 경로 길이는 length인 DFS 함수
void DFS(int node, int length) {
    //지금 노드 방문처리 및 최장 경로 갱신
    visited[node] = true;
    if (length > answer) answer = length;

    //지금 노드와 연결되었고 방문하지 않은 모든 노드에 방문 처리
    for (int i = 1; i <=n; i++) {
        if (map[node][i]==1 && !visited[i]) DFS(i, length + 1);
    }
    //방문 처리 해제
    visited[node] = false;
}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int test_case;
    int T;  //테스트 케이스 수

    cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //전역변수 초기화
        cin >> n >> m;
        answer = 1;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) map[i][j] = 0;
        }

        //간선 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int x, y;
            cin >> x >> y;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        //각각의 정점을 시작점으로 DFS 시작
        for (int i = 1; i <=n; i++) {
            fill(visited, visited + 11, false);
            DFS(i, 1);
        }

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}