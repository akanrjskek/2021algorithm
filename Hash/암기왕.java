package Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ¾Ï±â¿Õ {
	private static int T, N, M;
	private static HashSet<Integer> set;

	public static void main(String args[]) throws Exception {
		T = Integer.parseInt(bf.readLine());
		for (int j = 0; j < T; ++j) {
			N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			set = new HashSet<Integer>();
			for (int i = 0; i < N; ++i) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < M; ++i)
				if (set.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1 + "\n");
				} else
					sb.append(0 + "\n");
		}
		System.out.println(sb);
	}

	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
