package MST;
import java.util.*;
import java.io.*;

public class 최소스패닝트리 {
	
	private static class node implements Comparable<node>{
		int start;
		int end;
		int weight;
		
		node(int start,int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(node o) {
			return this.weight - o.weight;
		}
	}
	
	private static int V,E;
	private static PriorityQueue<node> nodes;
	private static int[] parent;
	private static int cnt = 0;
	private static int answer = 0;
	
	private static void Kruskal(){
		while(!nodes.isEmpty()) {
			if(cnt == V - 1) break;
			node n = nodes.poll();
			if(find(n.start) == find(n.end)) continue;
			Union(n.start, n.end);
			answer += n.weight;
			cnt++;
		}
	}
	
	private static void init() {
		for(int i = 1; i <= V; ++i) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
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
		st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodes = new PriorityQueue<>();
		parent = new int[V+1];
		
		for(int i = 0; i < E; ++i) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes.add(new node(start,end,weight));
		}
		init();
		Kruskal();
		System.out.println(answer);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
