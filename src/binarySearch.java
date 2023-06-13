import java.util.ArrayList;
import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,6,9,10,15,18,20,34,50,69,43,80));
        System.out.println(buscaBinaria(numeros,10));
        System.out.println(buscaBinaria(numeros,50));
        System.out.println(buscaBinaria(numeros,33));
        System.out.println(buscaBinaria(numeros,80));
    }

    private static int buscaBinaria(ArrayList<Integer> lista, int alvo) {
        int l = 0;
        int r = lista.size()-1;
        while (l<=r){
            int m = (r+l)/2;
            if (lista.get(m) == alvo) return m;
            else if (alvo < lista.get(m)) r = m-1;
            else l = m+1;
        }
        return -1;
    }
}
