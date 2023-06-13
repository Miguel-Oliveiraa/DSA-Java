import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) throws IOException {
//        int[] array = {8,2,5,3,9,4,7,6,1};
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,6,9,1,4,6));
        System.out.println("Antes");
        System.out.println(array);
        quickSort(array, 0, array.size()-1);
        System.out.println("Depois");
        System.out.println(array);
    }

    private static void quickSort(ArrayList<Integer> array, int s, int e) {
        if (s < e) {
            int pivot = partition(array, s, e);
            quickSort(array, s, pivot - 1);
            quickSort(array, pivot + 1, e);
        }
    }

    private static int partition(ArrayList<Integer> array, int s, int e) {
        int pivot = array.get(s);
        int i = s;
        int j = e+1;
        do  {
            do {
                i = i + 1;
            } while (array.get(i)<pivot && i<e);
            do {
                j = j -1;
            } while (array.get(j)>pivot);
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        } while (i<j);
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
        temp = array.get(s);
        array.set(s, array.get(j));
        array.set(j, temp);
        return j;
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
