package Graph;
import java.io.*;
import java.util.*;

public class 벽부수고이동하기 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		int flag;
		
		Node(int x, int y, int cnt, int flag){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.flag = flag;
		}
		
		public int compareTo(Node n) {
			return this.cnt - n.cnt;
		}
	}
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};
	private static int N,M;
	private static int[][] board;
	private static boolean[][][] visit;
	private static Queue<Node> pq;
	private static int answer = Integer.MAX_VALUE;
	private static void BFS() {
		visit = new boolean[N+1][M+1][2];
		pq = new LinkedList<>();
		pq.add(new Node(1,1,1,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int x = n.x;
			int y = n.y;
			int cnt = n.cnt;
			int flag = n.flag;
			visit[x][y][flag] = true;
			if(x == N && y == M) {
				answer = cnt < answer ? cnt : answer;
			}
			
			for(int i = 0; i < 4; ++i) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx <= 0 || ty <= 0 || tx > N || ty > M) continue;
				if(board[tx][ty] == 1 && flag == 0 && !visit[tx][ty][1]) {
					visit[tx][ty][1] = true;
					pq.add(new Node(tx,ty,cnt + 1, 1));
				}
				else if(board[tx][ty] == 0 && !visit[tx][ty][flag]){
					visit[tx][ty][flag] = true;
					pq.add(new Node(tx,ty,cnt + 1, flag));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][M+1];
		String s;
		char[] c;
		for(int i = 1; i <= N; ++i) {
			s = bf.readLine();
			c = s.toCharArray();
			for(int j = 1; j <= M; ++j) {
				board[i][j] = c[j-1] - '0';
			}
		}
		
		BFS();
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
}
