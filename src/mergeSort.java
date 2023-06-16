import java.util.Scanner;

//A entrada consiste de vários casos. A primeira linha contém o inteiro c (1 ≤ c ≤ 10), o número de casos.
//A primeira linha de cada caso contém o inteiro n (1 ≤ n ≤ 105), o tamanho do array que deve ser ordenado.
//A segunda linha de cada caso contém n inteiros separados por espaço, os elementos do array.
// input:
//3
//7
//84 1 6 27 48 12 3
//1
//3
//5
//4 5 1 9 2
// output:
//1 3 6 12 27 48 84
//3
//1 2 4 5 9


public class mergeSort {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            int lista[] = new int[size];
//            scanner.nextLine();
//            String[] nome = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                lista[j] = scanner.nextInt();
            }
            mergeSort(lista, 0, lista.length-1);
            printArray(lista);
            System.out.println("");
        }
    }
    public static void mergeSort(int[] lista, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(lista, l, m);
            mergeSort(lista, m+1, r);
            merge(lista, l, r);
        }
    }

    public static void merge(int[] lista, int l, int r) {
        int temp[] = new int[lista.length];
        for (int i = l; i <= r; i++) {
            temp[i] = lista[i];
        }
        int m = (l+r)/2;
        int i1 = l, i2 = m+1;
        for (int c = l; c <= r; c++) {
            if (i1 == m+1) {
                lista[c] = temp[i2++];
            }
            else if (i2>r) {
                lista[c] = temp[i1++];
            } else if (temp[i1] <= temp[i2]) {
                lista[c] = temp[i1++];
            } else{
                lista[c] = temp[i2++];
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
    }
}
