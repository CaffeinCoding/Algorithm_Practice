import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리Kruskal {
    static int V, E;
    static int[] p;
    static Node[] node;

    public static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void make() {
        p = new int[V];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }
    }

    public static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    public static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if (ar == br) {
            return false;
        }
        p[br] = ar;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            make();
            node = new Node[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                node[i] = new Node(Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(node);

            long result = 0;
            int cnt = 0;

            for (Node n : node) {
                if (union(n.from, n.to)) {
                    cnt += 1;
                    result += n.weight;
                    if (cnt == V - 1) {
                        break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
