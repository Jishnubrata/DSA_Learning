class MergeSortedArray {
    
    public static void merge(int[] number1, int m, int[] number2, int n) {
        // Start from the end of both arrays
        int i = m - 1;  // Last element in number1
        int j = n - 1;  // Last element in number2
        int k = m + n - 1;  // Last position in number1
        
        // Merge from the end to avoid overwriting elements
        while (i >= 0 && j >= 0) {
            if (number1[i] > number2[j]) {
                number1[k] = number1[i];
                i--;
            } else {
                number1[k] = number2[j];
                j--;
            }
            k--;
        }
        
        // Copy remaining elements from number2 if any
        while (j >= 0) {
            number1[k] = number2[j];
            j--;
            k--;
        }
        
        // No need to copy remaining elements from number1 
        // as they are already in the correct position
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] number1 = {1, 2, 3, 0, 0, 0};
        int[] number2 = {2, 5, 6};
        int m = 3, n = 3;
        
        System.out.println("Before merge:");
        System.out.print("number1: ");
        printArray(number1);
        System.out.print("number2: ");
        printArray(number2);
        
        merge(number1, m, number2, n);
        
        System.out.println("After merge:");
        System.out.print("Result: ");
        printArray(number1);
        System.out.println();
        
        // Test Case 2
        int[] number1_2 = {1};
        int[] number2_2 = {};
        int m2 = 1, n2 = 0;
        
        System.out.println("Test Case 2:");
        System.out.print("Before: ");
        printArray(number1_2);
        merge(number1_2, m2, number2_2, n2);
        System.out.print("After: ");
        printArray(number1_2);
        System.out.println();
        
        // Test Case 3
        int[] number1_3 = {0};
        int[] number2_3 = {1};
        int m3 = 0, n3 = 1;
        
        System.out.println("Test Case 3:");
        System.out.print("Before: number1 = ");
        printArray(number1_3);
        System.out.print("number2 = ");
        printArray(number2_3);
        merge(number1_3, m3, number2_3, n3);
        System.out.print("After: ");
        printArray(number1_3);
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}