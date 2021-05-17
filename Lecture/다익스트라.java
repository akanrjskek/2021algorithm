package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다익스트라 {
	private static int v,e;
	private static int[][] adj;
	private static int[] distance;
	private static boolean[] visit;
	
	private static void dijkstra() {
		distance = new int[v];
		visit = new boolean[v];
		for (int i = 0; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		for (int i = 0; i < v; i++) {
			int minvertex = find_minvertex();
			visit[minvertex] = true;
			for (int j = 0; j < v; j++) {
				if(adj[minvertex][j] != 0 && !visit[j] && distance[minvertex] != Integer.MAX_VALUE){
					int newdist = distance[minvertex] + adj[minvertex][j];
					if(newdist < distance[j]) {
						distance[j] = newdist;
					}
				}
			}
		}
		
		for (int j = 0; j < adj.length; j++) {
			System.out.println(j + " " + distance[j]);
		}
	}
	
	private static int find_minvertex() {
		int min = -1;
		for (int i = 0; i < v; i++) {
			if(!visit[i] && (min == -1 || distance[i] < distance[min])) {
				min = i;
			}
		}
		return min;
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

