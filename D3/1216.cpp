// 제목 : [S/W 문제해결 기본] 3일차 - 회문2
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14Rq5aABUCFAYi
// 메모리 :  12,684 kb
// 실행시간 : 226 ms
// 실행시간이 무척 길게 나오는 편입니다. 이유를 아시는 분은 제보 바랍니다.

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<vector>
#include<string>

using namespace std;

//문자판 v에 len길이의 회문이 있다면 true, 아니라면 false를 리턴
bool existence(vector<string>& v, int len) {
    //행별로 검사, i,j위치에서 가로로 len칸인 회문이 있는지 확인
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j + len <= 100; j++) {
            bool chk = true;
            int left = j, right = j + len - 1;
            //양끝부터 확인해서 같다면 true 리턴
            for (int k = 0; k < len / 2; k++) {
                if (v[i][left] != v[i][right]) {
                    chk = false;
                    break;
                }
                left++;
                right--;
            }
            if (chk) return true;
        }
    }


    //열별로도 비슷하게 검사
    for (int j = 0; j < 100; j++) {
        for (int i = 0; i + len <= 100; i++) {
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
            if (chk) return true;
        }
    }

    return false;
}

int main(int argc, char** argv)
{

    int test_case;
    int T=10;  //테스트 케이스 수, 10으로 주어짐

    //cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //테스트 케이스 번호 거르기
        cin >> test_case;

        //글자판 입력받기
        vector<string> v(100);
        for (int i = 0; i < 100; i++) cin >> v[i];

        //찾은 회문의 개수
        int answer = 1;

        //최대 길이를 찾으므로 100부터 찾고, 찾는 즉시 그만둠
        for (int len = 100; len >1; len--) {
            if (existence(v, len)) {
                answer = len;
                break;
            }
        }
  
        //출력
        cout << '#' << test_case << ' ' << answer << '\n';
    }

    return 0;
}