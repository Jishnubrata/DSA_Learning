import java.util.Arrays;

public class RemoveDuplicates {
    
    /**
     * Remove duplicates from sorted array in-place
     * @param nums sorted integer array
     * @return number of unique elements
     */
    public static int removeDuplicates(int[] nums) {
        // Handle edge case
        if (nums.length == 0) return 0;
        
        // i points to the position where next unique element should be placed
        int i = 0;
        
        // j iterates through the array starting from index 1
        for (int j = 1; j < nums.length; j++) {
            // If current element is different from the previous unique element
            if (nums[j] != nums[i]) {
                // Move i to next position and place the unique element
                i++;
                nums[i] = nums[j];
            }
        }
        
        // Return the count of unique elements (i+1 since i is 0-indexed)
        return i + 1;
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
        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        printResult(nums1, k1, "Test Case 1:");
        
        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        printResult(nums2, k2, "Test Case 2:");
        
        // Test Case 3 - Edge case: single element
        int[] nums3 = {1};
        int k3 = removeDuplicates(nums3);
        printResult(nums3, k3, "Test Case 3 (Single element):");
        
        // Test Case 4 - All same elements
        int[] nums4 = {1, 1, 1, 1};
        int k4 = removeDuplicates(nums4);
        printResult(nums4, k4, "Test Case 4 (All same elements):");
        
        // Test Case 5 - No duplicates
        int[] nums5 = {1, 2, 3, 4, 5};
        int k5 = removeDuplicates(nums5);
        printResult(nums5, k5, "Test Case 5 (No duplicates):");
        
        // Test Case 6 - Negative numbers
        int[] nums6 = {-3, -3, -2, -1, -1, 0, 0, 0, 1, 1, 2};
        int k6 = removeDuplicates(nums6);
        printResult(nums6, k6, "Test Case 6 (With negative numbers):");
        
        // Demonstrate the custom judge logic
        System.out.println("=== Custom Judge Simulation ===");
        int[] testNums = {1, 1, 2, 2, 3};
        int[] expectedNums = {1, 2, 3};
        int k = removeDuplicates(testNums);
        
        System.out.println("Original array: " + Arrays.toString(testNums));
        System.out.println("Expected result: " + Arrays.toString(expectedNums));
        System.out.println("Returned k: " + k);
        
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
    }
}