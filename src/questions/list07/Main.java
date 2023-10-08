package questions.list07;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) {
        StringBuilder result = new StringBuilder();
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        char[][] g = new char[n][m];
        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) {
            String p = sc.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = p.charAt(j);
            }
        }
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '@') {
                    q.add(new Node(i, j, s));
                }
            }
        }
        int y = 0;
        int f = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                Node t = q.poll();
                int a = t.i;
                int b = t.j;
                int c = t.s;
                if (g[a][b] == 'x') {
                    f = 1;
                    break;
                }
                v[a][b] = 1;
                if (g[a][b] == 's') {
                    c = c - 2;
                }
                if (c >= 0 && a + 1 < n && v[a + 1][b] == 0 && g[a + 1][b] != '#') {
                    q.add(new Node(a + 1, b, c));
                }
                if (c >= 0 && b - 1 >= 0 && v[a][b - 1] == 0 && g[a][b - 1] != '#') {
                    q.add(new Node(a, b - 1, c));
                }
                if (c >= 0 && a - 1 >= 0 && v[a - 1][b] == 0 && g[a - 1][b] != '#') {
                    q.add(new Node(a - 1, b, c));
                }
                if (c >= 0 && b + 1 < m && v[a][b + 1] == 0 && g[a][b + 1] != '#') {
                    q.add(new Node(a, b + 1, c));
                }
            }
            if (f == 1) {
                y = 1;
                break;
            }
        }
        if (y == 1) {
            result.append("SUCCESS"+'\n');
        } else {
            result.append("IMPOSSIBLE"+'\n');
        }
        System.out.print(result);
    }

    static class Node {
        int i;
        int j;
        int s;

        Node(int a, int b, int c) {
            i = a;
            j = b;
            s = c;
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
