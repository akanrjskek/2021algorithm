package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; ++i) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
	}

}
