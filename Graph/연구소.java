package Graph;

import java.util.*;
import java.io.*;
public class ¿¬±¸¼Ò {
	private static int N,M;
	private static int[][] search;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		search = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i <N; ++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; ++j) {
				search[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				
			}
		}
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
