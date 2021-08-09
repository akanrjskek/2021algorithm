package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Επ»η2 {
	private static int N;
	private static int[] input1, input2, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		input1 = new int[N+1];
		input2 = new int[N+1];
		answer = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			input1[i] = Integer.parseInt(st.nextToken());
			input2[i] = Integer.parseInt(st.nextToken());
		}
		answer[1] = input2[1];
		for (int i = 2; i <= N; i++) { 
			
		}
		System.out.println(answer[N]);
		
	}

}
