class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0; // Initialize count to keep track of consecutive odd numbers

        for (int i = 0; i < arr.length; i++) { // Iterate through each element in the array
            if (arr[i] % 2 != 0) { // Check if the current element is odd
                count++; // Increment the count if it's odd
                if (count == 3) { // If we have found three consecutive odds, return true
                    return true;
                }
            } else { // If the element is even, reset the count to 0
                count = 0;
            }
        }

        return false; // If we finish the loop without finding three consecutive odds, return false
    }
}