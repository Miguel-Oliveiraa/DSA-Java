package questions.vjudge.lista1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HackingTheRandomNumberGenerator {

    public static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }
        quickSort(numeros,0,numeros.length-1);
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (buscaBinaria(numeros, numeros[i]+k)) r++;;
        }
        System.out.println(r);
    }

    private static boolean buscaBinaria(int[] lista, int alvo) {
        int l = 0;
        int r = lista.length-1;
        while (l<=r){
            int m = l+(r-l)/2;
            if (lista[m] == alvo) return true;
            else if (alvo < lista[m]) r = m-1;
            else l = m+1;
        }
        return false;
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
        int i = s,j = e+1;
        do  {
            do {
                i = i + 1;
            } while (array[i]<pivot && i<e);
            do {
                j = j - 1;
            } while (array[j]>pivot);
            swap(array, i, j);
        } while (i<j);
        swap(array, i, j);
        swap(array, s, j);
        return j;
    }

    private static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
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
