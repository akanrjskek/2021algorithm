package MST;
import java.util.*;
import java.io.*;

public class 네트워크연결 {
	private static class Node implements Comparable<Node>{
		int start;
		int end;
		int weight;
		
		Node(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	private static int N,M;
	private static PriorityQueue<Node> q;
	private static int parent[];
	private static int cnt = 0;
	private static int answer = 0;
	
	private static void init() {
		for(int i = 1; i <= N; ++i) parent[i] = i;
	}
	
	private static int find(int x) {
		if(parent[x] == x ) return x;
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
	
	private static void kruSkal() {
		while(!q.isEmpty()) {
			if(cnt == N-1) break;
			Node n = q.poll();
			if(find(n.start) == find(n.end)) continue;
			Union(n.start, n.end);
			answer += n.weight;
			cnt++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		q = new PriorityQueue<>();
		parent = new int[N+1];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			q.add(new Node(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		init();
		kruSkal();
		System.out.println(answer);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
