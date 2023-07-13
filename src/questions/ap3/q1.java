package questions.ap3;

import dataStructures.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class q1 {

    static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        int c = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        result.append("Caso " + c + ":\n");
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            ArrayList lista = new ArrayList(n);
            for (int j = 0; j < n; j++) {
                String request = scanner.nextLine();
                switch (request) {
                    case "remove":
                        lista.remove();
                    case "prev":
                        lista.prev();
                    case "next":
                        lista.next();
                    default:
                        String[] newRequest = request.split(" ");
                        if (Objects.equals(newRequest[0], "insert")) {
                            lista.insert(Integer.parseInt(newRequest[1]));
                        } else if (Objects.equals(newRequest[0], "count")) {
                            result.append(lista.count(Integer.parseInt(newRequest[1])) + "\n");
                        }
                }
            }
        }
        System.out.println(result);
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
