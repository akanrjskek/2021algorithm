package Lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���ͽ�Ʈ�� {
	private static int v,e;
	private static int[][] adj;
	private static int[] distance;
	private static boolean[] visit;
	public static void dijkstra(int[][] adj) {
		distance = new int[v];
		visit = new boolean[v];
		
		for (int i = 0; i < adj.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0; 
		for (int i = 0; i < v; i++) {
			int minvertex = findminvertex();
			visit[minvertex] = true;
			for (int j = 0; j < v; j++) {
				if(adj[minvertex][j] != 0 && distance[minvertex] != Integer.MAX_VALUE && !visit[j]) { // 1. ���� vertex���� j���� ���� Ȯ��, 2. ������� �ƴ��̻� distance�� ������Ʈ ���־���Ѵ�. 3. minvertex�� ������� Ȯ��.
					int newdistance = adj[minvertex][j] + distance[minvertex]; // ���� vertex���� j������ �Ÿ� + ���� vertex������ �Ÿ�
					if(newdistance < distance[j]) {
						distance[j] = newdistance;
					}
				}
				
			}
		}
		for (int i = 0; i < adj.length; i++) {
			System.out.println(i + "������ �ִܰŸ� : " + distance[i]);
		}
	}
	
	public static int findminvertex() {
		int minvalue = -1;
		for (int i = 0; i < v; i++) {
			if(!visit[i] && (minvalue == -1 || distance[i] < distance[minvalue])) { // �湮���߰� distance�� ���� ª�� vertex
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
		dijkstra(adj);
	}
}

