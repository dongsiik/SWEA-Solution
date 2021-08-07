// 제목 : 통역사 성경이
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqPvqoqSLQDFAT_
// 메모리 :  18,664 kb
// 실행시간 : 101 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        //테스트 케이스 마다
        for(int t=1;t<=T;t++) {
        	//출력문 머릿말
            sb.append('#').append(t).append(' ');
            
            //문장 수
            int n = Integer.parseInt(br.readLine());
            //구두점으로 문장들 구분하기
            StringTokenizer sentences = new StringTokenizer(br.readLine(),".!?");
            //문장별로
            while(sentences.hasMoreTokens()) {
            	//이름의 수
                int name=0;
                //공백으로 단어 구분하기
                StringTokenizer sentence = new StringTokenizer(sentences.nextToken());
                //단어별로
                while(sentence.hasMoreTokens()) {
                	//조건에 맞는지 확인
                    String word = sentence.nextToken();
                    if(word=="") continue;
                    boolean chk=true;
                    if(!Character.isUpperCase(word.charAt(0))) chk=false;
                    if(chk) {
                        for(int i=1;i<word.length();i++) {
                            if(!Character.isLowerCase(word.charAt(i))) {
                                chk=false;
                                break;
                            }
                        }
                    }
                    if(chk) name++;
                }
                sb.append(name).append(' ');
            }
             
             
             
            sb.append('\n');
        }
         //출력
        System.out.print(sb.toString());
    }
}