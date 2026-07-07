package arrays_hashing.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> res = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++) {
			int[] count = new int[26];
			char[] charArray = strs[i].toCharArray();
			
			for(int j = 0; j < charArray.length; j++) {
				count[charArray[j] - 'a']++;
			}
			String key = Arrays.toString(count);
			if(!res.containsKey(key)) {
				res.put(key, new ArrayList<>());
			}
			res.get(key).add(strs[i]);
			
		}
		return new ArrayList<>(res.values());
		
	}
	
	public static void main(String[] args) {
		// Test1
		System.out.println("------------------TEST 1------------------\n");
		
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		System.out.println("Input: strs = [" + Arrays.toString(strs) + "]");
		System.out.println("Output: " + groupAnagrams(strs));
		
		// Test2
		System.out.println("------------------TEST 2------------------\n");
		
		String[] strs2 = {"x"};
		System.out.println("Input: strs = [" + Arrays.toString(strs2) + "]");
		System.out.println("Output: " + groupAnagrams(strs2));
		
		// Test3
		System.out.println("------------------TEST 1------------------\n");
		
		String[] strs3 = {""};
		System.out.println("Input: strs = [" + Arrays.toString(strs3) + "]");
		System.out.println("Output: " + groupAnagrams(strs3));
	}
}
