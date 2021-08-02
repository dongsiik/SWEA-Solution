import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//한글 깨지니?
class Solution
{
	
	public static void main(String args[]) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			sb.append('#').append(t).append(' ');
			int n = Integer.parseInt(br.readLine());
			StringTokenizer sentences = new StringTokenizer(br.readLine(),".!?");
			while(sentences.hasMoreTokens()) {
				int name=0;
				StringTokenizer sentence = new StringTokenizer(sentences.nextToken());
				while(sentence.hasMoreTokens()) {
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
		
		System.out.println(sb);
    
    }
}