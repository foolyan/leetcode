package solution;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述: Longest Substring Without Repeating Characters
 * 
 */

public class LongestNoRepeatSubString {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestNoRepeatSubString().lengthOfLongestSubstring("abcabcbb"));
	}

//	public int lengthOfLongestSubstring(String s) {
//		if(s == null)
//			return 0;
//		
//		int len = 1;
//		char[] chars = s.toCharArray();
//		for (int i = 0; i < s.length(); i++) {
//			int temp = 0;
//			Set set = new HashSet();
//			for (int j = i; j < s.length(); j++) {
//				if (!set.contains(chars[j])) {
//					set.add(chars[j]);
//					temp++;
//				} else {
//					break;
//				}
//			}
//			if (temp > len)
//				len = temp;
//		}
//
//		return len;
//	}

	public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int maxLen = 1;
        int dupNextIndex = 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash.containsKey(c)) {                    
                maxLen = Math.max(maxLen, i - dupNextIndex);
                dupNextIndex = Math.max(hash.get(c) + 1, dupNextIndex);
            }
            hash.put(c, i);
        }

        maxLen = Math.max(maxLen, s.length() - dupNextIndex);

        return maxLen;
    }
}
