// 제목 : [S/W 문제해결 기본] 10일차 - 비밀번호
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD
// 메모리 :  21,552 kb
// 실행시간 : 153 ms

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 
import java.io.FileInputStream;
 
 
class Solution
{
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=10;
//      T=sc.nextInt();
         
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            String s = sc.next();
            List<Character> pw = new LinkedList<>();
            for(int i=0;i<n;i++) {
                pw.add(s.charAt(i));
 
            }
             
            int len = n;
            while(true) {
                for(int i=0;i<pw.size()-1;i++) {
                    if(pw.get(i)==pw.get(i+1)) {
                        pw.remove(i+1);
                        pw.remove(i);
                    }
                }
                 
                 
                if(pw.size()==len) break;
                len = pw.size();
            }
             
            System.out.printf("#%d ",test_case);
            for(int i=0;i<pw.size();i++) {
                System.out.printf("%c",pw.get(i));
            }
            System.out.println();
 
        }
         
         
         
        sc.close();
    }
}