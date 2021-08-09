package Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {
	private static int N,M;
	private static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		map = new HashMap<>();
		st = new StringTokenizer(bf.readLine());
		int num;
		for(int i = 0; i < N; ++i) {
			num = Integer.parseInt(st.nextToken());
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}
			else map.replace(num, map.get(num) + 1);
		}
		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		int n;
		for(int i = 0; i < M; ++i) {
			n = Integer.parseInt(st.nextToken());
			if(map.get(n) == null) {
				sb.append(0 + " ");
			}
			else {
				sb.append(map.get(n) + " ");
			}
		}
		System.out.println(sb);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
}
