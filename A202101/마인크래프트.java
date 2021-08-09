package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {
	private static int N, M, B;
	private static int[][] board;
	private static int answer1;
	private static int answer2 = Integer.MAX_VALUE;
	private static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= 256; i++) {
			int temp = 0;
			int tempb = B;
			flag = false;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (i <= board[j][j2]) {
						temp += (board[j][j2] - i) * 2;
						tempb += (board[j][j2] - i);
					} else {
						temp += i - board[j][j2];
						tempb -= i - board[j][j2];
					}
				}
			}
			if(tempb < 0) continue;

			if (temp <= answer2) {
				answer2 = temp;
				answer1 = i;
			}

		}
		System.out.println(answer2 + " " + answer1);

	}

}
