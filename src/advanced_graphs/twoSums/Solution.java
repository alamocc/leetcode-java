package advanced_graphs.twoSums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int difference = target - nums[i];

			if (map.containsKey(difference))
				return new int[] { map.get(difference), i };

			map.put(nums[i], i);
		}

		return new int[] {};
	}

	public static void main(String[] args) {
		// Test1
		System.out.println("------------------TEST 1------------------\n");

		int[] nums = { 3, 4, 5, 6 };
		int target = 7;

		System.out.println("Input: \n");
		System.out.println("nums = " + Arrays.toString(nums) + ", target = " + target);

		System.out.println("Output: " + Arrays.toString(twoSum(nums, target)) + "\n");

		// Test2
		System.out.println("------------------TEST 2------------------\n");

		int[] nums2 = { 4, 5, 6 };
		int target2 = 10;

		System.out.println("Input: \n");
		System.out.println("nums = " + Arrays.toString(nums2) + ", target = " + target2);

		System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2)) + "\n");

		// Test3
		System.out.println("------------------TEST 3------------------\n");
		
		int[] nums3 = { 5, 5 };
		int target3 = 10;

		System.out.println("Input: \n");
		System.out.println("nums = " + Arrays.toString(nums3) + ", target = " + target3);

		System.out.println("Output: " + Arrays.toString(twoSum(nums3, target3)) + "\n");
	}
}
