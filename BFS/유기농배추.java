package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{ // 좌표를 나타내기 위해서
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class 유기농배추 {
	private static int[] dx = {-1,0,1,0}; // 상우하좌
	private static int[] dy = {0,1,0,-1}; // 상우하좌
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t = 0; t < T; ++t) { // 테스트 개수
			st = new StringTokenizer(bf.readLine());
			int cnt = 0;
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Queue<Node> q = new LinkedList<>();
			int[][] board = new int[M][N];
			boolean[][] visit = new boolean[M][N]; //2차원 배열의 원소를 방문했는지 판단하는 배열.
			for(int i = 0; i < K; ++i) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y] = 1; // 배추를 나타냄.
			}
			//board(2차원 배열)를 다 돌아야함.
			//BFS사용(DFS)
			for(int i = 0; i < M; ++i) {
				for(int j = 0; j < N; ++j) {
					if(board[i][j] == 1 && !visit[i][j]) {
						cnt++;
						q.add(new Node(i,j));
						visit[i][j] = true; // 방문함
						while(!q.isEmpty()) {
							Node node = q.poll();
							int x = node.x;
							int y = node.y;
							for(int k = 0; k < 4; ++k) {
								int tx = x + dx[k];
								int ty = y + dy[k];
								if(tx >= 0 && ty >= 0 && tx < M && ty < N && board[tx][ty] == 1 && !visit[tx][ty]) {
									q.add(new Node(tx,ty));
									visit[tx][ty] = true;
								}
							}
						}
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

}
