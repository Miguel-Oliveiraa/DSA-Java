package algorithms;

import java.util.Scanner;

// Questão
//A primeira linha da entrada contém o inteiro n (1 ≤ n ≤ 105), o tamanho do array.
//A segunda linha contém n inteiros separados por espaço, o array ordenado de forma
//crescente (não há números repetidos no array). Em seguida, há uma linha com o
//inteiro m (1 ≤ m ≤ 105), a quantidade de números que devem ser procurados no array.
//As próximas m linhas contêm, cada uma, o inteiro v (1 ≤ v ≤ 109), o número que deve ser procurado no array.
// input:
//9
//1 2 6 9 12 13 14 17 24
//4
//1
//17
//24
//99
// output:
//0
//7
//8
//x

public class binarySearch {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int size = scanner.nextInt();
        int lista[] = new int[size];
        for (int i = 0; i < size; i++) {
            lista[i] = scanner.nextInt();
        }
        int nBuscas = scanner.nextInt();
        for (int i = 0; i < nBuscas; i++) {
            int n = scanner.nextInt();
            System.out.println(buscaBinaria(lista, n));
        }
    }

    private static String buscaBinaria(int[] lista, int alvo) {
        int l = 0;
        int r = lista.length-1;
        while (l<=r){
            int m = l+(r-l)/2;
            if (lista[m] == alvo) return Integer.toString(m);
            else if (alvo < lista[m]) r = m-1;
            else l = m+1;
        }
        return "x";
    }
}
