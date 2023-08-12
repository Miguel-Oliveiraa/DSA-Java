package questions.list02;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList texto = new LinkedList();

        while (scanner.hasNext()) {
            String entrada = scanner.next();
            for (int i = 0; i < entrada.length(); i++) {
                if (entrada.charAt(i) == '[') {
                    texto.moveToStart();
                } else if (entrada.charAt(i) == ']') {
                    texto.moveToEnd();
                } else {
                    texto.insert(entrada.charAt(i));
                }
            }

            texto.print();
            texto.clear();
        }
    }

    static class LinkedList {
        static class Node {
            public char data;
            public Node next;

            public Node(char element, Node nextNode) {
                data = element;
                next = nextNode;
            }

            public Node(Node nextNode) {
                next = nextNode;
            }
        }
        private Node head;
        private Node tail;
        private Node curr;
        private int size;

        private void init() {
            curr = tail = head = new Node(null);
            size = 0;
        }

        private void removeAll() {
            while (head != null) {
                curr = head;
                head = head.next;
                curr = null;  // Manually set to null for garbage collection
            }
        }

        public LinkedList() {
            init();
        }

        public void clear() {
            removeAll();
            init();
            curr = tail = head;
        }

        public void insert(char value) {
            curr.next = new Node(value, curr.next);
            if (tail == curr) {
                tail = curr.next;
            }
            curr = curr.next;
            size++;
        }

        public void moveToStart() {
            curr = head;
        }

        public void moveToEnd() {
            curr = tail;
        }

        public void print() {
            curr = head.next;
            while (curr != null) {
                System.out.print(curr.data);
                curr = curr.next;
            }
            System.out.println();
        }
    }


}

