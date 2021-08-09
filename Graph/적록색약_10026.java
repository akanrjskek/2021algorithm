package Graph;

import java.util.*;
import java.io.*;

public class 적록색약_10026 {
	
	private static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static int N;
	private static char[][] color;
	private static boolean[][] visit;
	private static char prechar,subchar;
	
	private static int firstcnt = 0;
	private static int secondcnt = 0;
	private static Queue<Node> q = new LinkedList<>();
	
	private static void firstBFS(int xx, int yy) {
		q.add(new Node(xx,yy));
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			for(int i = 0; i < 4; ++i) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx < 0 || ty < 0 || tx >= N || ty >= N ||
						visit[tx][ty] || color[tx][ty] != prechar) continue;
				q.add(new Node(tx,ty));
				visit[tx][ty] = true;
			}
		}
	}
	
	private static void secondBFS(int xx, int yy) {
		q.add(new Node(xx,yy));
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			for(int i = 0; i < 4; ++i) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx < 0 || ty < 0 || tx >= N || ty >= N ||
						visit[tx][ty] || color[tx][ty] == 'B') continue;
				q.add(new Node(tx,ty));
				visit[tx][ty] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		color = new char[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			color[i] = bf.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(!visit[i][j]) {
					prechar = color[i][j];
					firstBFS(i,j);
					firstcnt++;
				}
			}
		}
		
		visit = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(!visit[i][j]) {
					if(color[i][j] == 'R' || color[i][j] == 'G') {
						secondBFS(i,j);
					}
					else {
						prechar = color[i][j];
						firstBFS(i,j);
					}
					secondcnt++;
				}
			}
		}
		System.out.println(firstcnt + " " + secondcnt);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
}
