package DisjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int binary;
    private static int[] parent;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            parent[i] = i;
        }


        int a, b;

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(bf.readLine());
            binary = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (binary == 0) {
                union(a, b);
            } else if (binary == 1) {
                if (sameParent(a, b)) {
                    sb.append("YES" + "\n");
                } else {
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static boolean sameParent(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x == y) {
            return true;
        }
 
        return false;
    }

    static int find(int node1) {
    	if (node1 == parent[node1]) {
            return node1;
        }
 
        return parent[node1] = find(parent[node1]);
    }

    static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1 == node2) {
            return;
        } else {
            if (node1 < node2) {
                parent[node2] = node1;
            } else {
                parent[node1] = node2;
            }
        }
    }
}