package BinarySearch;

import java.util.*;
import java.io.*;

public class 나무자르기{
	private static int N,M;
	private static int[] trees;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; ++i) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		int start = 1;
		int end = 1000000000;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(function(mid)) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
	
	private static boolean function(int mid) {
		int answer = 0;
		for(int i = 0; i < N; ++i) {
			if(trees[i] > mid) {
				answer += trees[i] - mid;
				if(answer >= M) {
					return true;
				}
			}
		}
		return false;
	}
}