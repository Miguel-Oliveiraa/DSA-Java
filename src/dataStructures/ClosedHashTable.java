package dataStructures;

import java.util.Objects;

public class ClosedHashTable {

    static int m;
    static int cnt;
    static java.util.ArrayList<Entry> H;

    public ClosedHashTable(int size) {
        m = size;
        cnt = 0;
        H = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            H.add(i, null);
        }
    }

    //Fold hash function
    private int hashFunction(String key, int m) {
        int sum = 0;
        int word_size = 4;
        int num_words = (key.length() + word_size -1) / word_size;

        for (int i = 0; i < num_words; i++) {
            int start = i*word_size;
            int end = Math.min(start + word_size, key.length());
            String word = key.substring(start, end);

            int wordHash = 0;
            for (char c : word.toCharArray()) {
                wordHash += (int) c;
            }

            sum += wordHash;
        }
        return sum % m;
    }

    public void insert(String k) {
        int pos = hashFunction(k, m);
        int i = 0;
        while (i<m) {
            int probe_pos = (pos+i)%m;
            if (H.get(probe_pos) == null) {
                Entry value = new Entry(k, probe_pos);
                H.add(probe_pos, value);
                cnt++;
                return;
            }
            i++;
        }
        System.out.println("Lista cheia");
    }

    public int find(String k) {
        int pos = hashFunction(k, m);
        int i = 0;
        while (i<m) {
            int probe_pos = (pos+i)%m;
            if (H.get(probe_pos) != null && Objects.equals(H.get(probe_pos).key, k)) {
                return H.get(probe_pos).value;
            }
            i++;
        }
        return -1;
    }

    public void remove(String k) {
        int pos = hashFunction(k, m);
        int i = 0;
        while (i<m) {
            int probe_pos = (pos+i)%m;
            if (H.get(probe_pos) != null && Objects.equals(H.get(probe_pos).key, k)) {
                H.add(probe_pos,null);
                cnt--;
            }
            i++;
        }
    }

    static class Entry {
        String key;
        int value;

        Entry(String k, int v) {
            key = k;
            value = v;
        }
    }
}
