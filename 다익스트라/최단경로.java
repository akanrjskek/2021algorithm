package ���ͽ�Ʈ��;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node>{
	int end; // ������
	int weight; // ����ġ
	
	public node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(node n) {
		return this.weight - n.weight;
	}
	
}

public class �ִܰ�� {
	private static int V,E,start; // ��������, ��������, ������
	private static ArrayList<node> [] graph; // ���� ���¸� ��Ÿ���� �׷���
	private static boolean[] visit; // ��� �湮 ����
	private static PriorityQueue<node> pq; // ����� ����ġ�� ���� ������� �켱����
	private static int[] distance; // ���������� ������ �������� �ִ� �Ÿ�.
	
	
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
			if(visit[curnode.end]) continue; // �̹� �湮�����ϱ� continue
			visit[curnode.end] = true; // ���� �湮�Ҳ��ϱ� true
			for(node n : graph[curnode.end]) {
				if(distance[n.end] > distance[curnode.end] + n.weight) { 	// ���� distance[n.end]���� ����� �Ÿ��� ª�ٸ� ����.
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
