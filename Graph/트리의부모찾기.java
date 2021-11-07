package Graph;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
	private static int N;
	private static ArrayList<Integer>[] list;
	private static Queue<Integer> q;
	private static boolean visit[];
	private static int[] answer;
	private static void BFS() {
		q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int pre = q.poll();
			for(int i = 0; i < list[pre].size(); ++i) {
				if(visit[list[pre].get(i)]) continue;
				answer[list[pre].get(i)] = pre;
				visit[list[pre].get(i)] = true;
				q.add(list[pre].get(i));
			}
		}
			
	}
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		answer = new int[N + 1];
		for(int i = 1; i <= N; ++i) {
			list[i] = new ArrayList<>(); 
		}
		for(int i = 1; i < N; ++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		BFS();
		for(int i = 2; i <= N; ++i) {
			System.out.println(answer[i]);
		}
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}

