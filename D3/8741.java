// 제목 : 두문자어
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW2y6n3qPXQDFATy
// 메모리 :  21,240 kb
// 실행시간 : 137 ms

import java.util.Scanner;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수
        int T;
        T=sc.nextInt();
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//단어별로 첫 번째 글자를 읽은 후, ASCII 값을 활용해서 대문자로 바꿔줌
            char a = (char)(sc.next().charAt(0)-32);
            char b = (char)(sc.next().charAt(0)-32);
            char c = (char)(sc.next().charAt(0)-32);
             
            //출력
            System.out.println("#"+test_case+" "+a+b+c);
        }
          
        sc.close();
    }
}