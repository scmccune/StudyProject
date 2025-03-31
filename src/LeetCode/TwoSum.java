package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
///
/// You may assume that each input would have exactly one solution, and you may not use the same element twice.
///
/// You can return the answer in any order.
///
///
///
/// Example 1:
///
/// Input: nums = [2,7,11,15], target = 9
/// Output: [0,1]
/// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
/// Example 2:
///
/// Input: nums = [3,2,4], target = 6
/// Output: [1,2]
/// Example 3:
///
/// Input: nums = [3,3], target = 6
/// Output: [0,1]
///
///
/// Constraints:
///
/// 2 <= nums.length <= 104
/// -109 <= nums[i] <= 109
/// -109 <= target <= 109
/// Only one valid answer exists.

public class TwoSum {
    public TwoSum(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        System.out.println("indicies = " + twoSum[0] + " and " + twoSum[1]);

    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> checkedNumbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(checkedNumbers.containsKey(target-nums[i])) {
                return new int[]{checkedNumbers.get(target-nums[i]), i};
            }
            checkedNumbers.put(nums[i], i);
        }
        return new int[]{};
    }
}
