package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class UnionFind {
	private static int N,M;
	private static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		init();
		int r,n1,n2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			r = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if(r == 0) {
				Union(n1,n2);
			}
			else {
				if(find(n1) != find(n2)) {
					sb.append("NO\n");
				}
				else {
					sb.append("YES\n");
				}
			}
		}
		System.out.println(sb);
	}
	private static void init() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		else {
			int b = find(parent[a]);
			parent[a] = b;
			return b;
		}
	}
	
	private static void Union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[a] = b;
		}
	}
	

}
