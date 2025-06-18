import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Original O(n²) solution - Brute Force
    public int[] twoSumBruteForce(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    int a[] = {i, j};
                    return a;
                }
            }
        }
        return null;
    }
    
    // Optimized O(n) solution - HashMap
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(numbers[i], i);
        }
        
        return null; // This should never be reached given the problem constraints
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: [2,7,11,15], target = 9
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [0, 1]");
        System.out.println();
        
        // Test case 2: [3,2,4], target = 6
        int[] numbers2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [1, 2]");
        System.out.println();
        
        // Test case 3: [3,3], target = 6
        int[] numbers3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Test Case 3:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: [0, 1]");
        System.out.println();
        
        // Performance comparison for larger arrays
        System.out.println("Performance comparison:");
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int largeTarget = 19;
        
        long startTime = System.nanoTime();
        solution.twoSumBruteForce(largeArray, largeTarget);
        long bruteForceTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        solution.twoSum(largeArray, largeTarget);
        long hashMapTime = System.nanoTime() - startTime;
        
        System.out.println("Brute Force time: " + bruteForceTime + " ns");
        System.out.println("HashMap time: " + hashMapTime + " ns");
    }
}