package 다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node>{
	int end; // 도착지
	int weight; // 가중치
	
	public node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(node n) {
		return this.weight - n.weight;
	}
	
}

public class 최단경로 {
	private static int V,E,start; // 정점개수, 간선개수, 시작점
	private static ArrayList<node> [] graph; // 연결 상태를 나타내는 그래프
	private static boolean[] visit; // 노드 방문 여부
	private static PriorityQueue<node> pq; // 노드의 가중치가 낮은 순서대로 우선순위
	private static int[] distance; // 시작점에서 각각의 노드까지의 최단 거리.
	
	
	private static void dijkstra(int start) {
		pq = new PriorityQueue<node>();
		distance = new int[V+1];
		visit = new boolean[V+1];
		for(int i = 1; i < V+1; ++i) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		pq.add(new node(start,0));
		
		while(!pq.isEmpty()) {
			node curnode = pq.poll();
			if(visit[curnode.end]) continue; // 이미 방문했으니까 continue
			visit[curnode.end] = true; // 이제 방문할꺼니까 true
			for(node n : graph[curnode.end]) {
				if(distance[n.end] > distance[curnode.end] + n.weight) { 	// 현재 distance[n.end]보다 계산한 거리가 짧다면 갱신.
					distance[n.end] = distance[curnode.end] + n.weight;
					pq.add(new node(n.end,distance[n.end]));
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(bf.readLine());
		graph = new ArrayList[V+1];
		for(int i = 1; i < V+1; ++i) {
			graph[i] = new ArrayList<node>();
		}
		
		int s,e,w;
		for(int i = 0; i < E ; ++i) {
			st = new StringTokenizer(bf.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			graph[s].add(new node(e,w));
		}
		dijkstra(start);
		for(int i = 1; i < V+1; ++i) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

}
