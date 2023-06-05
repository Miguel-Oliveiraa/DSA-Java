public class Main {
    public static void main(String[] args) {
        int numeros[] = {75, 456, 54, 43, 3, 9, 7, 0, 2, 123};
        System.out.println("Antes:");
        printList(numeros);
        mergeSort(numeros, 0, numeros.length-1);
        System.out.println("Depois:");
        printList(numeros);
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

    public static void printList(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}

// import java.util.Random;

// public class mergeSort {
//     public static void main(String[] args) {
//         Random rand = new Random();
//         int[] numbers = new int[10000];

//         for (int i = 0; i < numbers.length; i++) {
//             numbers[i] = rand.nextInt(1000000);
//         }

//         System.out.println("Antes:");
//         printList(numbers);
//         mergeSort(numbers);

//         System.out.println("Depois:");
//         printList(numbers);
//     }

//     public static void mergeSort(int[] lista) {
//         int inputLength = lista.length;

//         if(inputLength < 2) {
//             return;
//         }

//         int midIndex = inputLength / 2;
//         int[] leftHalf = new int[midIndex];
//         int[] rightHalf = new int[inputLength - midIndex];

//         for (int i = 0; i < midIndex; i++) {
//             leftHalf[i] = lista[i];
//         }

//         for (int i = midIndex; i < inputLength; i++) {
//             rightHalf[i - midIndex] = lista[i];
//         }

//         mergeSort(leftHalf);
//         mergeSort(rightHalf);
//         merge(lista, leftHalf, rightHalf);
//     }

//     public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
//         int leftSize = leftHalf.length;
//         int rightSize = rightHalf.length;

//         int i = 0, j = 0, k = 0;

//         while (i < leftSize && j < rightSize) {
//             if (leftHalf[i] <= rightHalf[j]){
//                 inputArray[k] = leftHalf[i];
//                 i++;
//             } else {
//                 inputArray[k] = rightHalf[j];
//                 j++;
//             }
//             k++;
//         }

//         while (i < leftSize) {
//             inputArray[k] = leftHalf[i];
//             i++;
//             k++;
//         }
//         while (j < rightSize) {
//             inputArray[k] = rightHalf[j];
//             j++;
//             k++;
//         }
//     }

//     public static void printList(int[] lista) {
//         for (int i = 0; i < lista.length; i++) {
//             System.out.println(lista[i]);
//         }
//     }
// }
