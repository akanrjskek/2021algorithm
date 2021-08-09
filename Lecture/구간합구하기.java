package Lecture;

import java.io.*;
import java.util.*;

public class 구간합구하기 {
	private static long N, M, K;
	private static long num[], sum[];
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
	    M = Long.parseLong(st.nextToken());
	    K = Long.parseLong(st.nextToken());
	    num = new long [(int) (N+1)];
	    for(int i = 1; i <= N; i++) {
	    	num[i] = Long.parseLong(br.readLine());
	    }
	    sum = new long [(int) (N+1)];
	    initSum();
    	
	    for(int i = 0; i < M+K; i ++) {
	    	st = new StringTokenizer(br.readLine());
	    	long a = Long.parseLong(st.nextToken());
	    	long b = Long.parseLong(st.nextToken());
	    	long c = Long.parseLong(st.nextToken());
	    	
	    	if(a == 1) {
	    		long temp = num[(int)b];
	    		num[(int)b] = c;
	    		long diff = num[(int)b] - temp;
	    		changeSum((int)b, diff);
	    	}
	    	
	    	if(a == 2) {
	    		long sum1 = calSum((int)(b-1));
	    		long sum2 = calSum((int)c);
	    		bw.write(sum2-sum1+"\n");
	    	}
	    }
	    bw.close();
	    br.close();
	}

	private static void initSum() {
		for(int i = 1; i <= N; i++) {
			int index = i;
			while(index <= N) {
				sum[index] += num[i];
				index += (index & -index);
			}
		}		
	}
	private static void changeSum(int b, long c) {
		while(b <= N) {
			sum[b] += c;
			b += (b & -b);
		}
	}
	private static long calSum(int index) {
		long tmpSum = 0;
		while(index > 0) {
			tmpSum += sum[index];
			index -= (index& -index);
		}		
	    return tmpSum;
	}
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}