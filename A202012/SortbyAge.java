package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SortbyAge {
	private static int N;
	private static LinkedList<String> link[];
	private static boolean[] flags;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		link = new LinkedList[201];
		flags = new boolean[201];
		int tempi;
		String temps;
		for (int i = 1; i <= 200; i++) {
			link[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			tempi = Integer.parseInt(st.nextToken());
			temps = st.nextToken();
			flags[tempi] = true;
			link[tempi].add(temps);
		}
		
		for (int i = 1; i <= 200; i++) {
			if(flags[i]) {
				for (int j = 0; j < link[i].size(); j++) {
					sb.append(i + " " + link[i].get(j) + "\n");
				}
				
			}
		}
		
		System.out.println(sb);
		
		
	}

}
