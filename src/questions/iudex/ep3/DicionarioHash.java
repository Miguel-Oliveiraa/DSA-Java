package questions.iudex.ep3;

import java.util.ArrayList;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DicionarioHash {

    private static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        // Recebe o tamanho m da hashTable e cria o arrayProb de tamanho m-1
        int m = scanner.nextInt();
        while (m!=0) {
            // Cria o array prob do tamanho m-1
            Integer[] prob = new Integer[m-1];
            for (int i = 0; i < m-1; i++) {
                prob[i] = scanner.nextInt();
            }

            // Cria hashtable
            CodeHashTable table = new CodeHashTable(m);

            StringBuilder result = new StringBuilder();

            // Recebe n operacoes
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String operator = scanner.next();
                if (Objects.equals(operator, "add")) {
                    int key = scanner.nextInt();
                    int value = scanner.nextInt();
                    table.insert(key,value,prob);
                } else if (Objects.equals(operator, "find")) {
                    int key = scanner.nextInt();
                    result.append(table.find(key, prob) + "\n");
                }
            }

            System.out.print(result);

            // Recebe outro tamanho
            m = scanner.nextInt();
        }
    }

    static class CodeHashTable {
        public static int m;
        public static int cnt;
        public static ArrayList<Entry> array;


        // Constructor
        public CodeHashTable(int size) {
            m = size;
            cnt = 0;
            array = new java.util.ArrayList<>();
            // Inicia o ArrayList com todos elementos null
            for (int i = 0; i < size; i++) {
                array.add(i, null);
            }
        }

        private Integer hashFunction(Integer key) {
            return key - (m * (int) Math.floor((double) key / m));
        }

        public void insert(Integer key, int value, Integer[] perm) {
            // Tabela cheia
            if (cnt >= m) {
                return;
            }

            // Primeira key
            int hash = hashFunction(key);
            int i = 1;

            while (array.get(hash) != null) {
                //Caso ja exista um objeto com a mesma key
                if (Objects.equals(array.get(hash).key, key)) {
                    return;
                }

                //pseudo-random probing
                hash = (hash + perm[i - 1]) % m;
                i++;

                if (i > perm.length) {
                    return;
                }
            }

            array.set(hash, new Entry(key, value));
            cnt++;
        }

        public Integer find(Integer key, Integer[] perm) {
            int hash = hashFunction(key);
            int i = 1;

            while (array.get(hash) != null) {
                // Retorna o indice (hash) onde a chave foi encontrada
                if (Objects.equals(array.get(hash).key, key)) {
                    return hash;
                }

                hash = (hash + perm[i - 1]) % m;
                i++;

                // Passou por todos as possibilidades
                if (i > perm.length) {
                    return -1;
                }
            }

            return -1; // Chave nao encontrada
        }


        static class Entry {
            Integer key;
            int value;

            Entry(Integer k, int v) {
                key = k;
                value = v;
            }
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
