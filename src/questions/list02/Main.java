package questions.list02;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Faça o processamento da linha aqui
            System.out.println(line); // Exemplo: apenas imprimir a linha
        }
        scanner.close();
    }
}