package questions.vjudge.lista6;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SendingEmail {

    static final int inf = 1000000000;

    static int[] latency;
    static int n, m, s, t;
    static List<List<Pair>> adj;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int tc = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int k = 1; k <= tc; k++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.nextInt();
            t = scanner.nextInt();
            adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

            int x, y, l;
            for (int i = 0; i < m; i++) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                l = scanner.nextInt();
                adj.get(x).add(new Pair(y, l));
                adj.get(y).add(new Pair(x, l));
            }

            latency = new int[n];
            Dijkstra(s);
            result.append("Case #").append(k).append(": ");
            if (latency[t] != inf) result.append(latency[t]).append("\n");
            else result.append("unreachable\n");
        }

        System.out.print(result);
    }

    static void Dijkstra(int s) {
        for (int i = 0; i < n; i++) latency[i] = inf;
        latency[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.first));
        pq.add(new Pair(latency[s], s));
        Pair p;
        int u, t;
        while (!pq.isEmpty()) {
            p = pq.poll();
            t = p.first;
            u = p.second;
            if (t > latency[u]) continue;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).first;
                int w = adj.get(u).get(i).second;
                if (latency[v] > latency[u] + w) {
                    latency[v] = latency[u] + w;
                    pq.add(new Pair(latency[v], v));
                }
            }
        }
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
