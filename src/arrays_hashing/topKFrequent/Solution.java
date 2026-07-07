package arrays_hashing.topKFrequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static int[] topKFrequent(int[] nums, int k) {
		
		// BUCKET SORT
		
		// key -> numero; value -> frecuencia
		Map<Integer, Integer> acum = new HashMap<>();
		List<List<Integer>> freq = new ArrayList<>();
		
		for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

		
		for(int num : nums) {
			if(!acum.containsKey(num)) {
				acum.put(num, 0);
			}
			acum.put(num, acum.get(num)+1);
		}
		
		// Para cada entrada en el map: 
		for(Map.Entry<Integer, Integer> entry : acum.entrySet()) {
			freq.get(entry.getValue()).add(entry.getKey());
		}
		
		int[] res = new int[k];
		int index = 0;
		for(int i = freq.size() - 1; i > 0 && index < k; i--) {
			for(int n : freq.get(i)) {
				res[index] = n;
				index++;
				if(index == k) return res;
			}
		}
		
		return res;
        
    }
	
	public static void main(String[] args) {
		System.out.println("------------------TEST 1------------------\n");
		int[] nums = {1, 2, 2, 3, 3, 3};
		int k = 2;
		
		System.out.println("Input: " + Arrays.toString(nums));
		System.out.println("Output: " + Arrays.toString(topKFrequent(nums, k)) + "\n");
		
		System.out.println("------------------TEST 2------------------\n");
		int[] nums2 = {7, 7};
		int k2 = 1;
		
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Output: " + Arrays.toString(topKFrequent(nums2, k2)) + "\n");
		
	}
}
