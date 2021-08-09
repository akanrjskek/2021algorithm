package A202101;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ≈∏¿œ {
	private static int N;
	private static int answer = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		if(N == 1) {
			System.out.println(answer);
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if(i % 2 == 0) {
				answer = (answer*2 + 1) % 10007;
				
			}
			else {
				answer = (answer * 2 - 1)%10007;
			}
		}
		System.out.println(answer);
	}

}
