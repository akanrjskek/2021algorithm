package MST;
import java.io.*;
import java.util.*;

public class 최소스패닝트리_프림 {
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node n){
			return this.weight - n.weight;
		}
		
	}
	private static int N,M;
	private static boolean[] visit;
	private static PriorityQueue<Node> pq;
	private static ArrayList<Node>[] list;
	private static int cnt = 0;
	private static int answer = 0;
	
	private static void prim() {
		pq = new PriorityQueue<>();
		visit = new boolean[N+1];
		visit[1] = true;
		for(int i = 0; i < list[1].size(); ++i) {
			pq.add(new Node(list[1].get(i).end,list[1].get(i).weight));
		}
		while(!pq.isEmpty() || cnt != N-1) {
			Node n = pq.poll();
			if(visit[n.end]) continue;
			visit[n.end] = true;
			cnt++;
			answer += n.weight;
			for(int i = 0; i < list[n.end].size(); ++i) {
				pq.add(new Node(list[n.end].get(i).end,list[n.end].get(i).weight));
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i = 1; i < N + 1; ++i) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[node1].add(new Node(node2,weight));
			list[node2].add(new Node(node1,weight));
		}
		prim();
		System.out.println(answer);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
