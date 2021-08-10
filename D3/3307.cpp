// 제목 : 최장 증가 부분 수열
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
// 메모리 :  12,684 kb
// 실행시간 : 6 ms

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

    //테스트 케이스 마다
    for (test_case = 1; test_case <= T; ++test_case)
    {
        //n은 수열의 길이, arr는 수열
        int n;
        cin >> n;
        int* arr = new int[n];

        //LIS[n]은 길이가 n이면서 가장 작은 수들로 구성된 증가 부분 수열의 마지막 값
        int* LIS = new int[n+1];
        //현재까지 구한 증가 부분 수열 길이의 최댓값보다 1 큰 값;
        int size = 1;

        //수열 입력 및 LIS값 초기화
        for (int i = 0; i < n; i++) cin >> arr[i];
        for (int i = 0; i <= n; i++) LIS[i] = 0;
        
        //수열의 원소들마다
        for (int i = 0; i < n; i++) {
            //여러 길이의 증가 부분 수열 중에 이 원소를 꼬리로 붙일 가장 긴 증가 부분 수열 찾기
            int pos = upper_bound(LIS, LIS + size, arr[i])-LIS;
            //현재 만들어놓은 증가 부분 수열의 꼬리가 다 현재값 이하라면, 최대 길이 수열에 이 원소를 붙임
            if (pos == size) LIS[size++] = arr[i];
            //아니라면 현재값보다 바로 다음으로 큰 꼬리를 현재값으로 갈아끼움
            else LIS[pos] = arr[i];
        }

        cout << '#' << test_case << ' ' << size-1 << '\n';

        delete[] LIS;
        delete[] arr;
    }
    return 0;
}