package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2 {
	private static int N;
	private static int[][] W;
	private static int cnt = 0;
	private static int ii;
	private static int answer = Integer.MAX_VALUE;
	private static boolean[] flags;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		W = new int[N+1][N+1];
		flags = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			ii = i;
			flags = new boolean[N+1];
			flags[i] = true;
			cnt = 0;
			dfs(i,0);
		}
		System.out.println(answer);
		
	}
	
	private static void dfs(int index, int count) {
		if(count == N-1) {
			if(W[index][ii] != 0) {
				answer = cnt + W[index][ii] < answer ? cnt + W[index][ii] : answer;
			}
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(flags[i] || W[index][i] == 0) continue;
			flags[i] = true;
			cnt += W[index][i];
			dfs(i, count + 1);
			cnt -= W[index][i];
			flags[i] = false;
		}
		
		
	}

}
