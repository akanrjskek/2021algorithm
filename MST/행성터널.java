package MST;

import java.io.*;
import java.util.*;

public class 행성터널 {
	static class Node{
		int index;
		int x;
		int y;
		int z;
		
		Node(int index, int x, int y, int z){
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	private static int N;
	private static Node[] list;
	private static PriorityQueue<Edge> q;
	private static int parent[];
	private static int cnt = 0;
	private static int answer = 0;
	
	private static void init() {
		for(int i = 0; i <N; ++i) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void Union(int x, int y) {
		int px = parent[x];
		int py = parent[y];
		
		if(px == py) return;
		
		if(px > py) {
			parent[py] = px;
		}
		else {
			parent[px] = py;
		}
	}
	
	
	private static void kruskal() {
		init();
		while(cnt != N - 1) {
			Edge e = q.poll();
			int start = e.start;
			int end = e.end;
			int weight = e.weight;
			if(find(start) == find(end)) continue;
			Union(start,end);
			cnt++;
			answer += weight;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		list = new Node[N];
		parent = new int[N];
		q = new PriorityQueue<>();
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(bf.readLine());
			list[i] = new Node(i, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list, (n1,n2) -> n1.x - n2.x);
		for(int i = 0; i < N - 1; ++i) {
			q.add(new Edge(list[i].index, list[i + 1].index, Math.abs(list[i].x - list[i + 1].x)));
		}
		Arrays.sort(list, (n1,n2) -> n1.y - n2.y);
		for(int i = 0; i < N - 1; ++i) {
			q.add(new Edge(list[i].index, list[i + 1].index, Math.abs(list[i].y - list[i + 1].y)));
		}
		Arrays.sort(list, (n1,n2) -> n1.z - n2.z);
		for(int i = 0; i < N - 1; ++i) {
			q.add(new Edge(list[i].index, list[i + 1].index, Math.abs(list[i].z - list[i + 1].z)));
		}
		
		kruskal();
		System.out.println(answer);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st; 
}
