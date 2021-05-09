package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다익스트라 {
	private static int v,e;
	private static int[][] adj;
	public static void dijkstra(int[][] adj) {
		int v = adj.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		
		for (int i = 0; i < v - 1; i++) {
			// find vertex with min distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			// explore neighbors
			for(int j = 0; j < v; ++j) {
				if(adj[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
					int newDist = distance[minVertex] + adj[minVertex][j];
					if(newDist < distance[j]) {
						distance[j] = newDist;
					}
				}
			}
			 
		}
		
		for (int i = 0; i < v; i++) {
			System.out.println(i + " " + distance[i]);
		}
	}
	
	public static int findMinVertex(int[] distance, boolean visited[]) {
		int minvertex = -1;
		for (int i = 0; i < distance.length; i++) {
			if(!visited[i] && (minvertex == -1 || distance[i] < distance[minvertex])) {
				minvertex = i;
			}
		}
		return minvertex;
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
		dijkstra(adj);
	}
}

