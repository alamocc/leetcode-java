package advanced_graphs.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> acum = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (acum.contains(nums[i])) {
				return true;
			}
			acum.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3};
		System.out.println("Input: " + Arrays.toString(nums));
		System.out.println("Output: " + containsDuplicate(nums));
		
		int[] numsFalse = {1, 2, 3, 4};
		System.out.println("Input: " + Arrays.toString(numsFalse));
		System.out.println("Output: " + containsDuplicate(numsFalse));
	}
}