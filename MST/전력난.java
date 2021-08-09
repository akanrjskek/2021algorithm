package MST;
import java.io.*;
import java.util.*;

public class Àü·Â³­ {
	private static class Node implements Comparable<Node>{
		int start;
		int end;
		int weight;
		
		Node(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
		
		
	}
	private static int N,M;
	private static PriorityQueue<Node> pq;
	private static int[] parent;
	private static int cnt = 0;
	private static int sum = 0;
	private static int answer = 0;
	private static int min_value = Integer.MAX_VALUE;
	private static void Kruskal() {
		init();
		while(cnt != N - 1) {
			Node n = pq.poll();
			int start = n.start;
			int end = n.end;
			int weight = n.weight;
			if(find(start) == find(end)) continue;
			Union(start,end);
			answer += weight;
			cnt++;
		}
	}
	
	private static void init() {
		parent = new int[N];
		for(int i = 0; i < N; ++i) {
			parent[i] = i;
		}
		
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void Union(int x, int y) {
		x = parent[x];
		y = parent[y];
		
		if(x == y) return;
		
		if(x > y) {
			parent[x] = y;
		}
		else {
			parent[y] = x;
		}
	}
	public static void main(String[] args) throws Exception{
		while(true) {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if(N == 0) return;
		pq = new PriorityQueue<>();
		for(int i = 0; i < M + 1; ++i) {
			st = new StringTokenizer(bf.readLine());
			if(i == M) {
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				break;
			}
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sum += c;
			pq.add(new Node(a,b,c));
		}
		Kruskal();
		answer = sum - answer;
		}
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
