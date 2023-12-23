package questions.leetcode.mergeStringsAlternately;
// Source : https://leetcode.com/problems/merge-strings-alternately/
// Author : Miguel Oliveira
// Date   : 23-12-2023

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Size = word1.length(), word2Size = word2.length(), max = word1Size + word2Size;
        int i = 0, w1 = 0, w2 = 0; // Pointers
        StringBuilder result = new StringBuilder();
        while (i<max) {
            if (w1 < word1Size) {
                result.append(word1.charAt(i));
                w1++;
            }
            if (w2 < word2Size) {
                result.append(word2.charAt(i));
                w2++;
            }
            i++;
        }
        return result.toString();
    }
}