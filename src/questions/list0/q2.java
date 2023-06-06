package questions.list0;

import java.io.IOException;
import java.util.Scanner;

public class q2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int num = scanner.nextInt();
        if (num > 2 && num % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
