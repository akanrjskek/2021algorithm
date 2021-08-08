package MST;
import java.io.*;
import java.util.*;

public class 우주신과의교감 {
	static class Node{
		//int index;
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge{
		int start;
		int end;
		double weight;
		
		Edge(int start, int end, double weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public double compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	
	private static int N,M;
	private static int answer = 0;
	private static int cnt = 0;
	private static boolean[][] visit;
	//private static Node[] input;
	private static Node[] list;
	private static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1][N + 1];
		list = new Node[N + 1];
		pq = new PriorityQueue<>();
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(bf.readLine());
			list[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i <= M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
		}
		
		
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
