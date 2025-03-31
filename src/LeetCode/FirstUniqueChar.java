package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/// 387. First Unique Character in a String
/// Easy
/// Topics
/// Companies
/// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
/// Example 1:
/// Input: s = "leetcode"
/// Output: 0
/// Explanation:
/// The character 'l' at index 0 is the first character that does not occur at any other index.
/// Example 2:
/// Input: s = "loveleetcode"
/// Output: 2
/// Example 3:
/// Input: s = "aabb"
/// Output: -1
/// Constraints:
/// 1 <= s.length <= 105
/// s consists of only lowercase English letters.
/// 

public class FirstUniqueChar {
    public FirstUniqueChar() {

        System.out.println("First unique char position for 'leetcode' is :  " + firstUniqueChar("leetcode"));
        System.out.println("First unique char position for 'leetcode' is :  " + firstUniqueChar("loveleetcode"));
        System.out.println("First unique char position for 'leetcode' is :  " + firstUniqueChar("leetcodeleetcode"));
    }

    private Integer firstUniqueChar(String s) {

        HashMap<Character, Integer> foundLetters = new HashMap<>();
        ArrayList<Character> letters = new ArrayList<>();
        int i=0;
        for(Character c: s.toCharArray())
        {
            if(foundLetters.containsKey(c))
            {
                letters.remove(c);
            }
            else {
                letters.add(c);
                foundLetters.put(c,i);
            }
            i++;
        }
        return letters.isEmpty() ? -1 : foundLetters.get(letters.getFirst());

    }
}
