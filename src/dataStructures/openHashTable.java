package dataStructures;

import java.util.LinkedList;
import java.util.Scanner;

public class openHashTable {
    private static LinkedList<Integer>[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            array[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            int position = hash(input);
            array[position].add(input);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            for (int j = 0; j < array[i].size(); j++) {
                System.out.print(" " + array[i].get(j));
            }
            System.out.println("");
        }
    }

    static int hash(Integer k) {
        return k%10;
    }
}
