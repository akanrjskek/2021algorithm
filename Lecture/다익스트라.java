package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다익스트라 {
	private static int v,e, adj[][]; // vertex, edge, 인접경로 2차원배열
	private static int distance[];
	private static boolean visit[];
	
	private static void dijkstra() {
		distance = new int[v];
		visit = new boolean[v];
		for (int i = 0; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		
		for (int i = 0; i < v; i++) {
			int minvertex = findminvertex();
			visit[minvertex] = true;
			for (int j = 0; j < v; j++) {
				if(!visit[j] && adj[minvertex][j] != 0 && distance[minvertex] != Integer.MAX_VALUE){
					int dis = adj[minvertex][j] + distance[minvertex];
					if(dis < distance[j]) {
						distance[j] = dis;
					}
				}
			}
		}
		
		for (int j = 0; j < v; j++) {
			System.out.println(j + "까지의 최단 거리 : " + distance[j]);
		}
	}
	
	private static int findminvertex() {
		int minvalue = -1;
		for (int i = 0; i < v; i++) {
			if(!visit[i] && (minvalue == -1 || distance[i] < distance[minvalue])) {
				minvalue = i;
			}
		}
		return minvalue;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		adj = new int[v][v];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[v1][v2] = weight;
			adj[v2][v1] = weight;
		}
		dijkstra();
		
	}
}

