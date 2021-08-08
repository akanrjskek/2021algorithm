import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }


    }

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static boolean[][] visit;
    private static int[][] model;
    private static PriorityQueue<Node> pq;
    private static int[][] collision;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[M][N];

        // field ют╥б
        model = new int[M][N];
        for (int i = 0; i < M; ++i) {
            String s = bf.readLine();
            for (int j = 0; j < N; ++j) {
                model[i][j] = s.charAt(j) - '0';
            }
        }


        visit[0][0] = true;
        int a = dijkstra(0, 0);

        System.out.println(a);
    }

    static int dijkstra(int startX, int startY) {
        collision = new int[M][N];

        pq = new PriorityQueue<>();

        pq.add(new Node(startX, startY, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.x == M - 1 && node.y == N - 1) {
                return node.weight;
            }
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + dx[i];
                int ty = node.y + dy[i];
                if (tx >= 0 && ty >= 0 && tx < M && ty < N && !visit[tx][ty]) {
                    if (model[tx][ty] == 1) {
                        visit[tx][ty] = true;
                        pq.add(new Node(tx, ty, node.weight + 1));
                    } else if (model[tx][ty] == 0) {
                        visit[tx][ty] = true;
                        pq.add(new Node(tx, ty, node.weight));
                    }

                }
            }

        }
        return -1;


    }
}

