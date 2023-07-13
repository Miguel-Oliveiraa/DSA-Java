package questions.ap5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class q1 {

    private static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        int c = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= c; i++) {
            LinkedStack stack = new LinkedStack();
            result.append("Caso " + (i) + ":\n");
            String request = scanner.nextLine();
            while (!Objects.equals(request, "end")) {
                String[] newRequest = request.split(" ");
                if (Objects.equals(newRequest[0], "push")) {
                    stack.push(Integer.parseInt(newRequest[1]));
                } else if (Objects.equals(newRequest[0], "pop")) {
                     result.append(stack.pop(Integer.parseInt(newRequest[1])) + "\n");
                }
                request = scanner.nextLine();
            }
        }
        System.out.println(result);
    }

    static class Link {
        // Attributes
        private int element; // Value of this node
        private Link next; // Pointer to next node

        // Constructors
        Link(int it, Link nextVal) {
            element = it;
            next = nextVal;
        }
        Link(Link nextVal) {
            next=nextVal;
        }

        // Methods
        Link next() {
            return next; // Return next field
        }
        Link setNext(Link nextVal) {
            return next = nextVal; // Set next field
        }
        int element() {
            return element;  // Return element
        }
        int setElement(int it) {
            return element = it; // Set element field
        }
    }

    static class LinkedStack<E> {
        // Attributes
        private Link top; // Pointer to first element
        private int size; // Number of element

        // Constructors
        public LinkedStack() {
            top = null; size = 0;
        }
        public LinkedStack(int size) {
            top = null; size = 0;
        }

        // Methods
        public void clear() {
            top = null; size = 0;
        }

        public void push(int it) {
            top = new Link(it, top);
            size++;
        }

        public int pop(int n) {
            assert top != null : "Stack is empty";
            int c = 0;
            for (int i = 0; i < n; i++) {
                c += top.element();
                top = top.next();
                size--;
            }
            return c;
        }

        public int topValue() {
            assert top != null : "Stack is empty";
            return top.element();
        }

        public int length() {
            return size;
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
