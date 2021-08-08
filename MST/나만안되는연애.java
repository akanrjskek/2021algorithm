package MST;
import java.io.*;
import java.util.*;

public class 나만안되는연애 {
	static class Edge implements Comparable<Edge>{
		int end;
		int weight;
		
		Edge(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	private static int N,M;
	private static boolean[] people;
	private static boolean[] visit;
	private static int[][] list;
	private static PriorityQueue<Edge> pq;
	private static int cnt = 0, answer = 0;
	private static void prim() {
		visit[1] = true;
		pq = new PriorityQueue<>();
		for(int i = 0; i < list[1].length; ++i) {
			if(list[1][i] != 0) pq.add(new Edge(i,list[1][i]));
		}
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visit[e.end]) continue;
			visit[e.end] = true;
			cnt++;
			answer += e.weight;
			for(int i = 0; i < list[e.end].length; ++i) {
				if(visit[i] || list[e.end][i] == 0) continue;
				pq.add(new Edge(i,list[e.end][i]));
			}
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new boolean[N+1];
		visit = new boolean[N+1];
		list = new int [N+1][N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= N; ++i) {
			if(st.nextToken().equals("M")) people[i] = true;
			else people[i] = false;
		}
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(people[start] != people[end]) {
				if(list[start][end] == 0 || list[start][end] > weight){
					list[start][end] = weight;
					list[end][start] = weight;
				}
			}
		}
		prim();
		if(cnt == N - 1)System.out.println(answer);
		else System.out.println(-1);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
