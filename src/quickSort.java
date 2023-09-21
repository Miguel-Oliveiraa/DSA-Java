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
//84 48 27 12 6 3 1
//3
//9 5 4 2 1


public class quickSort {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            int lista[] = new int[size];
            for (int j = 0; j < size; j++) {
                lista[j] = scanner.nextInt();
            }
            quickSort(lista, 0, lista.length-1);
            printArray(lista);
        }
    }

    public static void quickSort(int[] array, int s, int e) {
        if (s < e) {
            int pivot = partition(array, s, e);
            quickSort(array, s, pivot - 1);
            quickSort(array, pivot + 1, e);
        }
    }

    private static int partition(int[] array, int s, int e) {
//        ordem crescente
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
//        ordem não-crescente
        // int pivot = array[e];
        // int i = s-1, j = e;
        // do {
        //     do {
        //         i = i + 1;
        //     }while (array[i]>pivot);
        //     do {
        //         j = j -1;
        //     } while (array[j]<pivot && j>s);
        //     swap(array,i,j);
        // } while (j>i);
        // swap(array,i,j);
        // swap(array,e,i);
        // return i;
    }

    private static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length-1) {
                System.out.print(array[i]+" ");
            } else {
                System.out.println(array[i]);
            }
        }
    }
}

