package greedy;
import java.io.*;
import java.util.*;
public class ÀÒ¾î¹ö¸°°ýÈ£ {
	private static String input;
	private static int answer = 0;
	private static int index = 0;
	private static int tempvalue;
	private static boolean flag = false;
	public static void main(String[] args) throws Exception{
		input = bf.readLine();
		for(int i = 0; i < input.length(); ++i) {
			if(i == input.length() - 1) {
				if(!flag) {
					tempvalue = Integer.parseInt(input.substring(index, i+1));
					answer += tempvalue;
					break;
				}
				else {
					tempvalue = Integer.parseInt(input.substring(index, i+1));
					answer -= tempvalue;
					break;
				}
			}
			if(!flag) {
				if(input.charAt(i) == '-') {
					flag = true;
					tempvalue = Integer.parseInt(input.substring(index, i));
					index = i+1;
					answer += tempvalue;
				}
				else if(input.charAt(i) == '+') {
					tempvalue = Integer.parseInt(input.substring(index, i));
					index = i+1;
					answer += tempvalue;
				}
			}
			else {
				if(input.charAt(i) == '-') {
					tempvalue = Integer.parseInt(input.substring(index, i));
					index = i+1;
					answer -= tempvalue;
				}
				else if(input.charAt(i) == '+') {
					tempvalue = Integer.parseInt(input.substring(index, i));
					index = i+1;
					answer -= tempvalue;
				}
			}
		}
		System.out.println(answer);
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	

}
