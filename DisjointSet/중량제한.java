package DisjointSet;

import java.util.*;
import java.io.*;

public class 중량제한 {
	
	static class island{
		int des;
		int cost;
		
		island(int des, int cost){
			this.des = des;
			this.cost = cost;
		}
	}
	
	private static int N,M;
	private static ArrayList<island> list[];
	private static boolean[] visit;
	private static Queue<Integer> q = new LinkedList<>();
	private static int s = Integer.MAX_VALUE,e = 0;
	private static int node1, node2;
	
	private static boolean bfs(int mid) {
		q = new LinkedList<>();
		visit = new boolean[N+1];
		visit[node1] = true;
		q.add(node1);
		
		
		while(!q.isEmpty()) {
			int pre = q.poll();
			if(pre == node2) return true;
			for(int i = 0; i < list[pre].size(); ++i) {
				if(!visit[list[pre].get(i).des] && list[pre].get(i).cost >= mid) {
					q.add(list[pre].get(i).des);
					visit[list[pre].get(i).des] = true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for(int i = 1; i < N+1; ++i) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			s = Math.min(s, weight);
			e = Math.max(e, weight);
			list[start].add(new island(end,weight));
			list[end].add(new island(start,weight));
		}
		st = new StringTokenizer(bf.readLine());
		node1 = Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		int mid;
		int result = 0;
		while(s <= e) {
			mid = (s + e) / 2;
			if(bfs(mid)) {
				result = mid;
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		System.out.println(result);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
