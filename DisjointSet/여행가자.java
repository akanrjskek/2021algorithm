package DisjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
	private static int N,M;
	private static int[] parent;
	
	private static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		else {
			if(x < y) {
				parent[y] = x;
			}
			else {
				parent[x] = y;
			}
		}
	}
	
	public static boolean sameParent(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x == y) {
            return true;
        }
 
        return false;
    }
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		int value;
		parent = new int[N+1];
		for(int i = 1; i <= N; ++i) {
			parent[i] = i;
		}
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= N; ++j) {
				value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					Union(i,j);
				}
			}
		}
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[M+1];
		for(int i = 1; i <= M; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int i;
		for(i = 1; i < M; ++i) {
			if(sameParent(arr[i], arr[i+1])) {
				continue;
			}
			else {
				break;
			}
		}
		if(i == M) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
	}
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
}
