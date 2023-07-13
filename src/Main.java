import dataStructures.ArrayList;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList lista = new ArrayList(2);
        lista.insert("x");
        lista.insert("y");
        System.out.println(lista.count("y"));
    }
}

