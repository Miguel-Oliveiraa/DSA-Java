package questions.list0;

import java.io.IOException;
import java.util.Scanner;

//https://vjudge.net/contest/562267#problem/A
public class q1 {
//    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numeros = scanner.nextLine().split(" ");
        scanner.close();
        long n = Long.parseLong(numeros[0]);
        long m = Long.parseLong(numeros[1]);
        long a = Long.parseLong(numeros[2]);
        long j = (n%a==0) ? n/a : n/a + 1;
        long k = (m%a==0) ? m/a : m/a + 1;
        System.out.println(j * k);
    }
}
