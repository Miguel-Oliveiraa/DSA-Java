package questions.list07;

import java.util.*;
    public class Main {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            char[][] g = new char[n][n];
            int[][] v = new int[n][n];
            for (int i = 0; i < n; i++) {
                String p = sc.next();
                for (int j = 0; j < m; j++) {
                    g[i][j] = p.charAt(j);
                }
            }
            Queue<Pair> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] == '@') {
                        q.add(new Pair(i, j, s));
                    }
                }
            }
            int y = 0;
            int f = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int z = 0; z < size; z++) {
                    Pair t = q.poll();
                    int a = t.i;
                    int b = t.j;
                    int c = t.s;
                    if (g[a][b] == 'x') {
                        f = 1;
                        break;
                    }
                    v[a][b] = 1;
                    if (g[a][b] == 'x') {
                        f = 1;
                        break;
                    }
                    v[a][b] = 1;
                    if (g[a][b] == 's') {
                        c = c - 2;
                    }
                    if (c >= 0 && a + 1 < n && v[a + 1][b] == 0 && g[a + 1][b] != '#') {
                        q.add(new Pair(a + 1, b, c));
                    }
                    if (c >= 0 && b - 1 >= 0 && v[a][b - 1] == 0 && g[a][b - 1] != '#') {
                        q.add(new Pair(a, b - 1, c));
                    }
                    if (c >= 0 && a - 1 >= 0 && v[a - 1][b] == 0 && g[a - 1][b] != '#') {
                        q.add(new Pair(a - 1, b, c));
                    }
                    if (c >= 0 && b + 1 < m && v[a][b + 1] == 0 && g[a][b + 1] != '#') {
                        q.add(new Pair(a, b + 1, c));
                    }
                }
                if (f == 1) {
                    y = 1;
                    break;
                }
            }
            if (y == 1) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        static class Pair {
            int i;
            int j;
            int s;

            Pair(int a, int b, int c) {
                i = a;
                j = b;
                s = c;
            }
        }
    }
