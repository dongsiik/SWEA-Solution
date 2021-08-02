// 제목 : 신뢰
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXSVc1TqEAYDFAQT
// 메모리 :  41,528 kb
// 실행시간 : 209 ms

import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 수 입력
        int T;
        T=sc.nextInt();
 
        //각각의 테스트 케이스에 대하여
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//총 걸린 시간
            int time = 0;
             
            //명령어의 수만큼 명령을 입력받도록 robo(어느 로봇인지) pos(어느 위치의 버튼인지) 배열을 만듦
            int n =sc.nextInt();
            char[] robo = new char[n];
            int[] pos = new int[n];
 
            //명령 입력
            for(int i=0;i<n;i++) {
                robo[i] = sc.next().charAt(0);
                pos[i] = sc.nextInt();
            }
            
            //로봇이 나중에 할일이 있는지를 indexOf로 편히 찾기 위해 robo와 내용이 같은 String robot 선언
            String robot = new String(robo);
            
            //로봇 각각의 현재 위치
            int orange = 1;
            int blue = 1;
                         
            //명령들에 대해서
            for(int i=0;i<n;i++) {
            	//블루가 일할 차례라면
                if(robo[i]=='B') {
                	//현재 위치에서 이동해서 버튼 누르기까지 걸리는 시간만큼 time에 추가하고, 블루를 버튼 위치로 이동
                    int duration = Math.abs(blue-pos[i])+1;
                    time+=duration;
                    blue = pos[i];

                    //오렌지가 이후에 할 일이 있는지 확인
                    int OrangeTarget = robot.indexOf('O', i);
                    //할 일이 있다면 오렌지는 블루가 쓴 시간만큼 할 일이 있는 버튼쪽으로 이동
                    if(OrangeTarget != -1) {
                        int nextDuration = Math.abs(orange-pos[OrangeTarget]);
                        if(nextDuration<=duration) orange = pos[OrangeTarget];
                        else {
                            if(orange>pos[OrangeTarget]) orange -= duration;
                            else orange += duration;
                        }
                    }
                }
                //오렌지가 일할 차례라면 비슷하게 처리
                else {
                    int duration = Math.abs(orange-pos[i])+1;
                    time += duration;
                    orange = pos[i];
                    int blueTarget = robot.indexOf('B', i);
                    if(blueTarget != -1) {
                        int nextDuration = Math.abs(blue-pos[blueTarget]);
                        if(nextDuration<=duration) blue = pos[blueTarget];
                        else {
                            if(blue>pos[blueTarget]) blue-= duration;
                            else blue += duration;
                        }
                    }
                }
                 
            }
            //결과 출력
            System.out.println("#"+test_case+" "+time);
        }
         
         
         
        sc.close();
    }
}