import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os números separados por espaço:");
//        String input = scanner.nextLine();

        // Dividindo a entrada em substrings separadas por espaço
        String[] numerosString = scanner.nextLine().split(" ");

        ArrayList<Integer> numeros = new ArrayList<>();

        for (String numeroString : numerosString) {
            int numero = Integer.parseInt(numeroString);
            numeros.add(numero);
        }

        System.out.println("Números armazenados no ArrayList:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
