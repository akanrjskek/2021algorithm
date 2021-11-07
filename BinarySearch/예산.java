package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¿¹»ê {
	private static int N,M;
	private static int[] local;
	private static long start = 1, end = 1000000000;
    public static void main(String[] args) throws Exception {
        // Input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        local = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; ++i) {
        	local[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(local);
        M = Integer.parseInt(bf.readLine());
        
        //Logic
        long mid;
        while(start <= end) {
        	mid = (start + end) / 2;
        	if(request(mid)) {
        		start = mid + 1;
        		if(local[N - 1] <= mid) {
        			end = local[N - 1];
        			break;
        		}
        	}
        	else {
        		end = mid - 1;
        	}
        }
        System.out.println(end);
    }
    
    private static boolean request(long mid) {
    	int sum = 0;
    	for(int i = 0; i < N; ++i) {
    		if(local[i] < mid) sum += local[i];
    		else sum += mid;
    		if(sum > M) return false;
    	}
    	return true;
    }
}
