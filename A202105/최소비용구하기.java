package A202105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	private static int N, M, distance[], adj[][];
	private static boolean visit[];
	private static int start, end;

	private static void dijkstra() {
		distance = new int[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		
		for (int i = 0; i < N; i++) {
			int minvertex = find_minvertex();
			visit[minvertex] = true;
			for (int j = 1; j <= N; j++) {
				if(!visit[j] && adj[minvertex][j] != -1 && distance[minvertex] != Integer.MAX_VALUE) {
					int mindistance = adj[minvertex][j] + distance[minvertex];
					if(mindistance < distance[j]) {
						distance[j] = mindistance;
					}
				}
			}
		}
		System.out.println(distance[end]);
	}

	private static int find_minvertex() {
		int minvertex = -1;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && (minvertex == -1 || distance[i] < distance[minvertex])) {
				minvertex = i;
			}
		}
		return minvertex;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		adj = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = -1;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(adj[v1][v2] == -1 || adj[v1][v2] > weight) adj[v1][v2] = weight;
		}
		st = new StringTokenizer(bf.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra();
	}
}
