public class binarySearch {
    public static void main(String[] args) {
        long numeros[] = {1,2,3,6,9,10,15,18,20,34,50,69,43,80};
        System.out.println(buscaBinaria(numeros,10));
        System.out.println(buscaBinaria(numeros,50));
        System.out.println(buscaBinaria(numeros,33));
        System.out.println(buscaBinaria(numeros,80));
    }

    private static int buscaBinaria(long[] lista, int alvo) {
        int l = 0;
        int r = lista.length-1;
        while (l<=r){
            int m = (r+l)/2;
            if (lista[m] == alvo) return m;
            else if (alvo < lista[m]) r = m-1;
            else l = m+1;
        }
        return -1;
    }
}
