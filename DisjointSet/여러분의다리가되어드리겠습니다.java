package DisjointSet;

import java.util.*;
import java.io.*;

public class 여러분의다리가되어드리겠습니다 {
	private static int N;
	private static int[] parent;
	
	private static void init() {
		parent = new int[N+1];
		for(int i = 1; i < N+1; ++i) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	} 
	
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		
		if(x < y) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
		}
	}
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		init();
		for(int i = 0; i < N - 2; ++i) {
			st = new StringTokenizer(bf.readLine());
			int island1 = Integer.parseInt(st.nextToken());
			int island2 = Integer.parseInt(st.nextToken());
			Union(island1, island2);
		}
		for(int i = 1; i < N + 1; ++i) {
			if(parent[i] == i) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
