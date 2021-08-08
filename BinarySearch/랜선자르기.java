package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {
	private static int K,N;
	private static long cal;
	private static int lan[];
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K];
		for (int i = 0; i < lan.length; i++) {
			lan[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(lan);
		long start = 1;
		long end = lan[lan.length-1];
		long mid = 0;
		while(start <= end) {
			mid = (start + end) / 2; // 계산값에서 int범위 초과 가능
			cal = 0;
			
			for (int i = 0; i < lan.length; i++) {
				cal += lan[i] / mid;
			}
			if(cal >= N) {
				start = mid + 1;
			}
			else{
				end = mid - 1;
			}
			
		}
		System.out.println(end);
		System.out.println(Integer.MAX_VALUE);
	}
	
}
