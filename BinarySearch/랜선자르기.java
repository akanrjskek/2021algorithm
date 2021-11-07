package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {
	private static int K,N;
	private static long cal;
	private static int lan[];
	private static long start = 1, end = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K];
		for(int i = 0; i < K; ++i) {	
			lan[i] = Integer.parseInt(bf.readLine());
		}
		
		while(start <= end) {
			cal = 0;
			long mid = (start + end) / 2;
			for(int i = 0; i < K; ++i) {
				cal += lan[i] / mid;
			}
			if(cal >= N) start = mid + 1;
			else end = mid - 1;
		}
		
		System.out.println(end);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
