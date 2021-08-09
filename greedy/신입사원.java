package greedy;
import java.util.*;
import java.io.*;

public class 신입사원 {
	static class person implements Comparable<person>{
		int doc;
		int inter;
		
		public person(int doc, int inter) {
			this.doc = doc;
			this.inter = inter;
		}
		
		public int compareTo(person p) {
			if(this.doc != p.doc) return this.doc - p.doc;
			return this.inter - p.inter;
		}
		
	}
	private static int T,N;
	private static int cnt = 1;
	private static int doc, inter;
	private static int[] rank;
	private static int[] rank_sort;
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(bf.readLine());
		for(int t = 0; t < T; ++t) {
			N = Integer.parseInt(bf.readLine());
			cnt = N;
			rank = new int[N + 1];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(bf.readLine());
				doc = Integer.parseInt(st.nextToken());
				inter = Integer.parseInt(st.nextToken());
				rank[doc] = inter;
			}
			rank_sort = rank.clone();
			Arrays.sort(rank_sort);
			for(int i = 2; i <= N; ++i) {
				
				for(int j = i - 1; j >= 1; --j) {
					if(rank[j] < rank[i]) {
						cnt--;
						break; 
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
