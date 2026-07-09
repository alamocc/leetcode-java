package arrays_hashing.longestConsecutive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
        int longest = 0;
        
        for(int num : nums) {
        	numSet.add(num);
        }
        
        for(int num : nums) {
        	int streak = 0, curr = num;
        	
        	while(numSet.contains(curr)) {
        		streak++;
        		curr++;
        	}
        	longest = Math.max(streak, longest);
        }
        return longest;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,20,4,10,3,4,5};
		System.out.println("Input: " + Arrays.toString(nums));
		System.out.println("Output: " + longestConsecutive(nums) + "\n");
		
		int[] nums2 = {0,3,2,5,4,6,1,1};
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Output: " + longestConsecutive(nums2));
		
	}
}
