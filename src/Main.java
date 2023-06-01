import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println("Antes:");
        printList(numbers);
        mergeSort(numbers);

        System.out.println("Depois:");
        printList(numbers);
    }

    public static void mergeSort(int[] lista) {
        int inputLength = lista.length;

        if(inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = lista[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = lista[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(lista, leftHalf, rightHalf);
    }

    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void printList(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}