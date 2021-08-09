package Permutation;
import java.io.*;
import java.util.*;

public class 모든순열 {
	private static int N;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	private static void permutation(int cnt) {
		if(cnt == N+1) {
			for(int i = 1; i <= N; ++i) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; ++i) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		isSelected = new boolean[N+1];
		numbers = new int[N+1];
		permutation(1);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
