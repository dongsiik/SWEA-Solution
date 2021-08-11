// 제목 : 최장 공통 부분 수열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOHEx66kIDFAWr
// 메모리 :  27,336 kb
// 실행시간 : 89 ms

//참고 링크 : https://hsp1116.tistory.com/37

#define _CRT_SECURE_NO_WARNINGS 
#include<iostream>
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
        //문자열 두 개 입력받기
        string s1, s2;
        cin >> s1 >> s2;

        //두고두고 쓸 두 문자열의 길이 저장해두기
        int len1 = s1.length();
        int len2 = s2.length();

        //s1의 i-1번째, s2의 j-1째의 index 이하의 문자열로 구성할 수 있는 최장 공통 부분 수열 길이를 저장할 2차원 배열
        int** LCS = new int* [len1 + 1];
        for (int i = 0; i <= len1; i++) {
            LCS[i] = new int[len2 + 1];
//            for (int j = 0; j <= len2; j++) LCS[i][j] = 0;    //습관적으로 초기화를 위해 만들었지만, 알고보니 초기화를 안 해도 됨...
        }

        //2차원 배열 채우기
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                //한 쪽 문자열을 안 쓴다면, 최장 공통 부분 수열 길이는 0
                if (i == 0 || j == 0) LCS[i][j] = 0;
                //양 끝 글자가 같다면, 최장 공통 부분 수열 길이는 한 글자씩 뺀 것에서 1을 더한 것
                else if (s1[i - 1] == s2[j - 1]) LCS[i][j] = LCS[i - 1][j - 1] + 1;
                //그 밖의 경우
                else LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1]);
            }
        }

        //동적할당 해제
 //       for (int i = 0; i <= len1; i++) delete[] LCS[i];
 //       delete[] LCS;

        //출력
        cout << '#' << test_case << ' ' << LCS[len1][len2] << '\n';

    }
    return 0;
}