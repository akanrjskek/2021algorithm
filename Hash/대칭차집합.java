package Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ´ëÄªÂ÷ÁýÇÕ {
	private static int A,B,cnt = 0;
	private static HashSet<Integer> set1,set2;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		set1 = new HashSet<>();
		set2 = new HashSet<>();
		st = new StringTokenizer(bf.readLine());
		while(st.hasMoreTokens()) {
			set1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(bf.readLine());
		while(st.hasMoreTokens()) {
			set2.add(Integer.parseInt(st.nextToken()));
		}
		Iterator it = set1.iterator();
		while(it.hasNext()) {
			if(!set2.contains(it.next())) cnt++;;
		}
		it = set2.iterator();
		while(it.hasNext()) {
			if(!set1.contains(it.next())) cnt++;;
		}
		System.out.println(cnt);
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
