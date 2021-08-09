package greedy;
import java.io.*;
import java.util.*;


public class 단어수학 {
	static class str implements Comparable<str>{
		String s;
		
		str(String s){
			this.s = s;
		}
		
		public int compareTo(str ss) {
			return ss.s.length() - this.s.length();
		}
		
		
	}
	private static int N;
	private static String[] strs;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
}
