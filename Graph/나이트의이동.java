package Graph;
import java.io.*;
import java.util.*;


public class ����Ʈ���̵� {
	static class Node{
		int x;
		int y;
		int cnt;
		
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	private static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	private static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	private static int T,N; // �׽�Ʈ���̽�, ü���� �Ѻ��� ����
	private static int[][] board;
	private static boolean[][] visit;
	private static int startx, starty; //���� x,y
	private static int endx, endy; // �� x,y
	private static Queue<Node> q;
	private static void BFS() {
		q = new LinkedList<>();
		q.add(new Node(startx,starty,0));
		visit[startx][starty] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			int cnt = n.cnt;
			if(x == endx && y == endy) {
				sb.append(cnt + "\n");
			}
			for(int i = 0; i < 8; ++i) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx < 0 || ty < 0 || tx >= N || ty >= N || visit[tx][ty]) continue;
				q.add(new Node(tx,ty,cnt + 1));
				visit[tx][ty] = true;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(bf.readLine());
		for(int i = 0; i < T; ++i) {
			N = Integer.parseInt(bf.readLine());
			board = new int[N][N];
			visit = new boolean[N][N];
			st = new StringTokenizer(bf.readLine());
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			endx = Integer.parseInt(st.nextToken());
			endy = Integer.parseInt(st.nextToken());
			BFS();
		}
		System.out.println(sb);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
