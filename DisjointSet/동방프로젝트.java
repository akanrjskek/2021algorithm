package DisjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동방프로젝트 {
	private static int N,M;
	private static int[] parent;
	private static int cnt = 0;
	private static void init() {
		parent = new int[N+1];
		for(int i = 1; i < N + 1; ++i) {
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
			parent[x] = y;
		}
		else {
			parent[y] = x;
		}
	}
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		init();
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int room1 = Integer.parseInt(st.nextToken());
			int room2 = Integer.parseInt(st.nextToken());
			for(int j = room1; j < room2; ++j) {
				Union(j,j+1);
			}
		}
		
		for(int i = 1; i < N+1; ++i) {
			if(parent[i] == i) cnt++;
		}
		
		System.out.println(cnt);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
