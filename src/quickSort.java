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

