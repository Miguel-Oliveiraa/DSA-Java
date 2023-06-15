import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Digite os números separados por espaço:");

        // Dividindo a entrada em substrings separadas por espaço
        String[] numerosString = scanner.nextLine().split(" ");

        Integer[] numeros = new Integer[numerosString.length];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(numerosString[i]);
        }

        System.out.println("Números armazenados no ArrayList:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
