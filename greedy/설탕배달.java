package greedy;
import java.io.*;
import java.util.*;
public class º≥≈¡πË¥ﬁ {
	private static int N;
	private static int answer = 0;
	private static int cnt = 0;
	private static int[] num;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		
		while(true) {
			if(N % 5 ==0) {
				cnt += N / 5;
				System.out.println(cnt);
				break;
			}
			else {
				N -= 3;
				cnt++;
			}
			if(N < 0) {
				System.out.println(-1);
				break;
			}
		}
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
}
