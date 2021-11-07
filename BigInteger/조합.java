package BigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class а╤гу{
	private static int N,C;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for(int i = 0; i < C; ++i) {
			n1 = n1.multiply(new BigInteger(String.valueOf(N - i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		}
		System.out.println(n1.divide(n2));
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
