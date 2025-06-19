import java.util.Arrays;

public class RemoveDuplicatesII {
    
    /**
     * Remove duplicates from sorted array in-place, allowing at most 2 occurrences
     * @param nums sorted integer array
     * @return number of elements after removing excess duplicates
     */
    public static int removeDuplicates(int[] nums) {
        // Handle edge cases
        if (nums.length <= 2) return nums.length;
        
        // i points to the position where next valid element should be placed
        int i = 2; // Start from index 2 since first 2 elements are always valid
        
        // j iterates through the array starting from index 2
        for (int j = 2; j < nums.length; j++) {
            // If current element is different from the element at position i-2,
            // it means we can safely place it at position i (at most 2 occurrences)
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
    
    /**
     * Alternative solution using a counter approach
     */
    public static int removeDuplicatesCounter(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int i = 1; // Position for next valid element
        int count = 1; // Count of current element
        
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1; // Reset count for new element
            }
            
            // Only place element if count <= 2
            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
    
    /**
     * Helper method to print array results
     */
    public static void printResult(int[] nums, int k, String testCase) {
        System.out.println(testCase);
        System.out.print("k = " + k + ", nums = [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== SOLUTION 1: Two-Pointer Approach ===\n");
        
        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = removeDuplicates(nums1.clone());
        printResult(nums1, k1, "Test Case 1: [1,1,1,2,2,3]");
        
        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = removeDuplicates(nums2.clone());
        printResult(nums2, k2, "Test Case 2: [0,0,1,1,1,1,2,3,3]");
        
        // Test Case 3 - Edge case: length <= 2
        int[] nums3 = {1, 1};
        int k3 = removeDuplicates(nums3.clone());
        printResult(nums3, k3, "Test Case 3 (Length 2): [1,1]");
        
        // Test Case 4 - Single element
        int[] nums4 = {1};
        int k4 = removeDuplicates(nums4.clone());
        printResult(nums4, k4, "Test Case 4 (Single element): [1]");
        
        // Test Case 5 - All same elements
        int[] nums5 = {1, 1, 1, 1, 1};
        int k5 = removeDuplicates(nums5.clone());
        printResult(nums5, k5, "Test Case 5 (All same): [1,1,1,1,1]");
        
        // Test Case 6 - No duplicates
        int[] nums6 = {1, 2, 3, 4, 5};
        int k6 = removeDuplicates(nums6.clone());
        printResult(nums6, k6, "Test Case 6 (No duplicates): [1,2,3,4,5]");
        
        // Test Case 7 - With negative numbers
        int[] nums7 = {-3, -3, -3, -2, -1, -1, 0, 0, 0, 1, 1, 2};
        int k7 = removeDuplicates(nums7.clone());
        printResult(nums7, k7, "Test Case 7 (With negatives): [-3,-3,-3,-2,-1,-1,0,0,0,1,1,2]");
        
        System.out.println("\n=== SOLUTION 2: Counter Approach ===\n");
        
        // Test same cases with counter approach
        int[] nums8 = {1, 1, 1, 2, 2, 3};
        int k8 = removeDuplicatesCounter(nums8.clone());
        printResult(nums8, k8, "Counter Approach - Test Case 1: [1,1,1,2,2,3]");
        
        int[] nums9 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k9 = removeDuplicatesCounter(nums9.clone());
        printResult(nums9, k9, "Counter Approach - Test Case 2: [0,0,1,1,1,1,2,3,3]");
        
        // Demonstrate the custom judge logic
        System.out.println("=== Custom Judge Simulation ===");
        int[] testNums = {1, 1, 1, 2, 2, 3};
        int[] originalNums = testNums.clone();
        int[] expectedNums = {1, 1, 2, 2, 3};
        int k = removeDuplicates(testNums);
        
        System.out.println("Original array: " + Arrays.toString(originalNums));
        System.out.println("Expected result: " + Arrays.toString(expectedNums));
        System.out.println("Returned k: " + k);
        System.out.println("Modified array (first k elements): " + Arrays.toString(Arrays.copyOf(testNums, k)));
        
        // Judge assertions
        boolean lengthCheck = k == expectedNums.length;
        boolean elementsCheck = true;
        
        for (int i = 0; i < k; i++) {
            if (testNums[i] != expectedNums[i]) {
                elementsCheck = false;
                break;
            }
        }
        
        System.out.println("Length check passed: " + lengthCheck);
        System.out.println("Elements check passed: " + elementsCheck);
        System.out.println("Overall result: " + (lengthCheck && elementsCheck ? "ACCEPTED" : "REJECTED"));
        
        System.out.println("\n=== Algorithm Explanation ===");
        System.out.println("Two-Pointer Approach:");
        System.out.println("1. Start with i=2 (first 2 elements are always valid)");
        System.out.println("2. Compare nums[j] with nums[i-2]");
        System.out.println("3. If different, place nums[j] at position i and increment i");
        System.out.println("4. This ensures at most 2 occurrences of each element");
        System.out.println("\nTime Complexity: O(n)");
        System.out.println("Space Complexity: O(1)");
    }
}