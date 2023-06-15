public class mergeSort {
    public static void main(String[] args) {
        int numeros[] = {75, 456, 54, 43, 3, 9, 7, 0, 2, 123};
        System.out.println("Antes:");
        printArray(numeros);
        System.out.println("");
        mergeSort(numeros, 0, numeros.length-1);
        System.out.println("Depois:");
        printArray(numeros);
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

// #include <iostream>
// using namespace std;

// void printLista(int lista[], int size){
//     for (int i = 0; i < size; i++)
//         if (i == size-1) {
//             cout << lista[i] << "\n";
//         } else {
//             cout << lista[i] << ", ";
//         }
// }

// void merge(int lista[], int size, int l, int r) {
//     int temp[size];
//     for (int i = l; i <= r; i++) {
//         temp[i] = lista[i];
//     }
//     int m = (l+r)/2;
//     int i1 = l, i2 = m+1;
//     for (int c = l; c <= r; c++) {
//         if (i1 == m + 1) {
//             lista[c] = temp[i2++];
//         } else if (i2 > r) {
//             lista[c] = temp[i1++];
//         } else if (temp[i1] <= temp[i2]) {
//             lista[c] = temp[i1++];
//         } else {
//             lista[c] = temp[i2++];
//         }
//     }
// }

// void mergeSort(int lista[], int size, int l, int r) {
//     if (l < r) {
//         int m = (l+r)/2;
//         mergeSort(lista, size, l, m);
//         mergeSort(lista, size, m+1, r);
//         merge(lista, size, l, r);
//     }
// }

// int main() {
// //    int numeros[] = {75, 456, 54, 43, 3, 9, 7, 0, 2, 123};
//     int *numeros = (int*) malloc(10 * sizeof(int));
//     int size = (sizeof(numeros)/ sizeof(int));
//     cout << size;
//     cout << "Antes: ";
//     printLista(numeros, size);
//     mergeSort(numeros, size, 0, size-1);
//     cout << "Depois: ";
//     printLista(numeros, size);


//     return 0;
