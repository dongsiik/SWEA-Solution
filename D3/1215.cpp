// 제목 : [S/W 문제해결 기본] 3일차 - 회문1
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14QpAaAAwCFAYi
// 메모리 :  12,684 kb
// 실행시간 : 6 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main(int argc, char** argv)
{

    int test_case;
    int T=10;  //테스트 케이스 수, 10으로 주어짐

    //cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //원하는 회문의 길이
        int len;
        cin >> len;

        //글자판 입력받기
        vector<string> v(8);
        for (int i = 0; i < 8; i++) cin >> v[i];

        //찾은 회문의 개수
        int answer = 0;

        //행별로 검사, i,j위치에서 가로로 len칸인 회문이 있는지 확인
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j + len <= 8; j++) {
                bool chk = true;
                int left = j, right = j + len - 1;
                //양끝부터 확인해서 같다면 개수를 늘려줌
                for (int k = 0; k < len/2; k++) {
                    if (v[i][left] != v[i][right]) {
                        chk = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (chk) answer++;
            }
        }


        //열별로도 비슷하게 검사
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i + len <= 8; i++) {
                bool chk = true;
                int up = i, down = i + len - 1;
                for (int k = 0; k < len / 2; k++) {
                    if (v[up][j] != v[down][j]) {
                        chk = false;
                        break;
                    }
                    up++;
                    down--;
                }
                if (chk) answer++;
            }
        }


        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}