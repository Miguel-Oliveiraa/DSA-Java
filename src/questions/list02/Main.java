package questions.list02;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastScanner con = new FastScanner(new InputStreamReader(System.in));

        int n;


        while((n = con.nextInt()) != 0) {
            int x, cur, ok;
            while((x = con.nextInt()) != 0) {
                cur = ok = 1;
                Stack<Integer> s = new Stack<Integer>();
                for(int i = 1; i < n; i++) {
                    for(; cur <= x; cur++) s.push(cur);
                    if (s.peek() != x) ok = 0;
                    s.pop();
                    x = con.nextInt();
                }

                String Answer = (ok == 1) ? "Yes" : "No";

                System.out.println(Answer);
            }

            System.out.println("");

        }
    }
}



class FastScanner {
    private BufferedReader br;

    private StringTokenizer st;

    public FastScanner(InputStreamReader reader) {
        br = new BufferedReader(reader);
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public void close() throws Exception {
        br.close();
    }
}