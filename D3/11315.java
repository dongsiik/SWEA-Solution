// 제목 : 오목 판정
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ
// 메모리 :  31,032 kb
// 실행시간 : 148 ms

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        //테스트 케이스 수 입력받기
        int T;
        T=sc.nextInt();
 
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//오목이 있는지 없는지를 저장해둘 변수
            boolean exi =false;
             
            //바둑판 정보 입력 받기
            int n = sc.nextInt();
            char[][] board = new char[n][];
            for(int i=0;i<n;i++){
                String s = sc.next();
                board[i] = s.toCharArray();
            }
             
            //가로 검사
            garo : for(int i=0;i<n;i++){
                for(int j=0;j+4<n;j++){
                    if(board[i][j]=='o' && board[i][j+1]=='o' && board[i][j+2]=='o' && board[i][j+3]=='o' && board[i][j+4]=='o'){
                        exi = true;
                        break garo;
                    }
                }
            }
            //세로 검사
            if(exi==false){
                sero : for(int j=0;j<n;j++){
                    for(int i=0;i+4<n;i++){
                        if(board[i][j]=='o' && board[i+1][j]=='o' && board[i+2][j]=='o' && board[i+3][j]=='o' && board[i+4][j]=='o'){
                            exi = true;
                            break sero;
                        }
                    }
                }           
            }
            //대각1 검사
            if(exi==false){
                dae1 : for(int i=0;i+4<n;i++){
                    for(int j=0;j+4<n;j++){
                        if(board[i][j]=='o' && board[i+1][j+1]=='o' && board[i+2][j+2]=='o' && board[i+3][j+3]=='o' && board[i+4][j+4]=='o'){
                            exi = true;
                            break dae1;
                        }
                    }
                }   
            }
             
            //대각2 검사
            if(exi==false){
                dae2 : for(int i=0;i+4<n;i++){
                    for(int j=n-1;j-4>=0;j--){
                        if(board[i][j]=='o' && board[i+1][j-1]=='o' && board[i+2][j-2]=='o' && board[i+3][j-3]=='o' && board[i+4][j-4]=='o'){
                            exi = true;
                            break dae2;
                        }
                    }
                }
            }
                            
           
                            
             
            if(exi) System.out.println("#"+test_case+" YES");
            else System.out.println("#"+test_case+" NO");
             
        }
    }
}