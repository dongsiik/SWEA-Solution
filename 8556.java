// 제목 : 북북서
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=
// 메모리 :  20,916 kb
// 실행시간 : 129 ms

import java.util.Arrays;
import java.util.Scanner;
  
class Solution
{
    public static int getGcd(int a, int b) {
        while(b!=0) {
            int tmp = a;
            a = b;
            b = tmp%a;      
        }   
        return a;
    }
    
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
    	
        //테스트 케이스 수
        int T;
        T=sc.nextInt();
 
        //테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//문자열을 입력받아 배열에 저장
        	 char[] arr = sc.next().toCharArray();
        	 //분수 표시를 위한 분자 분모
             int bunja;
             int bunmo = 1;
             
             int len = arr.length;
             //맨 마지막이 북쪽이면 초깃값을 정하고, 마지막 5글자를 지움
             if(arr[len-1]=='h') {
                 bunja =0;
                 arr = Arrays.copyOf(arr, len-5);
                 len -= 5;
             }
             //맨 마지막이 서쪽이면 초깃값을 정하고, 마지막 4글자를 지움
             else {
                 bunja = 90;
                 arr = Arrays.copyOf(arr, len-4);
                 len -= 4;
             }
              
             //문자열을 다 지울때까지 문제에서 주어진 작업을 반복
             while(arr.length!=0) {
                 bunmo *= 2;
              
                 if(arr[len-1]=='h') {
                     bunja = 2*bunja - 90;
                     arr = Arrays.copyOf(arr, len-5);
                     len -= 5;
                 }
                 else {
                     bunja = 2*bunja + 90;
                     arr = Arrays.copyOf(arr, len-4);
                     len -= 4;
                 }
             }
              
             //분자 분모의 최대공약수를 구해 기약분수로 만들어줌
             int gcd = getGcd(bunja, bunmo);
             bunja /= gcd;
             bunmo /= gcd;
             //출력
             if(bunmo==1) {
                 System.out.println("#"+test_case+" "+bunja);
             }
             else {
                 System.out.println("#"+test_case+" "+bunja+"/"+bunmo);
             }
        }
        
    }
}