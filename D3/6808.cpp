// 제목 : 규영이와 인영이의 카드게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 메모리 :  12,688 kb
// 실행시간 : 2,340 ms

#define _CRT_SECURE_NO_WARNINGS 
#include <iostream>
#include <algorithm>
 
using namespace std;
 
bool next_permu(int* arr){
 
    int len = 9;
    int i = len - 1;
    while (i > 0 && arr[i - 1] > arr[i]) i--;
    if (i == 0) return false;
 
    int j = len - 1;
    while (arr[i - 1] >= arr[j]) j--;
 
    int temp = arr[i - 1];
    arr[i - 1] = arr[j];
    arr[j] = temp;
 
    int k = len - 1;
    while (i < k) {
        temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
        i++;
        k--;
    }
 
    return true;
}
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(false);
//  cin.tie(NULL);
//  cout.tie(NULL);
 
    int T;
    cin >> T;
     
    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int cards[18] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18 };
        int gyu[9];
        int inn[9];
 
        for (int i = 0; i < 9; i++) {
            cin >> gyu[i];
            cards[gyu[i] - 1] = 0;
        }
        sort(cards, cards + 18);
        copy(cards + 9, cards + 18, inn);
        int win = 0;
 
        do {
            int gyuSum = 0;
            int innSum = 0;
            for (int i = 0; i < 9; i++) {
                if (gyu[i] > inn[i]) gyuSum += (gyu[i] + inn[i]);
                if (gyu[i] < inn[i]) innSum += (gyu[i] + inn[i]);
                if (gyuSum > 171 || innSum>171) break;
            }
            if (gyuSum > innSum) win++;
        } while (next_permu(inn));
 
        int lose = 362880 - win;
 
        cout << '#' << test_case << ' ' << win << ' ' << lose << '\n';
 
    }
    return 0;
}