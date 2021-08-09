package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class toys {
	int toy;
	int num;

	toys(int toy, int num) {
		this.toy = toy;
		this.num = num;
	}
}

public class Toy {
	private static int N, M;
	private static LinkedList<toys> link[];
	private static int[] cnts;
	private static boolean[] flags;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		cnts = new int[N + 1];
		link = new LinkedList[N + 1];
		flags = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			link[i] = new LinkedList<>();
		}
		int n1, n2, num;
		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(bf.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			link[n1].add(new toys(n2, num));
			flags[n1] = true;
		}
		dfs(N, 1);
		for (int i = 1; i < cnts.length; i++) {
			if(!flags[i]) sb.append(i + " " + cnts[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int n, int cnt) {
		if (!flags[n]) {
			cnts[n] += cnt;
			return;
		}
		for (int j = 0; j < cnt; j++) {
			for (int i = 0; i < link[n].size(); ++i) {
				dfs(link[n].get(i).toy, link[n].get(i).num);
			}
		}

	}

}
