package Floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {
	private static int N,M;
	private static int[][] bus;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		bus = new int[N+1][N+1];
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				if(i == j) continue;
				bus[i][j] = 100000 * 100;
			}
		}
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(bus[x][y] == 0) bus[x][y] = weight;
			else if(bus[x][y] > weight) bus[x][y] = weight;
		}
		
		for(int k = 1; k <= N; ++k) {
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					if(bus[i][k] + bus[k][j] < bus[i][j]) {
						bus[i][j] = bus[i][k] + bus[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				if(bus[i][j] != 100000 * 100) System.out.print(bus[i][j] + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
