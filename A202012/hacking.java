package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class hacking {
	private static int N, M;
	private static int start, end;
	private static ArrayList<Integer> list[];
	private static boolean flag[];
	private static int max_value = 0;
	private static int cnt[];
	private static int temp = 0;
	private static Queue<Integer> answer;
	private static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			list[i] = new ArrayList<>();
		}
		cnt = new int[N+1];
		
		q = new LinkedList<Integer>();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			list[end].add(start);
		}

		for (int i = 1; i <= N; ++i) {
			flag = new boolean[N + 1];
			dfs(i);
			cnt[i] = temp;
			temp = 0;
			max_value = cnt[i] > max_value ? cnt[i] : max_value;
		}
		
		for (int i = 1; i <= N; i++) {
	        if (max_value == cnt[i]) {
	            sb.append(i + " ");
	        }
	    }
		System.out.println(sb);

	}
	
	public static void dfs(int v) {
	    flag[v] = true;
	 
	    for(int i = 0; i < list[v].size(); ++i) {
	    	if(!flag[list[v].get(i)]) {
	    		temp++;
	    		dfs(list[v].get(i));
	    	}
	    }
	}

}
