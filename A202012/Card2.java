package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {
	private static int N;
	private static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		if(N == 1) {
			System.out.println(1);
			return;
		}
		q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size() != 1) {
			q.poll();
			if(q.size() == 1) break;
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
		
		
	}

}
