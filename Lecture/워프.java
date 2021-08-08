package Lecture;

import java.io.*;
import java.util.*;

public class ฟ๖วม {
	private static class NodeStatus  implements Comparable<NodeStatus>{
		int now;
		int warp;
		long distance;
		NodeStatus(int a, int b, long c){
			this.now = a;
			this.warp = b;
			this.distance = c;
		}
		@Override
		public int compareTo(NodeStatus target) {
	        return this.distance <= target.distance ? -1 : 1;
	    }
	}
	private static class Node{
		int next;
		int weight;
		Node(int a, int b){
			this.next = a;
			this.weight= b;
		}
	}	
	private static int N, M, K, start, end;
	private static ArrayList<Node> adj[];
	private static long distance[][];
	private static PriorityQueue<NodeStatus> pq;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			adj = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				adj[v1].add(new Node(v2, weight));
				adj[v2].add(new Node(v1, weight));
			}
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>();
			long answer = dikjstra();
			
			bw.write("#" + t + " " + answer + "\n");
		}		
		bw.close();
		br.close();
	}

	private static long dikjstra() {
		distance = new long [N+1][K+1];
		for(int i =  1; i <= N; i ++) {
			for(int j = 0; j <= K; j ++) {
				distance[i][j] = 20000000001L;
			}
		}		
		distance[start][0] = 0;
		pq.add(new NodeStatus(start, 0, distance[start][0]));
		
		while(!pq.isEmpty()) {
			NodeStatus tmp= pq.remove();
			int now = tmp.now;
			int warp = tmp.warp;
			long dist = tmp.distance;
			if(distance[now][warp] < dist) continue;

			if(now == end) return dist;            
			for(Node node : adj[now]){
                if(distance[now][warp] + node.weight <= distance[node.next][warp]) {
                    distance[node.next][warp] = distance[now][warp] + node.weight; 
                    pq.add(new NodeStatus(node.next, warp, distance[node.next][warp]));
                }
                if(warp < K && distance[now][warp] + 1 <= distance[node.next][warp+1]) {
                    distance[node.next][warp+1] = distance[now][warp]+1;
                    pq.add(new NodeStatus(node.next, warp+1, distance[node.next][warp+1]));
                }
			}			
		}
		return -1;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}