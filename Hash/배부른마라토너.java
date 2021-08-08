package Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class 배부른마라토너 {
	private static int N;
	private static HashMap<String,Integer> map;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		map = new HashMap<>();
		String s;
		for(int i = 0; i < N; ++i) {
			s = bf.readLine();
			if(map.containsKey(s)) {
				map.replace(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		for(int i = 0; i < N-1; ++i) {
			s = bf.readLine();
			if(map.get(s) == 1)	map.remove(s);
			else map.replace(s, map.get(s) - 1);
		}
		
		for(Entry e : map.entrySet()) {
			System.out.println(e.getKey());
		}
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
}
