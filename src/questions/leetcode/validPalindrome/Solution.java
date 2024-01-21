package questions.leetcode.validPalindrome;
import java.util.Objects;

// Source : https://leetcode.com/problems/valid-palindrome/
// Author : Miguel Oliveira
// Date   : 21-01-2024

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i<j){
            char startChar = s.charAt(i);
            char endChar = s.charAt(j);
            boolean jumpIterration = false;
            if (!Character.isLetterOrDigit(startChar)) {
                i++;
                jumpIterration = true;
            }
            if (!Character.isLetterOrDigit(endChar)) {
                j--;
                jumpIterration = true;
            }
            if (!jumpIterration) {
                if (Objects.equals(Character.toLowerCase(startChar), Character.toLowerCase(endChar))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}