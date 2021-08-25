// 제목 : [S/W 문제해결 응용] 4일차 - 하나로
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
// 메모리 :  60,564 kb
// 실행시간 : 285 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
   
class Solution
{
 
     
    public static void main(String args[]) throws IOException{
         
        //빠른 입출력을 위한 도구들
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
         
        //각각의 테스트 케이스 마다
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	//정점의 수
            int n = Integer.parseInt(br.readLine());
             
            //정점의 x,y 좌표 입력받기
            Node[] islands = new Node[n];
            for(int i=0;i<n;i++) islands[i] = new Node();
             
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) islands[i].x = Long.parseLong(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) islands[i].y = Long.parseLong(st.nextToken());
             
            //환경 부담 세율 입력받기
            double e = Double.parseDouble(br.readLine());
             
            //PRIM 알고리즘을 위한 방문 여부 배열과 연결된 다른 섬들 사이의 최단 거리 배열
            boolean[] visited = new boolean[n];
            Long[] distance = new Long[n];
            for(int i=0;i<n;i++) distance[i] = Long.MAX_VALUE;
             
            //총 터널의 길이
            Long totalDistance = 0L;
            
            //0번 섬을 시작점으로 하기 위해 거리를 0으로 둠
            distance[0] = 0L;
             
            int current = -1;
            Long minDistance = Long.MAX_VALUE;
             
            for(int v=0;v<n;v++) {
                current = -1;
                minDistance = Long.MAX_VALUE;
                 
                //연결되지 않았으면서 가장 가까운 섬 찾기
                for(int i=0;i<n;i++) {
                    if(!visited[i] && distance[i]<minDistance) {
                        current = i;
                        minDistance = distance[i];
                    }
                }
                 
                //그런 섬이 없으면 그만둠
                if(current==-1) break;
                //섬 방문 처리하고, 총 길이에 더함
                visited[current] = true;
                totalDistance += minDistance;
                 
                //방문하지 않은 나머지 섬들에 대해 최단거리 갱신
                for(int i=0;i<n;i++) {
                    if(!visited[i] && distance[i]>getDistance(islands[current], islands[i]))
                        distance[i] = getDistance(islands[current], islands[i]);
                }
            }
             
            //낼 세금 구하기
            Long answer = Math.round(e * totalDistance);
            //출력문 저장
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        //출력
        System.out.print(sb.toString());
    }
     
    //섬 클래스
    static class Node{
        Long x;
        Long y;
         
    }
     
    //두 섬 사이의 거리 제곱 구하기
    public static Long getDistance(Node a, Node b) {
        return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
    }
}