package A202104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¾ËÆÄºª {
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static char[][] alpha;
	private static int R,C;
	private static int answer = 1;
	private static boolean[] flags;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[R][C];
		for (int i = 0; i < R; i++) {
			alpha[i] = bf.readLine().toCharArray();
		}
		flags = new boolean[26];
		flags[alpha[0][0] - 65] = true;
		DFS(0,0,1);
		System.out.println(answer);
	}
	
	private static void DFS(int x, int y, int count) {
		if(count == 26) {
			answer = count;
			return;
		}
		
		else {
			if(answer == 26) {
				return;
			}
			for(int i = 0; i < 4; ++i) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx < R && tx >= 0 & ty < C && ty >= 0
						&& !flags[alpha[tx][ty] - 65]) {
					flags[alpha[tx][ty] - 65] = true;
					count++;
					DFS(tx, ty, count);
					count--;
				}
				if(answer < count) answer = count;
			}
			flags[alpha[x][y] - 65] = false;
			
		}
	}

}
