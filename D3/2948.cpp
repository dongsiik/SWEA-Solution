// 제목 : 문자열 교집합
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Un3G64SUDFAXr
// 메모리 :  27,440 kb
// 실행시간 : 2,591 ms

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
#include<algorithm>
#include<vector>

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
        //문자열 집합들의 크기
        int n, m;
        cin >> n >> m;
        
        //크기만큼 문자열의 집합을 벡터로 만들었음
        vector<string> n_words(n);
        vector<string> m_words(m);

        //문자열 입력받기
        for (int i = 0; i < n; i++) {
            cin >> n_words[i];
        } 

        for (int i = 0; i < m; i++) {
            cin >> m_words[i];
        } 

        //사전 순서로 정렬
        sort(n_words.begin(),n_words.end());
        sort(m_words.begin(),m_words.end());

        //두 집합간 비교
        int answer = 0;
        int m_idx = 0;
        for (int i = 0; i < n; i++) {
            while ((m_idx < m) && m_words[m_idx] < n_words[i]) ++m_idx;
            if (m_idx == m ) break;
            if (m_words[m_idx] == n_words[i]) ++answer;
        }

        //출력
        cout << '#' << test_case << ' ' << answer << '\n';

    }
    return 0;
}