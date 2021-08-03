// 제목 : 규영이와 인영이의 카드게임
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 메모리 :  ???
// 실행시간 : ???
// 이 카드는 테스트 케이스를 통과하지만, 제출하면 제한시간 초과와 함께 0개를 통과했다고 나옵니다. 원인을 찾아주세요!

#define _CRT_SECURE_NO_WARNINGS 
#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int T;
	scanf("%d", &T);
	
	for (int test_case = 1; test_case <= T; ++test_case)
	{
		int* cards = new int[18];
		for (int i = 0; i < 18; i++) cards[i] = i + 1;
		int* gyu = new int[9];
		int* inn = new int[9];

		for (int i = 0; i < 9; i++) {
			scanf("%d", &gyu[i]);
			cards[gyu[i] - 1] = 0;
		}
		sort(cards, cards + 18);
		copy(cards + 9, cards + 18, inn);
		int win = 0;
		int lose = 0;

		do {
			int gyuSum = 0;
			int innSum = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > inn[i]) gyuSum += (gyu[i] + inn[i]);
				if (gyu[i] < inn[i]) innSum += (gyu[i] + inn[i]);
				if (gyuSum > 171 || innSum>171) break;
			}
			if (gyuSum > innSum) win++;
			if (gyuSum < innSum) lose++;
		} while (next_permutation(inn, inn + 9));

		printf("#%d %d %d\n",test_case,win,lose);

		delete[] gyu;
		delete[] inn;
		delete[] cards;

	}
	return 0;
}