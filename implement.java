import java.io.*;
import java.util.*;

public class implement {
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int N, M;
	private static int[][] board;
	private static boolean[][] visit;
	private static int r, c, d;
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
		
		}
	}

	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
