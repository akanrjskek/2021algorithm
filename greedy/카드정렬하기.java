package greedy;
import java.io.*;
import java.util.*;
public class 카드정렬하기 {
	private static int N;
	private static PriorityQueue<Integer> pq;
	private static int sum = 0;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		pq = new PriorityQueue<>();
		for(int i = 0; i < N; ++i) {
			pq.add(Integer.parseInt(bf.readLine()));
		}
		if(N == 1) {
			System.out.println(0);
			return;
		}
		while(pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a+b);
			sum += a+b;
		}
		System.out.println(sum);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
}
