package arrays_hashing.isAnagram;

import java.util.HashMap;

public class Solution {

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		HashMap<Character, Integer> countS = new HashMap<>();
		HashMap<Character, Integer> countT = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(!countS.containsKey(s.charAt(i))) {
				countS.put(s.charAt(i), 0);
			}
			countS.put(s.charAt(i), countS.get(s.charAt(i))+1);
			
			if(!countT.containsKey(t.charAt(i))) {
				countT.put(t.charAt(i), 0);
			}
			countT.put(t.charAt(i), countT.get(t.charAt(i))+1);
		}
		return countS.equals(countT);
	}
	
	public static void main(String[] args) {
		String s = "racecar", r = "carrace";
		System.out.println("Input: s = \"" + s + "\", r = \"" + r + "\"");
		System.out.println("Output: " + isAnagram(s, r) + "\n");
		
		String s2 = "jar", r2 = "jam";
		System.out.println("Input: s = \"" + s2 + "\", r = \"" + r2 + "\"");
		System.out.println("Output: " + isAnagram(s2, r2));
	}
}


