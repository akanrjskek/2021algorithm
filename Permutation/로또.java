package Permutation;
import java.io.*;
import java.util.*;
public class ·Î¶Ç {
	private static int N;
	private static int[] inputs, numbers;
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			for(int i = 1; i <= 6; ++i) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i <= N; ++i) {
			numbers[cnt] = inputs[i];
			combination(cnt + 1, i + 1);
		}
	}
	public static void main(String[] args) throws Exception{
		while(true) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			inputs = new int[N+1];
			numbers = new int[7];
			for(int i = 1; i <= N; ++i) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			combination(1, 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
