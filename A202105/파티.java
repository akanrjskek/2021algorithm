package A202105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ÆÄÆ¼ {
	private static int N,M,X,distance[],adj[][], answer[];
	private static boolean visit[];
	
	private static void dijkstra(int start) {
		distance = new int[N+1];
		visit = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		
		for (int i = 1; i <= N; i++) {
			int minvertex = find_minvertex();
			visit[minvertex] = true;
			for (int j = 1; j <= N; j++) {
				if(!visit[j] && adj[minvertex][j] != 0 && distance[minvertex] != Integer.MAX_VALUE) {
					int mindistance = adj[minvertex][j] + distance[minvertex];
					if(mindistance < distance[j]) distance[j] = mindistance;
				}
			}
		}
		if(start == X) {
			for (int i = 1; i <= N; i++) {
				answer[i] += distance[i];
			}
		}
		else {
			answer[start] += distance[X];
		}
	}
	
	private static int find_minvertex() {
		int minvertex = -1;
		for (int i = 1; i <= N; i++) {
			if(!visit[i] && (minvertex == -1 || distance[i] < distance[minvertex])) {
				minvertex = i;
			}
		}
		return minvertex;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		answer = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[v1][v2] = weight;
		}
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		Arrays.sort(answer);
		System.out.println(answer[answer.length-1]);
		
	}
}
