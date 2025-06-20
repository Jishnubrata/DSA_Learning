import java.util.*;

/**
 * Majority Element - Multiple Java Solutions
 * 
 * Problem: Find the element that appears more than ⌊n/2⌋ times
 * Given that majority element always exists
 */
public class MajorityElement {
    
    // Approach 1: Hash Map (Frequency Count)
    // Time: O(n), Space: O(n)
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int majority = nums.length / 2;
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > majority) {
                return num;
            }
        }
        return -1; // Should never reach here given problem constraints
    }
    
    // Approach 2: Sorting (Clean Version - LeetCode Style)
    // Time: O(n log n), Space: O(1)
    public static int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
    
    // LeetCode Solution Class Format
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return(nums[n/2]);
        }
    }
    
    // Approach 3: Boyer-Moore Voting Algorithm (Optimal)
    // Time: O(n), Space: O(1)
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        // Phase 1: Find candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
        
        // Phase 2 (verification) is not needed since problem guarantees majority exists
        // But here's how you would verify:
        /*
        int actualCount = 0;
        for (int num : nums) {
            if (num == candidate) actualCount++;
        }
        return actualCount > nums.length / 2 ? candidate : -1;
        */
    }
    
    // Alternative Boyer-Moore implementation with cleaner logic
    public static int majorityElementClean(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Majority Element Solutions ===\n");
        
        // Test cases
        int[][] testCases = {
            {3, 2, 3},
            {2, 2, 1, 1, 1, 2, 2},
            {1},
            {1, 1, 2, 2, 2},
            {5, 5, 5, 3, 3, 5, 5}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.print("Input: ");
            printArray(nums);
            
            // Test all approaches (create copies since sorting modifies array)
            int[] copy1 = nums.clone();
            int[] copy2 = nums.clone();
            int[] copy3 = nums.clone();
            int[] copy4 = nums.clone();
            
            System.out.println("HashMap:     " + majorityElementHashMap(copy1));
            System.out.println("Sorting:     " + majorityElementSorting(copy2));
            // Also test the LeetCode Solution class
            Solution solution = new Solution();
            System.out.println("LeetCode:    " + solution.majorityElement(nums.clone()));
            System.out.println("Boyer-Moore: " + majorityElement(copy3));
            System.out.println("Clean B-M:   " + majorityElementClean(copy4));
            System.out.println();
        }
        
        // Demonstration of Boyer-Moore algorithm step by step
        System.out.println("=== Boyer-Moore Algorithm Walkthrough ===");
        int[] demo = {2, 2, 1, 1, 1, 2, 2};
        System.out.print("Array: ");
        printArray(demo);
        System.out.println();
        
        int candidate = demo[0];
        int count = 1;
        System.out.println("Start: candidate=" + candidate + ", count=" + count);
        
        for (int i = 1; i < demo.length; i++) {
            if (count == 0) {
                candidate = demo[i];
                count = 1;
                System.out.println("Reset: candidate=" + candidate + ", count=" + count + " (element: " + demo[i] + ")");
            } else if (demo[i] == candidate) {
                count++;
                System.out.println("Match: candidate=" + candidate + ", count=" + count + " (element: " + demo[i] + ")");
            } else {
                count--;
                System.out.println("Diff:  candidate=" + candidate + ", count=" + count + " (element: " + demo[i] + ")");
            }
        }
        
        System.out.println("\nFinal majority element: " + candidate);
        System.out.println();
        
        // Complexity analysis
        System.out.println("=== Complexity Analysis ===");
        System.out.println("1. HashMap Approach:");
        System.out.println("   Time: O(n), Space: O(n)");
        System.out.println("   - Good for general case, easy to understand");
        System.out.println();
        
        System.out.println("2. Sorting Approach (Your Solution):");
        System.out.println("   Time: O(n log n), Space: O(1)");
        System.out.println("   - Very clean and elegant solution");
        System.out.println("   - Works because majority element always occupies middle position after sorting");
        System.out.println("   - Perfect for LeetCode submissions - simple and readable");
        System.out.println();
        
        System.out.println("3. Boyer-Moore Voting:");
        System.out.println("   Time: O(n), Space: O(1)");
        System.out.println("   - Optimal solution for the follow-up requirement");
        System.out.println("   - Key insight: majority element survives cancellation");
    }
}