// 제목 : 0/1 Knapsack
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr
// 메모리 :  12,812 kb
// 실행시간 : 11 ms

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
        //물건 수, 가방 부피 입력받기
        int n, k;
        cin >> n >> k;

        //k만큼 채웠을 때 가치 최댓값을 저장할 배열을 만들고 초기화
        int* bag = new int[k + 1];
        for (int i = 0; i <= k; i++) bag[i] = 0;

        //물품 정보를 입력받으며 DP로 계산
        for (int i = 0; i < n; i++) {
            int volume, value;
            cin >> volume >> value;
            for (int j = k; j >= volume; j--) {
                bag[j] = max(bag[j], bag[j - volume] + value);
            }
        }

        //출력
        cout << '#' << test_case << ' ' << bag[k] << '\n';

    }
    return 0;
}