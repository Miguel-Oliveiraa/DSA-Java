package questions.list05;

import java.util.*;

public class Main {
    static final String name = "Ahmad";
    static Map<String, Integer> m = new HashMap<>();
    static Set<String>[] ans = new HashSet[150];
    static Set<String> pos = new HashSet<>();
    static String[][] s = new String[105][4];
    static int t, n;

    static void check(int x, int y, int z) {
        if (ans[x].contains(s[y][z])) {
            for (int i = 1; i <= 2; i++) {
                if (!m.containsKey(s[y][(z + i) % 3])) {
                    ans[x + 1].add(s[y][(z + i) % 3]);
                    m.put(s[y][(z + i) % 3], 1);
                }
            }
        }
    }

    static void checkUndefined(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (!m.containsKey(s[i][j])) {
                    pos.add(s[i][j]);
                    m.put(s[i][j], 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 0; i < 150; i++) {
            ans[i] = new HashSet<>();
        }

        while (t-- > 0) {
            n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    s[i][j] = scanner.next();
                }
            }

            m.put(name, 1);
            ans[0].add(name);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 3; k++) {
                        check(i, j, k);
                    }
                }
            }

            checkUndefined(n);

            System.out.println(m.size());

            for (int i = 0; i <= n; i++) {
                if (ans[i].isEmpty()) break;
                for (String s : ans[i]) {
                    System.out.println(s + " " + i);
                }
            }

            for (String p : pos) {
                System.out.println(p + " undefined");
            }

            for (int i = 0; i < 150; i++) {
                ans[i].clear();
            }

            pos.clear();
            m.clear();
        }
    }
}

