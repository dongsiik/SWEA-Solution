// 제목 : 민정이와 광직이의 알파벳 공부
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXAdrmW61ssDFAXq
// 메모리 :  12,688 kb
// 실행시간 : 22 ms

#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<vector>

using namespace std;

int set[26];    //현재 세트의 알파벳별로 개수
vector<string> words;   //단어 목록
int n;  //단어 개수
int answer; //세트가 잘 구성되었는지를 나타냄

//세트에 단어를 추가한 이후 알파벳별 개수를 갱신하는 함수
void addWord(string s) {
    for (int i = 0; i < s.size(); i++) {
        set[s[i] - 'a']++;
    }
}

//세트에서 단어를 뺀 후 알파벳별 개수를 갱신하는 함수
void subWord(string s) {
    for (int i = 0; i < s.size(); i++) {
        set[s[i] - 'a']--;
    }
}

//단어 세트에 알파벳이 적어도 하나씩 있는지 확인하는 함수
bool checkSet() {
    for (int i = 0; i < 26; i++) {
        if (set[i] < 1) return false;
    }
    return true;
}

//재귀적으로 단어를 추가하는 함수
void DFS(int index) {
    if (index == words.size()) return;

    for (int i = index; i < words.size(); i++) {
        addWord(words[i]);
        if (checkSet()) {
            answer++;
        }

        DFS(i + 1);
        subWord(words[i]);

    }
}
int main(int argc, char** argv)
{
    //테스트 케이스 수
    int T;
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        //전역변수 초기화
        answer = 0;
        fill(set, set + 26, 0);
        words.clear();
        cin >> n;

        //단어 입력받기
        for (int i = 0; i < n; i++) {
            string s;
            cin >> s;
            words.push_back(s);
        }

        
        DFS(0);

        //결과 출력
        cout << "#" << test_case << " " << answer << "\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}