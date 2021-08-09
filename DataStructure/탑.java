package DataStructure;
import java.io.*;
import java.util.*;

public class ž {
	
	static class Top{
		int index;
		int height;
		
		Top(int index, int height){
			this.index = index;
			this.height = height;
		}
	}
	
	private static int N;
	private static Stack<Top> top;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		top = new Stack<>();
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= N; ++i) {
			int input = Integer.parseInt(st.nextToken());
			while(!top.isEmpty()) {
				if(top.peek().height >= input) {
					sb.append(top.peek().index + " ");
					break;
				}
				
				top.pop();
			}
			if(top.isEmpty()) {
				sb.append(0 + " ");
			}
			
			top.push(new Top(i,input));
		}
		System.out.println(sb);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
