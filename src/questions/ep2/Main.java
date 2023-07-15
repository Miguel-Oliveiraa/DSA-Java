package questions.ep2;

import java.util.Objects;
import java.util.Scanner;

//Question
//https://iudex.io/problem/63e4ebac8216f900013be22a/statement

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultado = new StringBuilder();
        String input = scanner.nextLine();
        while (!Objects.equals(input, "EOF")) {
            String[] comando = input.split(" ");
            LStack calc = new LStack();
            for (String element:
                    comando) {
                Integer v1;
                Integer v2;
                if (Objects.equals(element,"+")) {
                    v1 = calc.pop();
                    v2 = calc.pop();
                    calc.push(v2+v1);
                } else if (Objects.equals(element,"-")) {
                    v1 = calc.pop();
                    v2 = calc.pop();
                    calc.push(v2-v1);
                } else if (Objects.equals(element,"*")) {
                    v1 = calc.pop();
                    v2 = calc.pop();
                    calc.push(v2*v1);
                } else if(Objects.equals(element,"END")) {
                    continue;
                }
                else {
                    calc.push(Integer.parseInt(element));
                }
            }
            resultado.append(calc.pop() + "\n");
            input = scanner.nextLine();
        }
        System.out.print(resultado);
    }

    static class NodeLink {
        private Integer element;
        private NodeLink next;


        NodeLink(Integer it, NodeLink nextVal) {
            element = it;
            next = nextVal;
        }
        NodeLink(NodeLink nextVal) {
            next=nextVal;
        }


        NodeLink next() {
            return next;
        }
        NodeLink setNext(NodeLink nextVal) {
            return next = nextVal;
        }
        Integer element() {
            return element;
        }
        Integer setElement(Integer it) {
            return element = it;
        }
    }

    static class LStack {
        private NodeLink top;
        private int size;

        // Constructors
        public LStack() {
            top = null; size = 0;
        }
        public LStack(int size) {
            top = null; size = 0;
        }

        // Methods
        public void push(Integer it) {
            top = new NodeLink(it, top);
            size++;
        }
        public Integer pop() {
            assert top != null : "Stack is empty";
            Integer it = top.element();
            top = top.next();
            size--;
            return it;
        }
        public Integer topValue() {
            assert top != null : "Stack is empty";
            return top.element();
        }
        public int length() {
            return size;
        }
    }
}