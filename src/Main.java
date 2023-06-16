import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Digite os números separados por espaço:");

        // Dividindo a entrada em substrings separadas por espaço
        String[] numerosString = scanner.nextLine().split(" ");

        Integer[] numeros = new Integer[numerosString.length];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(numerosString[i]);
        }

        System.out.println("Números armazenados no ArrayList:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}

// questao Consultas
// import java.util.Objects;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// //A primeira linha da entrada contém o número 0 < t <= 100.000 que indica o tamanho do conjunto.
// //Em cada uma das próximas t linhas, tem-se um nome n (0 < |n| <= 30 letras minúsculas, sem espaço).
// //Os nomes são únicos e são listados em ordem alfabética (lexicográfica).
// //Após listar t nomes, a entrada contém o número 0 < q <= 100.000 de consultas.
// //Em cada uma das próximas q linhas, tem-se um nome n (0 < |n| <= 30 letras minúsculas, sem espaço).
// // input:
// //5
// //amanda
// //emanoel
// //gustavo
// //lucas
// //pedro
// //4
// //alexandre
// //pedro
// //gustaov
// //gustavo
// // output:
// //-
// //+
// //-
// //+



// public class consultas {
//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;

//         public FastReader()
//         {
//             br = new BufferedReader(
//                     new InputStreamReader(System.in));
//         }

//         String next()
//         {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 }
//                 catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }

//         int nextInt() { return Integer.parseInt(next()); }

//         long nextLong() { return Long.parseLong(next()); }

//         double nextDouble()
//         {
//             return Double.parseDouble(next());
//         }

//         String nextLine()
//         {
//             String str = "";
//             try {
//                 if(st.hasMoreTokens()){
//                     str = st.nextToken("\n");
//                 }
//                 else{
//                     str = br.readLine();
//                 }
//             }
//             catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }
//     }
//     public static FastReader scanner = new FastReader();

//     public static void main(String[] args) {
//         int t = scanner.nextInt();
//         String[] pessoasCadastradas = new String[t];
// //        scanner.nextLine();
//         for (int i = 0; i < t; i++) {
//             pessoasCadastradas[i] = scanner.nextLine();
//         }
//         int q = scanner.nextInt();
// //        scanner.nextLine();
//         for (int i = 0; i < q; i++) {
//             System.out.println(buscaBinaria(pessoasCadastradas, scanner.nextLine()));
//         }
//     }

//     private static String buscaBinaria(String[] lista, String alvo) {
//         int l = 0;
//         int r = lista.length-1;
//         while (l<=r){
//             int m = l+(r-l)/2;
//             if (Objects.equals(lista[m], alvo)) return "+";
//             else if (alvo.compareTo(lista[m])<0) r = m-1;
//             else l = m+1;
//         }
//         return "-";
//     }
// }

// /////////
// questao numeros
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// //A primeira linha da entrada contém o número 0 < n <= 100.000 de inteiros que precisam ser ordenados.
// //Em cada uma das próximas n linhas, tem-se um inteiro -1.000.000 <= i <= 1.000.000.
// // input:
// //8
// //44
// //0
// //72
// //71
// //-200
// //44
// //-1500
// //739
// // output:
// //-1500
// //-200
// //0
// //44
// //44
// //71
// //72
// //739



// public class numeros {
//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;

//         public FastReader()
//         {
//             br = new BufferedReader(
//                     new InputStreamReader(System.in));
//         }

//         String next()
//         {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 }
//                 catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }

//         int nextInt() { return Integer.parseInt(next()); }

//         long nextLong() { return Long.parseLong(next()); }

//         double nextDouble()
//         {
//             return Double.parseDouble(next());
//         }

//         String nextLine()
//         {
//             String str = "";
//             try {
//                 if(st.hasMoreTokens()){
//                     str = st.nextToken("\n");
//                 }
//                 else{
//                     str = br.readLine();
//                 }
//             }
//             catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }
//     }
//     public static FastReader scanner = new FastReader();


//     public static void main(String[] args) {
//         int n = scanner.nextInt();
//         StringBuilder stringBuilder = new StringBuilder(n);
//         int[] lista = new int[n];
//         for (int i = 0; i < n; i++) {
//             lista[i] = scanner.nextInt();
//         }
//         quickSort(lista, 0, lista.length-1);
//         for (int numero :
//                 lista) {
//             stringBuilder.append(numero + "\n");
//         }
//         System.out.print(stringBuilder.toString());
//     }

//     public static void quickSort(int[] array, int s, int e) {
//         if (s < e) {
//             int pivot = partition(array, s, e);
//             quickSort(array, s, pivot - 1);
//             quickSort(array, pivot + 1, e);
//         }
//     }

//     private static int partition(int[] array, int s, int e) {
//         int pivot = array[s];
//         int i = s, j = e + 1;
//         do {
//             do {
//                 i = i + 1;
//             } while (array[i] < pivot && i < e);
//             do {
//                 j = j - 1;
//             } while (array[j] > pivot);
//             swap(array, i, j);
//         } while (i < j);
//         swap(array, i, j);
//         swap(array, s, j);
//         return j;
//     }

//     private static void swap(int[] A, int x, int y) {
//         int temp = A[x];
//         A[x] = A[y];
//         A[y] = temp;
//     }
// }

