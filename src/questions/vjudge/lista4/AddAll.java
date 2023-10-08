package questions.vjudge.lista4;

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddAll {

    static FastReader scanner = new FastReader();

    public static void main(String[] args) {

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            PriorityQueue<Integer> Q = new PriorityQueue<>();
            long ans = 0;

            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                Q.offer(num);
            }
            while (Q.size() > 1) {
                int a = Q.poll();
                int b = Q.poll();
                ans += a + b;
                Q.offer(a + b);
            }

            System.out.println(ans);
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
