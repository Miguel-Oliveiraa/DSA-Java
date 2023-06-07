import java.io.IOException;

public class quickSort {
    public static void main(String[] args) throws IOException {
        int[] array = {8,2,5,3,9,4,7,6,1};
        System.out.println("Antes");
        printList(array);
        quickSort(array, 0, array.length - 1);
        System.out.println("Depois");
        printList(array);
    }

    private static void quickSort(int[] array, int s, int e) {
        if (s < e) {
            int pivot = partition(array, s, e);
            quickSort(array, s, pivot - 1);
            quickSort(array, pivot + 1, e);
        }
    }

    private static int partition(int[] array, int s, int e) {
        int pivot = array[e];
        int i = s - 1;

        for (int j = s; j < e ; j++) {
            if(array[j]<pivot) {
                int temp = array[++i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[e];
        array[e] = temp;

        return i;
    }

    private static void printList(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
