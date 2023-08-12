package questions.list03;

import java.util.Scanner;

public class Main {

    static boolean add(String[] myMap, String key) {
        int h, hash, newHash;
        h = 0;
        for (int i = 0; i < key.length(); i++) {
            h += (int) key.charAt(i) * (i + 1);
        }
        hash = (h * 19) % 101;
        // Check if duplicate value
        if (myMap[hash] == key) {
            // Hash already added in first position
            return false;
        } else {
            for (int j = 1; j <= 19; j++) {
                newHash = (hash + (23 * j) + (j * j)) % 101;
                if (myMap[newHash] == key) {
                    return false;
                }
            }
        }
        // It is not a duplicate value, therefore ADD
        if (myMap[hash].equals("")) {
            myMap[hash] = key;
            return true;
        }
        for (int j = 1; j <= 19; j++) {
            newHash = (hash + (j * j) + (23 * j)) % 101;
            // If the new index is empty
            if (myMap[newHash].equals("")) {
                myMap[newHash] = key;
                return true;
            }
        }
        return false;
    }

    static boolean del(String[] myMap, String key) {
        for (int i = 0; i < 101; i++) {
            // If the key was found, remove it
            if (myMap[i].equals(key)) {
                myMap[i] = "";
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int testcase = 0; testcase < N; testcase++) {
            int m = scanner.nextInt();
            // Start from 0 for each testcase
            int numberOfEntries = 0;
            // Clear the map for each testcase
            String[] myMap = new String[101];
            for (int i = 0; i < 101; i++) {
                myMap[i] = "";
            }
            for (int operation = 0; operation < m; operation++) {
                String op = scanner.next();
                // ADD operation
                if (op.substring(0, 3).equals("ADD")) {
                    String key = op.substring(4);
                    if (add(myMap, key)) {
                        numberOfEntries += 1;
                    }
                }
                // DEL operation
                else if (op.substring(0, 3).equals("DEL")) {
                    String key = op.substring(4);
                    if (del(myMap, key)) {
                        numberOfEntries -= 1;
                    }
                }
            }
            // Print numberOfEntries and myMap
            System.out.println(numberOfEntries);
            for (int i = 0; i < 101; i++) {
                if (!myMap[i].equals("")) {
                    System.out.println(i + ":" + myMap[i]);
                }
            }
        }
    }
}
