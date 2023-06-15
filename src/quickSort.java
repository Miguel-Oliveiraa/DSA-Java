public class quickSort {

    public static void main(String[] args) {
        int[] array = {8,2,5,3,9,4,7,6,1};
        System.out.println("Antes");
        printArray(array);
        System.out.println("");
        quickSort(array, 0, array.length-1);
        System.out.println("Depois");
        printArray(array);
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
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } while (i<j);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        temp = array[s];
        array[s] = array[j];
        array[j] = temp;
        return j;
    }

    private static void printArray(int[] array) {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
    }
}

//        int pivot = array.get(e);
//        int i = s - 1;
//
//        for (int j = s; j < e ; j++) {
//            if(array.get(j)<pivot) {
//                int temp = array.get(++i);
//                array.set(i, array.get(j));
//                array.set(j, temp);
//            }
//        }
//        int temp = array.get(++i);
//        array.set(i, array.get(e));
//        array.set(e, temp);
//
//        return i;


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

// int partition(int lista[], int l, int r) {
//     int pi = lista[l], i = l, j = r+1;
//     do {
//         do {
//             i++;
//         } while (lista[i]<pi && i < r);
//         do {
//             j--;
//         } while (lista[j]>pi);
//         int temp = lista[i];
//         lista[i] = lista[j];
//         lista[j] = temp;
//     } while (i<j);
//     int temp = lista[i];
//     lista[i] = lista[j];
//     lista[j] = temp;

//     temp = lista[l];
//     lista[l] = lista[j];
//     lista[j] = temp;
//     return j;
// }

// void quickSort(int lista[], int l, int r) {
//     if (l<r){
//         int pi = partition(lista, l, r);
//         quickSort(lista,l,pi-1);
//         quickSort(lista,pi+1,r);
//     }
// }

// int main(){
//     int numeros[] = {75, 456, 54, 43, 3, 9, 7, 0, 2, 123};
//     int size = (sizeof(numeros)/ sizeof(int));
//     cout << "Antes: ";
//     printLista(numeros, size);
//     quickSort(numeros, 0, size-1);
//     cout << "Depois: ";
//     printLista(numeros, size);
//     cout << "\n";

//     return 0;
// }
