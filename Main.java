import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    static ArrayList<Node>[] link;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int start = 1;
    static int weight = 0;
    static boolean[] visited;
    static int N;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        link = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            link[i] = new ArrayList<>();
        }

        int s, e, w;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            link[s].add(new Node(e, w));
            link[e].add(new Node(s, w));
        }

        search_prim();
        sb.append(weight);
        System.out.println(sb);
    }

    static void search_prim() {
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (visited[curNode.end]) {
                continue;
            }

            visited[curNode.end] = true;
            weight += curNode.weight;


            for (Node n: link[curNode.end]) {
                if (!visited[n.end]) {
                    pq.add(n);
                }
            }

            if (cnt++ == N - 1) {
                break;
            }
        }
    }
}