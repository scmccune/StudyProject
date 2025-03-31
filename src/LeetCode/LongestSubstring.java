package LeetCode;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class LongestSubstring {
    /// Given a string s, find the length of the longest substring without duplicate characters.
    ///
    ///
    ///
    /// Example 1:
    ///
    /// Input: s = "abcabcbb"
    /// Output: 3
    /// Explanation: The answer is "abc", with the length of 3.
    /// Example 2:
    ///
    /// Input: s = "bbbbb"
    /// Output: 1
    /// Explanation: The answer is "b", with the length of 1.
    /// Example 3:
    ///
    /// Input: s = "pwwkew"
    /// Output: 3
    /// Explanation: The answer is "wke", with the length of 3.
    /// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    ///
    ///
    /// Constraints:
    ///
    /// 0 <= s.length <= 5 * 104
    /// s consists of English letters, digits, symbols and spaces.
    public LongestSubstring() {
        System.out.println("Longest unique substring for : abcabcbb is : " + findLongestString2("abcabcbb") + " OR " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest unique substring for : bbbbb is : " + findLongestString2("bbbbb") + " OR " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Longest unique substring for : abcabcbb is : " + findLongestString2("abcabcbb") + " OR " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest unique substring for : pwwkew is : " + findLongestString2("pwwkew") + " OR " + lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int [] arr = new int[128];
        int l=0;
        int maxnum=0;

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            l=Math.max(l,arr[c]);
            maxnum=Math.max(maxnum,i-l+1);
            arr[c] = i + 1;
        }
        return maxnum;
    }


    private static int findLongestString2(String s) {
        int maxSize = 0;
        LinkedList<Character> list = new LinkedList<>();
        for(Character c: s.toCharArray()) {
            if (list.contains(c)) {
                if (maxSize < list.size()) {
                    maxSize = list.size();
                }
                while (list.contains(c)) {
                    list.removeFirst();
                }
            }
            list.add(c);
        }
        return Math.max(list.size(), maxSize);
    }


    private static void findLongestString(String s) {
        String longestString = "";
        int count = 0;
        List<Character> charList = new ArrayList<>();

        for(Character c:  s.toCharArray())
        {
            if(!charList.contains(c)){
                charList.add(c);
                if(charList.size() > count)
                {
                    count = charList.size();
                    longestString = charList.stream().map(Object::toString).collect(Collectors.joining());
                }
            }
            else {

                charList.clear();
                charList.add(c);
            }
        }
        System.out.println("The longest string is: " + longestString + " with a length of " + longestString.length());
    }
}
