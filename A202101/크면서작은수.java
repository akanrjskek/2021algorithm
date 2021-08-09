package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 크면서작은수 {
	private static int N;
	private static int[] numbers;
	private static int[] answers;
	private static boolean[] flags;
	private static LinkedList<Integer> link;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		String s = Integer.toString(N);
		char[] arrayc = s.toCharArray();
		numbers = new int[arrayc.length];
		answers = new int[arrayc.length];
		flags = new boolean[arrayc.length];
		link = new LinkedList<>();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = arrayc[i] - '0';
		}
		if (arrayc.length == 1) {
			System.out.println(0);
			return;
		}
		permutation(0);
		link.sort(null);
		for (int i = 0; i < link.size(); i++) {
			if (link.get(i) == N && i != link.size() - 1) {
				if ((int)link.get(i) != (int)link.get(i + 1)) {
					System.out.println(link.get(i + 1));
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static void permutation(int cnt) {
		if (cnt == numbers.length) {
			int n = 1;
			int temp = 0;
			for (int i = answers.length - 1; i >= 0; i--) {
				temp += answers[i] * n;
				n *= 10;
			}
			link.add(temp);
			return;
		}

		for (int i = 0; i < answers.length; i++) {
			if (flags[i]) continue;
			answers[cnt] = numbers[i];
			flags[i] = true;
			permutation(cnt + 1);
			flags[i] = false;
		}
	}

}
