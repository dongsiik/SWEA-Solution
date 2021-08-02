// 제목 : 
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXVJuEvqLAADFASe
// 메모리 :  12,684 kb
// 실행시간 : 98 ms

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    //테스트 케이스 수 입력받기
    int test_case;
    int T;
    cin >> T;

    //각각의 테스트 케이스에 대하여
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //문자열 입력받기
        string s;
        cin >> s;
        //알파벳마다 몇 개씩 나왔는지 저장해둘 배열 count 선언 및 초기화
        int* count = new int[26];
        for (int i = 0; i < 26; i++) count[i] = 0;

        //문자열 읽으면서 알파벳 개수 기록
        for (int i = 0; i < s.length(); i++) {
            count[s[i] - 'a']++;
        }

        //외로운 알파벳을 저장할 문자열 answer
        string answer = "";

        //알파벳이 홀수 개 있다면, 그 알파벳을 answer에 추가함
        for (int i = 0; i < 26; i++) {
            count[i] = count[i] % 2;
            for (int j = 0; j < count[i]; j++) answer += (i + 'a');
        }
        //추가된 알파벳이 없다면, Good을 저장
        if (answer == "") answer = "Good";


        delete[] count;

        //결과 출력
        cout << "#" << test_case << " " << answer << "\n";


    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}