package questions.iudex.ep1;

import java.util.Objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Consultas {

        public static FastReader scanner = new FastReader();

        public static void main(String[] args) {
            int t = scanner.nextInt();
            String[] pessoasCadastradas = new String[t];
    //        scanner.nextLine();
            for (int i = 0; i < t; i++) {
                pessoasCadastradas[i] = scanner.nextLine();
            }
            int q = scanner.nextInt();
    //        scanner.nextLine();
            for (int i = 0; i < q; i++) {
                System.out.println(buscaBinaria(pessoasCadastradas, scanner.nextLine()));
            }
        }

        private static String buscaBinaria(String[] lista, String alvo) {
            int l = 0;
            int r = lista.length-1;
            while (l<=r){
                int m = l+(r-l)/2;
                if (Objects.equals(lista[m], alvo)) return "+";
                else if (alvo.compareTo(lista[m])<0) r = m-1;
                else l = m+1;
            }
            return "-";
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
