// 제목 : [S/W 문제해결 기본] 8일차 - 암호문3
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14zIwqAHwCFAYD
// 메모리 :  12,684 kb
// 실행시간 : 54 ms
//1230의 코드는, 1228, 1229를 포함하므로 1229를 따로 올리지는 않겠습니다.

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<string>
#include<list>

using namespace std;


int main(int argc, char** argv)
{
//    cin.tie(0);
//    ios::sync_with_stdio(0);

    int test_case;
    int T=10;  //테스트 케이스 수, 10으로 주어짐

    //디버깅을 위해 연습용 input 파일을 사용
  //  freopen("input.txt", "r", stdin);
   // cin >> T;

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //list로 구현한 암호문
        list<int> message;

        //암호문 초깃값 입력받기
        int n;
        cin >> n;
        for (int i = 0; i < n; i++) {
            int word;
            cin >> word;
            message.push_back(word);
        }

        //명령어 입력받기
        cin >> n;
        for (int i = 0; i < n; i++) {
            char type;
            int x, y;
            //명령어의 종류를 입력받고, 종류에 따라 명령 처리
            cin >> type;
            switch (type) {
            //삽입 명령
            case 'I':{
                cin >> x >> y;
                //x번째 위치를 가리킬 iterator
                auto it = message.begin();
                advance(it, x);
                //y개 만큼 숫자 입력받아서 넣기
                for (int j = 0; j < y; j++) {
                    int word;
                    cin >> word;
                    message.insert(it, word);
                }
                break;
            }
            //삭제 명령
            case 'D':{
                cin >> x >> y;
                //x번째 위치를 가리킬 iterator
                auto it = message.begin();
                advance(it, x);
                //y개만큼 숫자 지우기
                for (int j = 0; j < y; j++) it = message.erase(it);
                break;
            }
            //추가 명령
            case 'A':
                //y개만큼 끝에 숫자 넣기
                cin >> y;
                for (int j = 0; j < y; j++) {
                    int word;
                    cin >> word;
                    message.push_back(word);
                }
                break;
            }

        }

        //처음 10개 출력
        auto it = message.begin();
        cout << '#' << test_case << ' ';
        for (int i = 0; i < 10; i++) {
            cout << *it << ' ';
            it++;
        }
        cout << '\n';
    }

    return 0;
}