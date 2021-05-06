package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ºÎµ¿»ê´ÙÅù {
	private static int N,Q;
	private static boolean flags[];
	private static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		flags = new boolean[N+1];
		int duck;
		
		for (int i = 0; i < Q; i++) {
			duck = Integer.parseInt(bf.readLine());
			int temp = duck;
			pq = new PriorityQueue<>();
			pq.add(duck);
			while(duck != 1) {
				duck /= 2;
				pq.add(duck);
			}
			while(!pq.isEmpty()) {
				if(flags[pq.peek()]) {
					sb.append(pq.poll() + "\n");
					break;
				}
				pq.poll();
			}
			if(pq.isEmpty()) {
				if(!flags[temp]) {
					flags[temp] = true;
					sb.append(0 + "\n");
				}
			}
		}
		System.out.println(sb);
		
	}

}
