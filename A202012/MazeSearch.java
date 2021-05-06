package A202012;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	int weight;
	Pair(int x, int y, int weight){
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
}
public class MazeSearch {
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static int N,M;
	private static int[][] maze;
	private static int answer = 10000;
	private static boolean[][] flag;
	private static Queue<Pair> q;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+1][M+1];
		flag = new boolean[N+1][M+1];
		q = new LinkedList<>();
		Pair p;
		char[] inputString;
		for(int i = 1; i <= N; ++i) {
			inputString = bf.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j+1] = inputString[j] - '0';
			}
		}
		
		q.add(new Pair(1,1,1));
		while(!q.isEmpty()) {
			bfs(q.poll());
		}
		
		System.out.println(answer);
	}
	private static void bfs(Pair p) {
		if(p.x == N && p.y == M) {
			answer = p.weight < answer ? p.weight : answer;
		}
		for(int i = 0; i < 4; ++i) {
			int xx = p.x + dx[i];
			int yy = p.y + dy[i];
			
			if(xx <= 0 || xx > N || yy <= 0 || yy > M || maze[xx][yy] == 0 || flag[xx][yy]) {
				continue;
			}
			flag[xx][yy] = true;
			q.add(new Pair(xx,yy,p.weight+1));
		}
	}

}
