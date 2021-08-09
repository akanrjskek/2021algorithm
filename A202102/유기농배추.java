package A202102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class ¿Ø±‚≥ÛπË√ﬂ {
	static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};
	private static int T,M,N,K;
	private static int x,y,count;
	private static int[][] board;
	private static boolean[][] fboard;
	private static Queue<Pair> q;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		q = new LinkedList<>();
		for (int index = 0; index < T; index++) {
			count = 0;
			st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[M][N];
			fboard = new boolean[M][N];
			for (int index2 = 0; index2 < K; index2++) {
				st = new StringTokenizer(bf.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				board[x][y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(!fboard[i][j] && board[i][j] == 1) {
						q.add(new Pair(i,j));
						fboard[i][j] = true;
						while(!q.isEmpty()) {
							Pair p = q.poll();
							for (int k = 0; k < 4; k++) {
								if(p.x + dx[k] < 0 || p.y + dy[k] < 0 || 
										p.x + dx[k] >= M || p.y + dy[k] >= N || board[p.x + dx[k]][p.y + dy[k]] == 0
										|| fboard[p.x + dx[k]][p.y + dy[k]]) {
									continue;
								}
								q.add(new Pair(p.x + dx[k],p.y + dy[k]));
								fboard[p.x + dx[k]][p.y + dy[k]] = true;
							}
							
						}
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
		
	}

}
