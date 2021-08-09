package Graph;

import java.util.*;
import java.io.*;

public class 경로찾기_11403 {
	private static int N;
	private static int [][] answer;
	private static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		answer = new int[N+1][N+1];
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= N; ++j) {
				answer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 1; k <= N; ++k) {
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					if(answer[i][k] == 1 && answer[k][j] == 1) {
						answer[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
