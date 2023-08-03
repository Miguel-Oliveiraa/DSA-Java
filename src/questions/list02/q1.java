package questions.list02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q1 {
//    private static FastReader sc = new FastReader();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            String teste = scanner.nextLine();
            System.out.println(cases(teste));
        }
    }

    public static StringBuilder cases(String nome) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> array = new ArrayList<Character>(nome.length());

        for (int i = 0; i < nome.length(); i++) {
            if (Objects.equals('[', nome.charAt(i))) {
                array.moveToStart();
            } else if (Objects.equals(']', nome.charAt(i))) {
                array.moveToEnd();
            } else {
                array.insert(nome.charAt(i));
            }
        }

        for (int i = 0; i < array.length(); i++) {
            array.moveToPos(i);
            result.append(array.getValue());
        }

        return result;
    }

    private static class ArrayList<E> {
        // Attributes
        private static final int defaultSize = 10; // Default size
        private int maxSize; // Max size of list
        private int listSize; // Current number of list items
        private int curr; // Current element pos
        private E[] listArray; // Array holding list elements

        // Constructors
        ArrayList() {this(defaultSize);}; // Create a list with the default size.
        @SuppressWarnings("unchecked")
        public // Generic array allocation
        ArrayList(int size) {
            maxSize= size;
            listSize = curr = 0;
            listArray = (E[])new Object[size]; // Create listArray
        }

        // Methods
        public void clear() {
            listSize = curr = 0; // Reinitialize  values
        }

        public void insert(E it) {
            assert listSize < maxSize : "List capacity exceeded";
            for (int i = listSize; i > curr; i--) {
                listArray[i] = listArray[i-1];
            }
            listArray[curr] = it;
            curr++;
            listSize++;
        }

        public void append(E it) {
            assert listSize < maxSize : "List capacity exceeded";
            listArray[listSize++] = it;
        }

        public E remove(){
            if ((curr<0) || (curr>=listSize))
                return null;
            E it = listArray[curr];
            for (int i = curr; i < listSize - 1; i++) {
                listArray[i] = listArray[i+1];
            }
            listSize--;
            return it;
        }

        public void moveToStart() {
            curr = 0;
        }
        public void moveToEnd() { curr = listSize; }

        public void prev() {
            if (curr != 0)
                curr--;
        }

        public void next() {
            if (curr < maxSize)
                curr ++;
        }

        public int length() {
            return listSize;
        }

        public int currPos() {
            return curr;
        }

        public void moveToPos(int pos) {
            assert (pos>=0) && (pos < listSize) : "Pos out of range";
            curr = pos;
        }

        public E getValue(){
            assert (curr>=0) && (curr < listSize) : "No current element";
            return listArray[curr];
        }

        public int count(E it){
            int c = 0;
            for (int i = 0; i < listSize; i++) {
                if (listArray[i] == it) c++;
            }
            return c;
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
