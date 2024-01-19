package questions.leetcode.removeDuplicatesFromSortedArray;

// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Author : Miguel Oliveira
// Date   : 18-01-2024

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(i!= nums.length && j!= nums.length){
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        i++;
        return i;
    }
}