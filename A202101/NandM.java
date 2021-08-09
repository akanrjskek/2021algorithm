package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {
	private static int N,M;
	private static int[] numbers;
	private static int[] answers;
	private static boolean[] flags;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N+1];
		for (int i = 1; i <= N; i++) {
			numbers[i] = i;
		}
		answers = new int[M];
		flags = new boolean[N+1];
		
		permutation(0);
		System.out.println(sb);
		
	}
	private static void permutation(int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(flags[i]) continue;
			answers[count] = numbers[i];
			flags[i] = true;
			permutation(count + 1);
			flags[i] = false;
		}
		
		
	}
	

}
