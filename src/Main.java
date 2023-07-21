import dataStructures.ArrayList;
import dataStructures.ClosedHashTable;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ClosedHashTable dict = new ClosedHashTable(size);

        String comando;
        for (int i = 0; i < size; i++) {
            comando = scanner.next();
            if (Objects.equals(comando,"add")) {
                String key = scanner.next();
                dict.insert(key);
            }
            if (Objects.equals(comando, "rmv")) {
                String key = scanner.next();
                dict.remove(key);
            }
            if (Objects.equals(comando, "sch")) {
                String key = scanner.next();
                int index = dict.find(key);
                System.out.println(key + " " + index);
            }
        }
    }
}

