package greedy;
import java.io.*;
import java.util.*;

public class ¡÷¿Øº“ {
	private static int N;
	private static long answer;
	private static long[] dis;
	private static long[] money;
	private static long dis_sum = 0;
	private static long min_money;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		dis = new long[N-1];
		money = new long[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N - 1; ++i) {
			dis[i] = Long.parseLong(st.nextToken());
			dis_sum += dis[i];
		}
		st = new StringTokenizer(bf.readLine());
		min_money = Long.parseLong(st.nextToken());
		answer += min_money * dis[0];
		for(int i = 1; i < N - 1; ++i) {
			long temp = Long.parseLong(st.nextToken());
			min_money = min_money < temp ? min_money : temp; 
			answer += min_money * dis[i];
		}
		
		System.out.println(answer);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
