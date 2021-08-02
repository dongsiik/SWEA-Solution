// 제목 : 직사각형과 점
// 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWhT_2HKQNADFAW_
// 메모리 :  71,044 kb
// 실행시간 : 229 ms

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        //각각의 테스트 케이스마다
        for(int t=1;t<=T;t++) {
        	//각각의 경우의 수
        	int case1=0;
        	int case2=0;
        	int case3=0;
        	
        	//직사각형 네 모서리 정보 입력
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());    	
        	
        	//점의 개수를 입력받고, 점마다 판별
        	int n = Integer.parseInt(br.readLine());
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	
            	if(x>x1 && x<x2 && y>y1 && y<y2) case1++;
            	else if(x<x1 || x>x2 || y<y1 || y>y2) case3++;
            	else case2++;
        	}

        	//결과 저장
        	sb.append('#').append(t).append(' ').append(case1).append(' ').append(case2).append(' ').append(case3).append('\n');
        }
        //출력
        System.out.println(sb);
    }
}