package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ÃÌ¼ö°è»ê {

    static ArrayList<Integer>[] relations;
    static boolean[] visited;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int x, y;
        relations = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            relations[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            relations[x].add(y);
            relations[y].add(x);
        }

        dfs(m1, m2, 0);
        if(ans != 0) System.out.println(ans);
        else System.out.println(-1);
    }


    static void dfs(int start, int end, int cnt) {

        visited[start] = true;
        /*if (start == end) {
            return;
        }*/
        for (int i: relations[start]) {
        	if(!visited[i]) {
                if (i == end) {
                	ans = cnt + 1;
                    return;
                }

                dfs(i, end, cnt + 1);
        	}
        }
    }

}
