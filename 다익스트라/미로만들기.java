package 다익스트라;

import java.io.*;
import java.util.*;

class makemaze implements Comparable<makemaze>{
	int x;
	int y;
	int cnt;
	
	public makemaze(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	public int compareTo(makemaze m) {
		return this.cnt - m.cnt;
	}
	
}


public class 미로만들기 {
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static int N;
	private static int[][] maze;
	private static boolean[][] visit;
	//private static int cnt = 0;
	private static PriorityQueue<makemaze> pq;
	
	private static int BFS(int x, int y) {
		visit[x][y] = true;
		pq = new PriorityQueue<makemaze>();
		pq.add(new makemaze(x,y,0));
		while(!pq.isEmpty()) {
			makemaze m = pq.poll();
			if(m.x == N - 1 && m.y == N - 1) return m.cnt;
			for(int i = 0; i < 4; ++i) {
				int tx = m.x + dx[i];
				int ty = m.y + dy[i];
				if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
				if(!visit[tx][ty] && maze[tx][ty] == 1) {
					visit[tx][ty] = true;
					pq.add(new makemaze(tx,ty,m.cnt));
				}
				
				if(!visit[tx][ty] && maze[tx][ty] == 0) {
					visit[tx][ty] = true;
					pq.add(new makemaze(tx,ty,m.cnt+1));
				}
				
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		maze = new int[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			char[] carr = bf.readLine().toCharArray();
			for(int j = 0; j < N; ++j) {
				maze[i][j] = carr[j] - '0';
			}
		}
		int cnt = BFS(0,0);
		System.out.println(cnt);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
