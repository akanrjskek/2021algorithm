package MST;
import java.io.*;
import java.util.*;

public class 도시분할계획 {
	static class Node implements Comparable<Node>{
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
	private static int answer = 0;
	
	private static void Kruskal() {
		init();
		while(cnt != N - 2) {
			Node n = pq.poll();
			if(find(n.start) == find(n.end)) continue;
			Union(n.start, n.end);
			answer += n.weight;
			cnt++;
		}
	}
	
	private static void init() {
		for(int i = 1; i <= N; ++i) {
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
		
		if(x > y) {
			parent[x] = y;
		}
		else{
			parent[y] = x;
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		pq = new PriorityQueue<>();
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Kruskal();
		System.out.println(answer);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
