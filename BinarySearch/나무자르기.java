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
		for (int i = 0; i < trees.length; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		Arrays.sort(trees);
		int end = trees[trees.length-1];
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < trees.length; i++) {
				if(mid < trees[i]) {
					sum += (trees[i] - mid);
				}
			}
			if(sum == M) {
				end = mid;
				break;
			}
			else if(sum < M) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}
}