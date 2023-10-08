package questions.iudex.ep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Numeros {

    public static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder(n);
        int[] lista = new int[n];
        for (int i = 0; i < n; i++) {
            lista[i] = scanner.nextInt();
        }
        quickSort(lista, 0, lista.length-1);

        for (int numero :
                lista) {
            stringBuilder.append(numero + "\n");
        }
        System.out.print(stringBuilder.toString());
    }

    public static void quickSort(int[] array, int s, int e) {
        if (s < e) {
            int pivot = partition(array, s, e);
            quickSort(array, s, pivot - 1);
            quickSort(array, pivot + 1, e);
        }
    }

    private static int partition(int[] array, int s, int e) {
        int pivot = array[s];
        int i = s, j = e + 1;
        do {
            do {
                i = i + 1;
            } while (array[i] < pivot && i < e);
            do {
                j = j - 1;
            } while (array[j] > pivot);
            swap(array, i, j);
        } while (i < j);
        swap(array, i, j);
        swap(array, s, j);
        return j;
    }

    private static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
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
