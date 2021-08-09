package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ºù»ê {
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};
	private static int time = 0;
	private static int count = 0;
	private static int idx,idy;
	private static int idx1,idy1;
	private static int N;
	private static int M;
	private static int[][] ice;
	private static int[][] tempice;
	private static Queue<Integer> xq;
	private static Queue<Integer> yq;
	private static boolean[][] visit;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new int[N][M];
		xq = new LinkedList<>();
		yq = new LinkedList<>();
		
		for(int i = 0; i < N ; ++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; ++j) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visit = new boolean[N][M];
			tempice = new int[N][M];
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					if(ice[i][j] > 0 && !visit[i][j]) {
						xq.offer(i);
						yq.offer(j);
						visit[i][j] = true;
						while(!xq.isEmpty()) {
							idx = xq.poll();
							idy = yq.poll();
							for(int k = 0; k < 4; ++k) {
								idx1 = idx + dx[k];
								idy1 = idy + dy[k];
								if(idx1 >= 0 && idx1 < N && idy1 >= 0 && idy1 < M && ice[idx1][idy1] > 0 && !visit[idx1][idy1]) {
									xq.offer(idx1);
									yq.offer(idy1);
									visit[idx1][idy1] = true;
								}
							}
						}
						count++;
					}
				}
			}
			if(count > 1 ) break;
			if(count == 0) {
				time = 0;
				break;
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					for(int k = 0; k < 4; ++k) {
						idx = i + dx[k];
						idy = j + dy[k];
						if(idx >= 0 && idx < N && idy >= 0 && idy < M && ice[idx][idy] == 0 && ice[i][j] > 0) {
							tempice[i][j]++;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tempice[i][j] != 0)
						if(ice[i][j] >= tempice[i][j]) ice[i][j] -= tempice[i][j];
						else ice[i][j] = 0;
				}
			}
			count = 0;
			time++;
		}
		System.out.println(time);
	}

}
