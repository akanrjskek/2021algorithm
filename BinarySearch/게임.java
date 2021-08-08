package BinarySearch;
import java.io.*;
import java.util.*;

public class °ÔÀÓ {
	private static double X,Y;
	private static double Z;
	private static long start, end, mid,answer = 0;
	private static long value;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		X = Double.parseDouble(st.nextToken());
		Y = Double.parseDouble(st.nextToken());
		value = (long)(Y * 100 / X);
		if(value >= 99) {
			System.out.println(-1);
			return;
		}
		start = 1;
		end = 1000000000;
		while(start <= end) {
			mid = (start + end) / 2;
			if(value < (long)((Y + mid)  * 100 / (X + mid))) {
				answer = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(answer);
		double a = 0.56;
		a *= (double)100;
		System.out.println(a);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
