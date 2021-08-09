package Floyd;
import java.util.*;
import java.io.*;

public class 케빈베이컨의6단계법칙 {
	private static int N,M;
	private static int[][] fr;
	private static int[] sums;
	private static int answer = Integer.MAX_VALUE;
	private static int index;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fr = new int[N+1][N+1];
		sums = new int[N+1];
		
		int s,e;
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				fr[i][j] = 101;
			}
		}
		
		for(int i = 1; i <= N; ++i) {
			fr[i][i] = 0;
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			fr[s][e] = 1;
			fr[e][s] = 1;
		}
		
		for(int k = 1; k <= N; ++k) {
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					if(fr[i][j] > fr[i][k] + fr[k][j]) {
						fr[i][j] = fr[i][k] + fr[k][j];
					}
				}
			}
		}
		
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				sums[i] += fr[i][j];
			}
		}
		
		for(int i = 1; i <= N; ++i) {
			if(answer > sums[i]) {
				index = i;
				answer = sums[i];
			}
		}
		
		System.out.println(index);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
